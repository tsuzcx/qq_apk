package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerprintWalletLockUI$2
  implements DialogInterface.OnClickListener
{
  FingerprintWalletLockUI$2(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51499);
    ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
    ((b)g.E(b.class)).k(this.uEG, 5);
    AppMethodBeat.o(51499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.2
 * JD-Core Version:    0.7.0.1
 */