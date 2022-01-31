package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.sdk.platformtools.y;

final class WalletLqtCheckPwdInputDialogUI$3
  implements DialogInterface.OnCancelListener
{
  WalletLqtCheckPwdInputDialogUI$3(WalletLqtCheckPwdInputDialogUI paramWalletLqtCheckPwdInputDialogUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
    WalletLqtCheckPwdInputDialogUI.a(this.qhM).dismiss();
    this.qhM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI.3
 * JD-Core Version:    0.7.0.1
 */