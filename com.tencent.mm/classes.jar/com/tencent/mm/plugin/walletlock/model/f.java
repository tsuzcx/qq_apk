package com.tencent.mm.plugin.walletlock.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public enum f
{
  public String WhN;
  public com.tencent.soter.core.c.j WhO;
  int mType = -1;
  
  static
  {
    AppMethodBeat.i(129933);
    WhM = new f("instance");
    WhP = new f[] { WhM };
    AppMethodBeat.o(129933);
  }
  
  private f() {}
  
  public static void Id(boolean paramBoolean)
  {
    AppMethodBeat.i(129922);
    d.Id(paramBoolean);
    AppMethodBeat.o(129922);
  }
  
  public static void Ie(boolean paramBoolean)
  {
    AppMethodBeat.i(129927);
    Log.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
    If(paramBoolean);
    d.Id(false);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ib(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.imD();
    }
    AppMethodBeat.o(129927);
  }
  
  public static void If(boolean paramBoolean)
  {
    AppMethodBeat.i(129928);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ia(false);
    if (paramBoolean) {
      com.tencent.mm.plugin.walletlock.fingerprint.a.a.imD();
    }
    AppMethodBeat.o(129928);
  }
  
  public static boolean imE()
  {
    AppMethodBeat.i(129923);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.imE();
    Log.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(129923);
    return bool;
  }
  
  public static boolean imF()
  {
    AppMethodBeat.i(129925);
    boolean bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.imF();
    AppMethodBeat.o(129925);
    return bool;
  }
  
  public static void imH()
  {
    AppMethodBeat.i(129930);
    com.tencent.mm.plugin.walletlock.gesture.a.f.imH();
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.imH();
    AppMethodBeat.o(129930);
  }
  
  public static boolean imQ()
  {
    AppMethodBeat.i(129921);
    boolean bool = d.imQ();
    AppMethodBeat.o(129921);
    return bool;
  }
  
  public static void inn()
  {
    AppMethodBeat.i(129924);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ia(true);
    AppMethodBeat.o(129924);
  }
  
  public static void ino()
  {
    AppMethodBeat.i(129926);
    com.tencent.mm.plugin.walletlock.fingerprint.a.a.Ib(true);
    AppMethodBeat.o(129926);
  }
  
  public static boolean inp()
  {
    AppMethodBeat.i(129931);
    if ((inq()) && (com.tencent.mm.plugin.soter.model.j.htF()) && (com.tencent.soter.core.a.hC(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(129931);
      return true;
    }
    AppMethodBeat.o(129931);
    return false;
  }
  
  public static boolean inq()
  {
    AppMethodBeat.i(129932);
    if (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("TouchLockFunction", 0) != 1)
    {
      AppMethodBeat.o(129932);
      return true;
    }
    AppMethodBeat.o(129932);
    return false;
  }
  
  public final void asJ(int paramInt)
  {
    AppMethodBeat.i(129919);
    Log.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(paramInt) });
    this.mType = paramInt;
    h.baE().ban().set(at.a.acTK, Integer.valueOf(paramInt));
    h.baE().ban().iZy();
    AppMethodBeat.o(129919);
  }
  
  public final boolean imB()
  {
    AppMethodBeat.i(129929);
    boolean bool;
    if (this.mType == 1)
    {
      bool = d.imR();
      AppMethodBeat.o(129929);
      return bool;
    }
    if (this.mType == 2)
    {
      Log.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.imG()) });
      bool = com.tencent.mm.plugin.walletlock.fingerprint.a.a.imG();
      AppMethodBeat.o(129929);
      return bool;
    }
    AppMethodBeat.o(129929);
    return false;
  }
  
  public final int inm()
  {
    AppMethodBeat.i(129920);
    if (this.mType == -1) {
      this.mType = ((Integer)h.baE().ban().get(at.a.acTK, Integer.valueOf(0))).intValue();
    }
    int i = this.mType;
    AppMethodBeat.o(129920);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.f
 * JD-Core Version:    0.7.0.1
 */