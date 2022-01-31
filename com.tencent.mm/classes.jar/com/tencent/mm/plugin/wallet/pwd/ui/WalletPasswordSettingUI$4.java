package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPasswordSettingUI$4
  implements DialogInterface.OnCancelListener
{
  WalletPasswordSettingUI$4(WalletPasswordSettingUI paramWalletPasswordSettingUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(46351);
    if (WalletPasswordSettingUI.g(this.tZZ) != null) {
      WalletPasswordSettingUI.g(this.tZZ).dismiss();
    }
    AppMethodBeat.o(46351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.4
 * JD-Core Version:    0.7.0.1
 */