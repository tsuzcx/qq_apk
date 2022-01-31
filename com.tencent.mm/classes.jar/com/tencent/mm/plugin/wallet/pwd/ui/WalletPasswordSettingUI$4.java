package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class WalletPasswordSettingUI$4
  implements DialogInterface.OnCancelListener
{
  WalletPasswordSettingUI$4(WalletPasswordSettingUI paramWalletPasswordSettingUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (WalletPasswordSettingUI.h(this.qpD) != null) {
      WalletPasswordSettingUI.h(this.qpD).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.4
 * JD-Core Version:    0.7.0.1
 */