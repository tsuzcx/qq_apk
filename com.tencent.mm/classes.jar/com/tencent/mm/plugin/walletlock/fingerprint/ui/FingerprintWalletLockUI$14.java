package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerprintWalletLockUI$14
  implements DialogInterface.OnCancelListener
{
  FingerprintWalletLockUI$14(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(51511);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo cancel not support fingerprint dialog");
    this.uEG.finish();
    FingerprintWalletLockUI.cXH();
    AppMethodBeat.o(51511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.14
 * JD-Core Version:    0.7.0.1
 */