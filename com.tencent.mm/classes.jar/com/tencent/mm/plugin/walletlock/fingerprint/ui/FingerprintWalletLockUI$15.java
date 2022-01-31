package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerprintWalletLockUI$15
  implements DialogInterface.OnClickListener
{
  FingerprintWalletLockUI$15(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51512);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
    ((b)g.E(b.class)).b(this.uEG, 1, 4);
    AppMethodBeat.o(51512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.15
 * JD-Core Version:    0.7.0.1
 */