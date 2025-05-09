package com.kieronquinn.app.taptap.ui.screens.settings.gates.help

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.kieronquinn.app.taptap.R
import com.kieronquinn.app.taptap.databinding.FragmentSettingsGatesHelpBinding
import com.kieronquinn.app.taptap.ui.base.BaseBottomSheetFragment
import com.kieronquinn.app.taptap.utils.extensions.onApplyInsets
import com.kieronquinn.app.taptap.utils.extensions.onClicked
import com.kieronquinn.app.taptap.utils.extensions.whenResumed

class SettingsGatesHelpBottomSheetFragment: BaseBottomSheetFragment<FragmentSettingsGatesHelpBinding>(FragmentSettingsGatesHelpBinding::inflate) {

    private val accent by lazy {
        monet.getAccentColor(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInsets(view)
        setupButtons()
    }

    private fun setupInsets(view: View) {
        binding.root.onApplyInsets { _, insets ->
            val bottomPadding = resources.getDimension(R.dimen.margin_16).toInt()
            val bottomInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            view.updatePadding(bottom = bottomInset + bottomPadding)
        }
    }

    private fun setupButtons(){
        binding.settingsGatesHelpPositive.setTextColor(accent)
        whenResumed {
            binding.settingsGatesHelpPositive.onClicked().collect {
                dismiss()
            }
        }
    }

}