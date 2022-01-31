package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerprintWalletLockUI$11
  implements DialogInterface.OnClickListener
{
  FingerprintWalletLockUI$11(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51508);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo click negative button");
    AppMethodBeat.o(51508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.11
 * JD-Core Version:    0.7.0.1
 */