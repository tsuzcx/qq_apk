package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class e
  extends a
{
  private static com.tencent.mm.plugin.walletlock.a.b DvU;
  
  private static void bjS()
  {
    AppMethodBeat.i(129898);
    ad.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(g.Dwa.eKa()) });
    AppMethodBeat.o(129898);
  }
  
  public final void VM(int paramInt)
  {
    AppMethodBeat.i(129910);
    Object localObject;
    if (paramInt == 1)
    {
      ad.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new c();
      DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.Dwa;
      g.uI(true);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 2)
    {
      ad.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.Dwa;
      g.uG(false);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 3)
    {
      ad.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.Dwa;
      g.uH(true);
      AppMethodBeat.o(129910);
      return;
    }
    ad.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
    AppMethodBeat.o(129910);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129900);
    if (DvU != null) {
      DvU.a(paramActivity, paramb, parama);
    }
    AppMethodBeat.o(129900);
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129899);
    if (DvU != null)
    {
      boolean bool = DvU.a(paramActivity, paramb);
      AppMethodBeat.o(129899);
      return bool;
    }
    AppMethodBeat.o(129899);
    return false;
  }
  
  public final void aJ(Activity paramActivity)
  {
    AppMethodBeat.i(129903);
    if (DvU != null) {
      DvU.aJ(paramActivity);
    }
    AppMethodBeat.o(129903);
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
    if (DvU != null)
    {
      DvU.c(paramActivity, paramIntent, paramInt);
      AppMethodBeat.o(129909);
      return;
    }
    super.c(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(129909);
  }
  
  public final void e(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129908);
    if (DvU != null)
    {
      DvU.e(paramActivity, paramIntent);
      AppMethodBeat.o(129908);
      return;
    }
    super.e(paramActivity, paramIntent);
    AppMethodBeat.o(129908);
  }
  
  public final b.b eJn()
  {
    AppMethodBeat.i(129905);
    if (DvU != null)
    {
      b.b localb = DvU.eJn();
      AppMethodBeat.o(129905);
      return localb;
    }
    AppMethodBeat.o(129905);
    return null;
  }
  
  public final boolean eJo()
  {
    AppMethodBeat.i(129906);
    g localg = g.Dwa;
    if (!g.eJE())
    {
      localg = g.Dwa;
      if (!g.eJs()) {}
    }
    else
    {
      AppMethodBeat.o(129906);
      return true;
    }
    AppMethodBeat.o(129906);
    return false;
  }
  
  public final boolean eJp()
  {
    AppMethodBeat.i(129907);
    if (DvU != null)
    {
      boolean bool = DvU.eJp();
      AppMethodBeat.o(129907);
      return bool;
    }
    AppMethodBeat.o(129907);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129897);
    ad.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[] { bt.n(new Throwable()) });
    int i = bt.m(com.tencent.mm.kernel.g.ajC().ajl().get(40, null), 0);
    ad.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      ad.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.Dwa;
      boolean bool = g.eKd();
      ad.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(m.efK()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.b.eJE()) && (!bool))
      {
        bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IBj, false);
        ad.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new c();
          DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          bjS();
          AppMethodBeat.o(129897);
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.b.eJE()) {
        break label262;
      }
      ad.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new c();
      DvU = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.Dwa;
      g.uI(false);
    }
    for (;;)
    {
      bjS();
      AppMethodBeat.o(129897);
      return;
      label262:
      ad.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      DvU = new a();
      localObject = g.Dwa;
      g.uH(false);
      DvU.init();
    }
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
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
    AppMethodBeat.o(129904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.e
 * JD-Core Version:    0.7.0.1
 */