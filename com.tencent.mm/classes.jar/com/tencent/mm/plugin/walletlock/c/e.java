package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static com.tencent.mm.plugin.walletlock.a.b IwO;
  
  private static void bFX()
  {
    AppMethodBeat.i(129898);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(g.IwU.fVr()) });
    AppMethodBeat.o(129898);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129900);
    if (IwO != null) {
      IwO.a(paramActivity, paramb, parama);
    }
    AppMethodBeat.o(129900);
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129899);
    if (IwO != null)
    {
      boolean bool = IwO.a(paramActivity, paramb);
      AppMethodBeat.o(129899);
      return bool;
    }
    AppMethodBeat.o(129899);
    return false;
  }
  
  public final void aQ(Activity paramActivity)
  {
    AppMethodBeat.i(129903);
    if (IwO != null) {
      IwO.aQ(paramActivity);
    }
    AppMethodBeat.o(129903);
  }
  
  public final void aeZ(int paramInt)
  {
    AppMethodBeat.i(129910);
    Object localObject;
    if (paramInt == 1)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.c();
      IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.IwU;
      g.yF(true);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.IwU;
      g.yD(false);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.IwU;
      g.yE(true);
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
  
  public final void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129909);
    if (IwO != null)
    {
      IwO.c(paramActivity, paramIntent, paramInt);
      AppMethodBeat.o(129909);
      return;
    }
    super.c(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(129909);
  }
  
  public final b.b fUE()
  {
    AppMethodBeat.i(129905);
    if (IwO != null)
    {
      b.b localb = IwO.fUE();
      AppMethodBeat.o(129905);
      return localb;
    }
    AppMethodBeat.o(129905);
    return null;
  }
  
  public final boolean fUF()
  {
    AppMethodBeat.i(129906);
    g localg = g.IwU;
    if (!g.fUV())
    {
      localg = g.IwU;
      if (!g.fUJ()) {}
    }
    else
    {
      AppMethodBeat.o(129906);
      return true;
    }
    AppMethodBeat.o(129906);
    return false;
  }
  
  public final boolean fUG()
  {
    AppMethodBeat.i(129907);
    if (IwO != null)
    {
      boolean bool = IwO.fUG();
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
    int i = Util.nullAsInt(com.tencent.mm.kernel.g.aAh().azQ().get(40, null), 0);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.IwU;
      boolean bool = g.fVu();
      Log.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(m.flS()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.b.fUV()) && (!bool))
      {
        bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Oea, false);
        Log.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new com.tencent.mm.plugin.walletlock.gesture.a.c();
          IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          bFX();
          AppMethodBeat.o(129897);
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.b.fUV()) {
        break label262;
      }
      Log.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.gesture.a.c();
      IwO = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.IwU;
      g.yF(false);
    }
    for (;;)
    {
      bFX();
      AppMethodBeat.o(129897);
      return;
      label262:
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      IwO = new a();
      localObject = g.IwU;
      g.yE(false);
      IwO.init();
    }
  }
  
  public final void j(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129908);
    if (IwO != null)
    {
      IwO.j(paramActivity, paramIntent);
      AppMethodBeat.o(129908);
      return;
    }
    super.j(paramActivity, paramIntent);
    AppMethodBeat.o(129908);
  }
  
  public final void l(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129901);
    super.l(paramActivity, paramInt);
    AppMethodBeat.o(129901);
  }
  
  public final void m(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129904);
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.close_wallet_lock");
    com.tencent.mm.br.c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
    AppMethodBeat.o(129904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.e
 * JD-Core Version:    0.7.0.1
 */