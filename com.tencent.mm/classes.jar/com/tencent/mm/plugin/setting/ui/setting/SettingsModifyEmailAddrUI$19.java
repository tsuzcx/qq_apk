package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;

final class SettingsModifyEmailAddrUI$19
  implements DialogInterface.OnClickListener
{
  SettingsModifyEmailAddrUI$19(SettingsModifyEmailAddrUI paramSettingsModifyEmailAddrUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127283);
    paramDialogInterface = new Intent(this.qIZ, RegByMobileSetPwdUI.class);
    paramDialogInterface.putExtra("kintent_hint", this.qIZ.getString(2131303496));
    paramDialogInterface.putExtra("from_unbind", true);
    this.qIZ.startActivityForResult(paramDialogInterface, 1);
    AppMethodBeat.o(127283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.19
 * JD-Core Version:    0.7.0.1
 */