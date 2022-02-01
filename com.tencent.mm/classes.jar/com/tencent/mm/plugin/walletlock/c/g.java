package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.soter.core.c.j;

public enum g
{
  public String DNG;
  public j DNH;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    DNF = new g("instance");
    DNI = new g[] { DNF };
    AppMethodBeat.o(129933);
  }
  
  private g() {}
  
  public static void eNJ()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uL(true);
    AppMethodBeat.o(129924);
  }
  
  public static void eNK()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uM(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean eNL()
  {
    AppMethodBeat.i(129931);
    if ((eNM()) && (m.ejs()) && (com.tencent.soter.core.a.fi(ak.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean eNM()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public static boolean eNa()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.eNa();
    ae.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean eNb()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.eNb();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void eNd()
  {
    AppMethodBeat.i(129930);
    d.eNd();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.eNd();
    AppMethodBeat.o(129930);
  }
  
  public static boolean eNm()
  {
    AppMethodBeat.i(129921);
    boolean bool = b.eNm();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static void uO(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    b.uO(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void uP(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    ae.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    uQ(paramBoolean);
    b.uO(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uM(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.eMZ();
    }
    AppMethodBeat.o(129927);
  }
  
  public static void uQ(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.uL(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.eMZ();
    }
    AppMethodBeat.o(129928);
  }
  
  public final void Wy(int paramInt)
  {
    AppMethodBeat.i(129919);
    ae.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVC, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.ajR().ajA().fuc();
    AppMethodBeat.o(129919);
  }
  
  public final boolean eMX()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.eNn();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      ae.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.eNc()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.eNc();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
  
  public final int eNI()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVC, Integer.valueOf(0))).intValue();
    }
    int i = this.mType;
    AppMethodBeat.o(129920);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.g
 * JD-Core Version:    0.7.0.1
 */