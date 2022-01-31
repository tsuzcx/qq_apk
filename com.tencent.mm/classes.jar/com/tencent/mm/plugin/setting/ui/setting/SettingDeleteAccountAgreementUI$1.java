package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingDeleteAccountAgreementUI$1
  implements View.OnClickListener
{
  SettingDeleteAccountAgreementUI$1(SettingDeleteAccountAgreementUI paramSettingDeleteAccountAgreementUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127061);
    this.qGJ.startActivity(new Intent(this.qGJ, SettingDeleteAccountInputPassUI.class));
    AppMethodBeat.o(127061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI.1
 * JD-Core Version:    0.7.0.1
 */