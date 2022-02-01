package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.soter.core.c.j;

public enum g
{
  public String ADm;
  public j ADn;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    ADl = new g("instance");
    ADo = new g[] { ADl };
    AppMethodBeat.o(129933);
  }
  
  private g() {}
  
  public static boolean efS()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.efS();
    ad.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean efT()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.efT();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void efV()
  {
    AppMethodBeat.i(129930);
    d.efV();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.efV();
    AppMethodBeat.o(129930);
  }
  
  public static void egB()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.sS(true);
    AppMethodBeat.o(129924);
  }
  
  public static void egC()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.sT(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean egD()
  {
    AppMethodBeat.i(129931);
    if ((egE()) && (m.dEV()) && (com.tencent.soter.core.a.eO(aj.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean egE()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public static boolean ege()
  {
    AppMethodBeat.i(129921);
    boolean bool = b.ege();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    b.sV(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void sW(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    ad.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    sX(paramBoolean);
    b.sV(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.sT(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.efR();
    }
    AppMethodBeat.o(129927);
  }
  
  public static void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.sS(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.efR();
    }
    AppMethodBeat.o(129928);
  }
  
  public final void RP(int paramInt)
  {
    AppMethodBeat.i(129919);
    ad.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqS, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.afB().afk().eKy();
    AppMethodBeat.o(129919);
  }
  
  public final boolean efP()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.egf();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      ad.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.efU()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.efU();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
  
  public final int egA()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqS, Integer.valueOf(0))).intValue();
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