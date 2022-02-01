package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.soter.core.c.j;

public enum g
{
  public String Pra;
  public j Prb;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    PqZ = new g("instance");
    Prc = new g[] { PqZ };
    AppMethodBeat.o(129933);
  }
  
  private g() {}
  
  public static void CA(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Cv(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNo();
    }
    AppMethodBeat.o(129928);
  }
  
  public static void Cy(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    b.Cy(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void Cz(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    Log.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    CA(paramBoolean);
    b.Cy(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Cw(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNo();
    }
    AppMethodBeat.o(129927);
  }
  
  public static boolean gNB()
  {
    AppMethodBeat.i(129921);
    boolean bool = b.gNB();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static void gNY()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Cv(true);
    AppMethodBeat.o(129924);
  }
  
  public static void gNZ()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Cw(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean gNp()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNp();
    Log.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean gNq()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNq();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void gNs()
  {
    AppMethodBeat.i(129930);
    d.gNs();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNs();
    AppMethodBeat.o(129930);
  }
  
  public static boolean gOa()
  {
    AppMethodBeat.i(129931);
    if ((gOb()) && (m.gao()) && (com.tencent.soter.core.a.gh(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean gOb()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public final void amS(int paramInt)
  {
    AppMethodBeat.i(129919);
    Log.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    h.aHG().aHp().set(ar.a.Vsf, Integer.valueOf(paramInt));
    h.aHG().aHp().hxT();
    AppMethodBeat.o(129919);
  }
  
  public final int gNX()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)h.aHG().aHp().get(ar.a.Vsf, Integer.valueOf(0))).intValue();
    }
    int i = this.mType;
    AppMethodBeat.o(129920);
    return i;
  }
  
  public final boolean gNm()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.gNC();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      Log.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNr()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.gNr();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.g
 * JD-Core Version:    0.7.0.1
 */