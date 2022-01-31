package com.tencent.mm.plugin.walletlock.fingerprint.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FingerprintWalletLockUI$10
  implements d.a
{
  FingerprintWalletLockUI$10(FingerprintWalletLockUI paramFingerprintWalletLockUI) {}
  
  public final void aC(int paramInt, String paramString)
  {
    AppMethodBeat.i(51507);
    ab.i("MicroMsg.FingerprintWalletLockUI", "prepare onFinish errCode: %d, errMsg: %s, time: %d", new Object[] { Integer.valueOf(paramInt), paramString, Long.valueOf(System.currentTimeMillis()) });
    if (FingerprintWalletLockUI.c(this.uEG))
    {
      ab.i("MicroMsg.FingerprintWalletLockUI", "alvinluo has cancelled and return");
      AppMethodBeat.o(51507);
      return;
    }
    if (paramInt == 0)
    {
      FingerprintWalletLockUI.h(this.uEG);
      AppMethodBeat.o(51507);
      return;
    }
    FingerprintWalletLockUI.b(this.uEG, this.uEG.getString(2131305154));
    AppMethodBeat.o(51507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI.10
 * JD-Core Version:    0.7.0.1
 */