package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.soter.core.c.j;

public enum g
{
  public String BVH;
  public j BVI;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    BVG = new g("instance");
    BVJ = new g[] { BVG };
    AppMethodBeat.o(129933);
  }
  
  private g() {}
  
  public static void evV()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.tT(true);
    AppMethodBeat.o(129924);
  }
  
  public static void evW()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.tU(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean evX()
  {
    AppMethodBeat.i(129931);
    if ((evY()) && (m.dTw()) && (com.tencent.soter.core.a.fb(ai.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean evY()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public static boolean evm()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.evm();
    ac.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean evn()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.evn();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void evp()
  {
    AppMethodBeat.i(129930);
    d.evp();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.evp();
    AppMethodBeat.o(129930);
  }
  
  public static boolean evy()
  {
    AppMethodBeat.i(129921);
    boolean bool = b.evy();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static void tW(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    b.tW(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void tX(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    ac.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    tY(paramBoolean);
    b.tW(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.tU(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.evl();
    }
    AppMethodBeat.o(129927);
  }
  
  public static void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.tT(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.evl();
    }
    AppMethodBeat.o(129928);
  }
  
  public final void TZ(int paramInt)
  {
    AppMethodBeat.i(129919);
    ac.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOI, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.agR().agA().faa();
    AppMethodBeat.o(129919);
  }
  
  public final int evU()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOI, Integer.valueOf(0))).intValue();
    }
    int i = this.mType;
    AppMethodBeat.o(129920);
    return i;
  }
  
  public final boolean evj()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.evz();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      ac.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.evo()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.evo();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.g
 * JD-Core Version:    0.7.0.1
 */