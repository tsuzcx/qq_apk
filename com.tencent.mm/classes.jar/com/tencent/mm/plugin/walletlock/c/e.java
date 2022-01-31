package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class e
  extends a
{
  private static com.tencent.mm.plugin.walletlock.a.b uGb;
  
  private static void aCM()
  {
    AppMethodBeat.i(51693);
    ab.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(g.uGh.cYg()) });
    AppMethodBeat.o(51693);
  }
  
  public final void IL(int paramInt)
  {
    AppMethodBeat.i(51705);
    Object localObject;
    if (paramInt == 1)
    {
      ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new c();
      uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.uGh;
      g.oc(true);
      AppMethodBeat.o(51705);
      return;
    }
    if (paramInt == 2)
    {
      ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.uGh;
      g.oa(false);
      AppMethodBeat.o(51705);
      return;
    }
    if (paramInt == 3)
    {
      ab.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      AppMethodBeat.o(51705);
      return;
    }
    if (paramInt == 0)
    {
      ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.uGh;
      g.ob(true);
      AppMethodBeat.o(51705);
      return;
    }
    ab.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
    AppMethodBeat.o(51705);
  }
  
  public final void a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(51694);
    if (uGb != null) {
      uGb.a(paramActivity, paramb);
    }
    AppMethodBeat.o(51694);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(51695);
    if (uGb != null) {
      uGb.a(paramActivity, paramb, parama);
    }
    AppMethodBeat.o(51695);
  }
  
  public final void ak(Activity paramActivity)
  {
    AppMethodBeat.i(51698);
    if (uGb != null) {
      uGb.ak(paramActivity);
    }
    AppMethodBeat.o(51698);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(51697);
    super.b(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(51697);
  }
  
  public final void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(51703);
    if (uGb != null)
    {
      uGb.b(paramActivity, paramIntent);
      AppMethodBeat.o(51703);
      return;
    }
    super.b(paramActivity, paramIntent);
    AppMethodBeat.o(51703);
  }
  
  public final void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(51704);
    if (uGb != null)
    {
      uGb.b(paramActivity, paramIntent, paramInt);
      AppMethodBeat.o(51704);
      return;
    }
    super.b(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(51704);
  }
  
  public final b.b cXt()
  {
    AppMethodBeat.i(51700);
    if (uGb != null)
    {
      b.b localb = uGb.cXt();
      AppMethodBeat.o(51700);
      return localb;
    }
    AppMethodBeat.o(51700);
    return null;
  }
  
  public final boolean cXu()
  {
    AppMethodBeat.i(51701);
    g localg = g.uGh;
    if (!g.cXK())
    {
      localg = g.uGh;
      if (!g.cXy()) {}
    }
    else
    {
      AppMethodBeat.o(51701);
      return true;
    }
    AppMethodBeat.o(51701);
    return false;
  }
  
  public final boolean cXv()
  {
    AppMethodBeat.i(51702);
    if (uGb != null)
    {
      boolean bool = uGb.cXv();
      AppMethodBeat.o(51702);
      return bool;
    }
    AppMethodBeat.o(51702);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51692);
    ab.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[] { bo.l(new Throwable()) });
    int i = bo.f(com.tencent.mm.kernel.g.RL().Ru().get(40, null), 0);
    ab.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      ab.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.uGh;
      boolean bool = g.cYj();
      ab.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(m.cyg()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.b.cXK()) && (!bool))
      {
        bool = com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yIc, false);
        ab.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new c();
          uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          aCM();
          AppMethodBeat.o(51692);
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.b.cXK()) {
        break label262;
      }
      ab.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new c();
      uGb = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.uGh;
      g.oc(false);
    }
    for (;;)
    {
      aCM();
      AppMethodBeat.o(51692);
      return;
      label262:
      ab.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      uGb = new a();
      localObject = g.uGh;
      g.ob(false);
      uGb.init();
    }
  }
  
  public final void j(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(51696);
    super.j(paramActivity, paramInt);
    AppMethodBeat.o(51696);
  }
  
  public final void k(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(51699);
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.close_wallet_lock");
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
    AppMethodBeat.o(51699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.e
 * JD-Core Version:    0.7.0.1
 */