package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;

final class SettingDeleteAccountAgreementUI$2
  implements View.OnClickListener
{
  SettingDeleteAccountAgreementUI$2(SettingDeleteAccountAgreementUI paramSettingDeleteAccountAgreementUI, TextView paramTextView, CheckedTextView paramCheckedTextView) {}
  
  public final void onClick(View paramView)
  {
    this.nSP.setEnabled(this.nSQ.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI.2
 * JD-Core Version:    0.7.0.1
 */