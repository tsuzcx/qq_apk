package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class WalletOfflineCoinPurseUI$17
  implements DialogInterface.OnDismissListener
{
  WalletOfflineCoinPurseUI$17(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.mNy != null) {
      this.mNy.onDismiss(paramDialogInterface);
    }
    if (WalletOfflineCoinPurseUI.B(this.mNj))
    {
      WalletOfflineCoinPurseUI.a(this.mNj);
      WalletOfflineCoinPurseUI.C(this.mNj);
      WalletOfflineCoinPurseUI.D(this.mNj);
      WalletOfflineCoinPurseUI.E(this.mNj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.17
 * JD-Core Version:    0.7.0.1
 */