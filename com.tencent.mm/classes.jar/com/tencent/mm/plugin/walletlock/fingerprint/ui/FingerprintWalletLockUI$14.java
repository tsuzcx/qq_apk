package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class FingerprintWalletLockUI$14
  implements DialogInterface.OnClickListener
{
  FingerprintWalletLockUI$14(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click close wallet lock");
    ((b)g.r(b.class)).h(this.qPy, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.14
 * JD-Core Version:    0.7.0.1
 */