package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class e
  extends a
{
  private static com.tencent.mm.plugin.walletlock.a.b PqT;
  
  private static void bRG()
  {
    AppMethodBeat.i(129898);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(g.PqZ.gNX()) });
    AppMethodBeat.o(129898);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129900);
    if (PqT != null) {
      PqT.a(paramActivity, paramb, parama);
    }
    AppMethodBeat.o(129900);
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129899);
    if (PqT != null)
    {
      boolean bool = PqT.a(paramActivity, paramb);
      AppMethodBeat.o(129899);
      return bool;
    }
    AppMethodBeat.o(129899);
    return false;
  }
  
  public final void aV(Activity paramActivity)
  {
    AppMethodBeat.i(129903);
    if (PqT != null) {
      PqT.aV(paramActivity);
    }
    AppMethodBeat.o(129903);
  }
  
  public final void amN(int paramInt)
  {
    AppMethodBeat.i(129910);
    Object localObject;
    if (paramInt == 1)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.c();
      PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.PqZ;
      g.CA(true);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.PqZ;
      g.Cy(false);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.PqZ;
      g.Cz(true);
      AppMethodBeat.o(129910);
      return;
    }
    Log.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
    AppMethodBeat.o(129910);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129902);
    super.b(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(129902);
  }
  
  public final void e(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129909);
    if (PqT != null)
    {
      PqT.e(paramActivity, paramIntent, paramInt);
      AppMethodBeat.o(129909);
      return;
    }
    super.e(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(129909);
  }
  
  public final b.b gNk()
  {
    AppMethodBeat.i(129905);
    if (PqT != null)
    {
      b.b localb = PqT.gNk();
      AppMethodBeat.o(129905);
      return localb;
    }
    AppMethodBeat.o(129905);
    return null;
  }
  
  public final boolean gNl()
  {
    AppMethodBeat.i(129906);
    g localg = g.PqZ;
    if (!g.gNB())
    {
      localg = g.PqZ;
      if (!g.gNp()) {}
    }
    else
    {
      AppMethodBeat.o(129906);
      return true;
    }
    AppMethodBeat.o(129906);
    return false;
  }
  
  public final boolean gNm()
  {
    AppMethodBeat.i(129907);
    if (PqT != null)
    {
      boolean bool = PqT.gNm();
      AppMethodBeat.o(129907);
      return bool;
    }
    AppMethodBeat.o(129907);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129897);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[] { Util.stackTraceToString(new Throwable()) });
    int i = Util.nullAsInt(h.aHG().aHp().b(40, null), 0);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.PqZ;
      boolean bool = g.gOa();
      Log.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(m.gao()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.b.gNB()) && (!bool))
      {
        bool = h.aHG().aHp().getBoolean(ar.a.Vsl, false);
        Log.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.c();
          PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          bRG();
          AppMethodBeat.o(129897);
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.b.gNB()) {
        break label262;
      }
      Log.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.c();
      PqT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.PqZ;
      g.CA(false);
    }
    for (;;)
    {
      bRG();
      AppMethodBeat.o(129897);
      return;
      label262:
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      PqT = new a();
      localObject = g.PqZ;
      g.Cz(false);
      PqT.init();
    }
  }
  
  public final void m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129901);
    super.m(paramActivity, paramInt);
    AppMethodBeat.o(129901);
  }
  
  public final void n(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129904);
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.close_wallet_lock");
    com.tencent.mm.by.c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
    AppMethodBeat.o(129904);
  }
  
  public final void n(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129908);
    if (PqT != null)
    {
      PqT.n(paramActivity, paramIntent);
      AppMethodBeat.o(129908);
      return;
    }
    super.n(paramActivity, paramIntent);
    AppMethodBeat.o(129908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.e
 * JD-Core Version:    0.7.0.1
 */