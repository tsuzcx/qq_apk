package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class FingerprintWalletLockUI$8
  implements d.a
{
  FingerprintWalletLockUI$8(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void ai(int paramInt, String paramString)
  {
    y.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramInt), paramString, Long.valueOf(System.currentTimeMillis()) });
    if (FingerprintWalletLockUI.c(this.qPy))
    {
      y.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
      return;
    }
    if (paramInt == 0)
    {
      FingerprintWalletLockUI.h(this.qPy);
      return;
    }
    FingerprintWalletLockUI.b(this.qPy, this.qPy.getString(a.g.wallet_lock_fingerprint_system_error));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.8
 * JD-Core Version:    0.7.0.1
 */