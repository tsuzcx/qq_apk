package com.tencent.mm.plugin.walletlock.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.n.f;
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
  public String IwV;
  public j IwW;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    IwU = new g("instance");
    IwX = new g[] { IwU };
    AppMethodBeat.o(129933);
  }
  
  private g() {}
  
  public static boolean fUJ()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUJ();
    Log.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean fUK()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUK();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void fUM()
  {
    AppMethodBeat.i(129930);
    d.fUM();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUM();
    AppMethodBeat.o(129930);
  }
  
  public static boolean fUV()
  {
    AppMethodBeat.i(129921);
    boolean bool = b.fUV();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static void fVs()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.yA(true);
    AppMethodBeat.o(129924);
  }
  
  public static void fVt()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.yB(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean fVu()
  {
    AppMethodBeat.i(129931);
    if ((fVv()) && (m.flS()) && (com.tencent.soter.core.a.fN(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean fVv()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public static void yD(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    b.yD(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void yE(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    Log.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    yF(paramBoolean);
    b.yD(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.yB(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUI();
    }
    AppMethodBeat.o(129927);
  }
  
  public static void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.yA(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUI();
    }
    AppMethodBeat.o(129928);
  }
  
  public final void afe(int paramInt)
  {
    AppMethodBeat.i(129919);
    Log.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OdU, Integer.valueOf(paramInt));
    com.tencent.mm.kernel.g.aAh().azQ().gBI();
    AppMethodBeat.o(129919);
  }
  
  public final boolean fUG()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = b.fUW();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      Log.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUL()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.fUL();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
  
  public final int fVr()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OdU, Integer.valueOf(0))).intValue();
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