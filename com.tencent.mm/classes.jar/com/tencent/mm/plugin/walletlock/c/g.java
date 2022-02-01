package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.soter.core.c.j;

public enum g
{
  public String Dwb;
  public j Dwc;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    Dwa = new g("instance");
    Dwd = new g[] { Dwa };
    AppMethodBeat.o(129933);
  }
  
  private g() {}
  
  public static boolean eJE()
  {
    AppMethodBeat.i(129921);
    boolean bool = b.eJE();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static boolean eJs()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJs();
    ad.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean eJt()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJt();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void eJv()
  {
    AppMethodBeat.i(129930);
    d.eJv();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJv();
    AppMethodBeat.o(129930);
  }
  
  public static void eKb()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uD(true);
    AppMethodBeat.o(129924);
  }
  
  public static void eKc()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uE(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean eKd()
  {
    AppMethodBeat.i(129931);
    if ((eKe()) && (m.efK()) && (com.tencent.soter.core.a.fe(aj.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean eKe()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public static void uG(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    b.uG(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void uH(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    ad.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    uI(paramBoolean);
    b.uG(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uE(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJr();
    }
    AppMethodBeat.o(129927);
  }
  
  public static void uI(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uD(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJr();
    }
    AppMethodBeat.o(129928);
  }
  
  public final void VR(int paramInt)
  {
    AppMethodBeat.i(129919);
    ad.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IBd, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.ajC().ajl().fqc();
    AppMethodBeat.o(129919);
  }
  
  public final boolean eJp()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.eJF();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      ad.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJu()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.eJu();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
  
  public final int eKa()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBd, Integer.valueOf(0))).intValue();
    }
    int i = this.mType;
    AppMethodBeat.o(129920);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.g
 * JD-Core Version:    0.7.0.1
 */