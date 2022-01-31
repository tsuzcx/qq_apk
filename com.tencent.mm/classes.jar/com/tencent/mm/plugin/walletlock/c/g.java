package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.soter.core.c.j;

public enum g
{
  int mType = -1;
  public String uGi;
  public j uGj;
  
  static
  {
    AppMethodBeat.i(51731);
    uGh = new g("instance");
    uGk = new g[] { uGh };
    AppMethodBeat.o(51731);
  }
  
  private g() {}
  
  public static void cXB()
  {
    AppMethodBeat.i(51728);
    d.cXB();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXB();
    AppMethodBeat.o(51728);
  }
  
  public static boolean cXK()
  {
    AppMethodBeat.i(51719);
    boolean bool = b.cXK();
    AppMethodBeat.o(51719);
    return bool;
  }
  
  public static boolean cXy()
  {
    AppMethodBeat.i(51721);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXy();
    ab.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(51721);
    return bool;
  }
  
  public static boolean cXz()
  {
    AppMethodBeat.i(51723);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXz();
    AppMethodBeat.o(51723);
    return bool;
  }
  
  public static void cYh()
  {
    AppMethodBeat.i(51722);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.nX(true);
    AppMethodBeat.o(51722);
  }
  
  public static void cYi()
  {
    AppMethodBeat.i(51724);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.nY(true);
    AppMethodBeat.o(51724);
  }
  
  public static boolean cYj()
  {
    AppMethodBeat.i(51729);
    if ((cYk()) && (m.cyg()) && (com.tencent.soter.core.a.jg(ah.getContext())))
    {
      AppMethodBeat.o(51729);
      return true;
    }
    AppMethodBeat.o(51729);
    return false;
  }
  
  public static boolean cYk()
  {
    AppMethodBeat.i(51730);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(51730);
      return true;
    }
    AppMethodBeat.o(51730);
    return false;
  }
  
  public static void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(51720);
    b.oa(paramBoolean);
    AppMethodBeat.o(51720);
  }
  
  public static void ob(boolean paramBoolean)
  {
    AppMethodBeat.i(51725);
    ab.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    oc(paramBoolean);
    b.oa(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.nY(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXx();
    }
    AppMethodBeat.o(51725);
  }
  
  public static void oc(boolean paramBoolean)
  {
    AppMethodBeat.i(51726);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.nX(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXx();
    }
    AppMethodBeat.o(51726);
  }
  
  public final void IQ(int paramInt)
  {
    AppMethodBeat.i(51717);
    ab.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHW, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.RL().Ru().dww();
    AppMethodBeat.o(51717);
  }
  
  public final boolean cXv()
  {
    AppMethodBeat.i(51727);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.cXL();
      AppMethodBeat.o(51727);
      return bool;
    }
    if (this.mType == 2)
    {
      ab.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXA()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.cXA();
      AppMethodBeat.o(51727);
      return bool;
    }
    AppMethodBeat.o(51727);
    return false;
  }
  
  public final int cYg()
  {
    AppMethodBeat.i(51718);
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHW, Integer.valueOf(0))).intValue();
    }
    int i = this.mType;
    AppMethodBeat.o(51718);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.g
 * JD-Core Version:    0.7.0.1
 */