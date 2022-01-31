package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class FingerprintWalletLockUI$12
  implements DialogInterface.OnCancelListener
{
  FingerprintWalletLockUI$12(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
    this.qPy.finish();
    FingerprintWalletLockUI.bXZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.12
 * JD-Core Version:    0.7.0.1
 */