package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FingerprintWalletLockUI$8
  implements View.OnClickListener
{
  FingerprintWalletLockUI$8(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51505);
    FingerprintWalletLockUI.cXH();
    FingerprintWalletLockUI.a(this.uEG, "user cancel setting fingerprint lock");
    AppMethodBeat.o(51505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.8
 * JD-Core Version:    0.7.0.1
 */