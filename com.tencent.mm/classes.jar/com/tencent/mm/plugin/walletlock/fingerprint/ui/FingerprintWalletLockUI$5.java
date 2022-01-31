package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class FingerprintWalletLockUI$5
  implements d.a
{
  FingerprintWalletLockUI$5(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void ai(int paramInt, String paramString)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo open fingerprint lock onFinish errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt == 0)
    {
      FingerprintWalletLockUI.k(this.qPy);
      return;
    }
    FingerprintWalletLockUI.b(this.qPy, this.qPy.getString(a.g.wallet_lock_fingerprint_open_failed));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.5
 * JD-Core Version:    0.7.0.1
 */