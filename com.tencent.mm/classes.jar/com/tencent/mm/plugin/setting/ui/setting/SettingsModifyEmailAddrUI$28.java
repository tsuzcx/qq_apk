package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;

final class SettingsModifyEmailAddrUI$28
  implements DialogInterface.OnClickListener
{
  SettingsModifyEmailAddrUI$28(SettingsModifyEmailAddrUI paramSettingsModifyEmailAddrUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.nUU, RegByMobileSetPwdUI.class);
    paramDialogInterface.putExtra("kintent_hint", this.nUU.getString(a.i.settings_unbind_set_password_tip));
    paramDialogInterface.putExtra("from_unbind", true);
    this.nUU.startActivityForResult(paramDialogInterface, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI.28
 * JD-Core Version:    0.7.0.1
 */