package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;

final class WalletChangeBankcardUI$7
  implements DialogInterface.OnCancelListener
{
  WalletChangeBankcardUI$7(WalletChangeBankcardUI paramWalletChangeBankcardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.qmD.frT = null;
    if (WalletChangeBankcardUI.b(this.qmD).getVisibility() != 0) {
      this.qmD.aSr();
    }
    this.qmD.qmC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI.7
 * JD-Core Version:    0.7.0.1
 */