package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class FingerprintWalletLockUI$13
  implements DialogInterface.OnClickListener
{
  FingerprintWalletLockUI$13(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo user click set gesture");
    ((b)g.r(b.class)).b(this.qPy, 1, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.13
 * JD-Core Version:    0.7.0.1
 */