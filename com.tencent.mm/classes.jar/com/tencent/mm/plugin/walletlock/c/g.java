package com.tencent.mm.plugin.walletlock.c;

import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.soter.core.c.j;

public enum g
{
  int mType = -1;
  public String qRa;
  public j qRb;
  
  private g() {}
  
  public static boolean bXQ()
  {
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXQ();
    y.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean bXR()
  {
    return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXR();
  }
  
  public static void bXT()
  {
    d.bXT();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXT();
  }
  
  public static boolean bYA()
  {
    return ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("TouchLockFunction", 0) != 1;
  }
  
  public static boolean bYc()
  {
    return b.bYc();
  }
  
  public static void bYx()
  {
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.kO(true);
  }
  
  public static void bYy()
  {
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.kP(true);
  }
  
  public static boolean bYz()
  {
    return (bYA()) && (m.bKV()) && (com.tencent.soter.core.a.hF(ae.getContext()));
  }
  
  public static void kR(boolean paramBoolean)
  {
    b.kR(paramBoolean);
  }
  
  public static void kS(boolean paramBoolean)
  {
    y.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    kT(paramBoolean);
    b.kR(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.kP(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXP();
    }
  }
  
  public static void kT(boolean paramBoolean)
  {
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.kO(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXP();
    }
  }
  
  public final void Be(int paramInt)
  {
    y.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxM, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.DP().Dz().mC(true);
  }
  
  public final boolean bXN()
  {
    boolean bool = false;
    if (this.mType == 1) {
      bool = b.bYd();
    }
    while (this.mType != 2) {
      return bool;
    }
    y.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXS()) });
    return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bXS();
  }
  
  public final int bYw()
  {
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxM, Integer.valueOf(0))).intValue();
    }
    return this.mType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.g
 * JD-Core Version:    0.7.0.1
 */