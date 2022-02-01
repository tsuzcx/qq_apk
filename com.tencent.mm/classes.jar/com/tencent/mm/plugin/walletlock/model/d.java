package com.tencent.mm.plugin.walletlock.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.soter.model.j;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class d
  extends a
{
  private static com.tencent.mm.plugin.walletlock.a.b WhG;
  
  private static void crL()
  {
    AppMethodBeat.i(129898);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(f.WhM.inm()) });
    AppMethodBeat.o(129898);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129900);
    if (WhG != null) {
      WhG.a(paramActivity, paramb, parama);
    }
    AppMethodBeat.o(129900);
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129899);
    if (WhG != null)
    {
      boolean bool = WhG.a(paramActivity, paramb);
      AppMethodBeat.o(129899);
      return bool;
    }
    AppMethodBeat.o(129899);
    return false;
  }
  
  public final void asE(int paramInt)
  {
    AppMethodBeat.i(129910);
    Object localObject;
    if (paramInt == 1)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new e();
      WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = f.WhM;
      f.If(true);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = f.WhM;
      f.Id(false);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = f.WhM;
      f.Ie(true);
      AppMethodBeat.o(129910);
      return;
    }
    Log.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
    AppMethodBeat.o(129910);
  }
  
  public final void bA(Activity paramActivity)
  {
    AppMethodBeat.i(129903);
    if (WhG != null) {
      WhG.bA(paramActivity);
    }
    AppMethodBeat.o(129903);
  }
  
  public final void c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129902);
    super.c(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(129902);
  }
  
  public final void h(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129909);
    if (WhG != null)
    {
      WhG.h(paramActivity, paramIntent, paramInt);
      AppMethodBeat.o(129909);
      return;
    }
    super.h(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(129909);
  }
  
  public final boolean imA()
  {
    AppMethodBeat.i(129906);
    f localf = f.WhM;
    if (!f.imQ())
    {
      localf = f.WhM;
      if (!f.imE()) {}
    }
    else
    {
      AppMethodBeat.o(129906);
      return true;
    }
    AppMethodBeat.o(129906);
    return false;
  }
  
  public final boolean imB()
  {
    AppMethodBeat.i(129907);
    if (WhG != null)
    {
      boolean bool = WhG.imB();
      AppMethodBeat.o(129907);
      return bool;
    }
    AppMethodBeat.o(129907);
    return false;
  }
  
  public final b.b imz()
  {
    AppMethodBeat.i(129905);
    if (WhG != null)
    {
      b.b localb = WhG.imz();
      AppMethodBeat.o(129905);
      return localb;
    }
    AppMethodBeat.o(129905);
    return null;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129897);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[] { Util.stackTraceToString(new Throwable()) });
    int i = Util.nullAsInt(h.baE().ban().d(40, null), 0);
    Log.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      Log.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = f.WhM;
      boolean bool = f.inp();
      Log.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(j.htF()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.d.imQ()) && (!bool))
      {
        bool = h.baE().ban().getBoolean(at.a.acTQ, false);
        Log.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new e();
          WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          crL();
          AppMethodBeat.o(129897);
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.d.imQ()) {
        break label262;
      }
      Log.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new e();
      WhG = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = f.WhM;
      f.If(false);
    }
    for (;;)
    {
      crL();
      AppMethodBeat.o(129897);
      return;
      label262:
      Log.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      WhG = new a();
      localObject = f.WhM;
      f.Ie(false);
      WhG.init();
    }
  }
  
  public final void o(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129901);
    super.o(paramActivity, paramInt);
    AppMethodBeat.o(129901);
  }
  
  public final void p(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(129904);
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.close_wallet_lock");
    c.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
    AppMethodBeat.o(129904);
  }
  
  public final void t(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129908);
    if (WhG != null)
    {
      WhG.t(paramActivity, paramIntent);
      AppMethodBeat.o(129908);
      return;
    }
    super.t(paramActivity, paramIntent);
    AppMethodBeat.o(129908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.d
 * JD-Core Version:    0.7.0.1
 */