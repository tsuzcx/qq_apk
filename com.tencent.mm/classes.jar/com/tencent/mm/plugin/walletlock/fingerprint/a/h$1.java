package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.sdk.platformtools.y;

public final class h$1
  implements com.tencent.soter.a.a.b
{
  public h$1(h paramh, com.tencent.mm.plugin.walletlock.c.b paramb) {}
  
  public final void aTd()
  {
    y.v("MicroMsg.SoterFingerprintAuthManager", "alvinluo onStartAuthentication");
    if (this.qPl != null) {
      this.qPl.bYb();
    }
  }
  
  public final void aTe()
  {
    y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationSucceed");
    this.qPm.qPk = null;
  }
  
  public final void onAuthenticationCancelled()
  {
    y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationCancelled");
    this.qPm.qPk = null;
  }
  
  public final void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
    this.qPm.qPk = null;
  }
  
  public final void onAuthenticationFailed()
  {
    y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationFailed");
    if (this.qPl != null) {
      this.qPl.J(1, "not match");
    }
  }
  
  public final void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    y.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationHelp errCode: %d, errMsg: %s and do nothing", new Object[] { Integer.valueOf(paramInt), paramCharSequence });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.h.1
 * JD-Core Version:    0.7.0.1
 */