package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class e
  extends a
{
  private static com.tencent.mm.plugin.walletlock.a.b qQT;
  
  private static void bYv()
  {
    y.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(g.qQZ.bYw()) });
  }
  
  public final void AZ(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      y.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new c();
      qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.qQZ;
      g.kT(true);
      return;
    }
    if (paramInt == 2)
    {
      y.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.qQZ;
      g.kR(false);
      return;
    }
    if (paramInt == 3)
    {
      y.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      return;
    }
    if (paramInt == 0)
    {
      y.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.qQZ;
      g.kS(true);
      return;
    }
    y.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
  }
  
  public final void P(Activity paramActivity)
  {
    if (qQT != null) {
      qQT.P(paramActivity);
    }
  }
  
  public final void a(Activity paramActivity, Intent paramIntent)
  {
    if (qQT != null)
    {
      qQT.a(paramActivity, paramIntent);
      return;
    }
    super.a(paramActivity, paramIntent);
  }
  
  public final void a(Activity paramActivity, b.b paramb)
  {
    if (qQT != null) {
      qQT.a(paramActivity, paramb);
    }
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    if (qQT != null) {
      qQT.a(paramActivity, paramb, parama);
    }
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super.b(paramActivity, paramInt1, paramInt2);
  }
  
  public final void b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (qQT != null)
    {
      qQT.b(paramActivity, paramIntent, paramInt);
      return;
    }
    super.b(paramActivity, paramIntent, paramInt);
  }
  
  public final b.b bXL()
  {
    if (qQT != null) {
      return qQT.bXL();
    }
    return null;
  }
  
  public final boolean bXM()
  {
    g localg = g.qQZ;
    if (!g.bYc()) {
      localg = g.qQZ;
    }
    return g.bXQ();
  }
  
  public final boolean bXN()
  {
    if (qQT != null) {
      return qQT.bXN();
    }
    return false;
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    super.g(paramActivity, paramInt);
  }
  
  public final void h(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("action", "action.close_wallet_lock");
    d.b(paramActivity, "wallet", ".pwd.ui.WalletLockCheckPwdUI", localIntent, paramInt);
  }
  
  public final void init()
  {
    y.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[] { bk.j(new Throwable()) });
    int i = bk.e(com.tencent.mm.kernel.g.DP().Dz().get(40, null), 0);
    y.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      y.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.qQZ;
      boolean bool = g.bYz();
      y.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(m.bKV()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.b.bYc()) && (!bool))
      {
        bool = com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uxS, false);
        y.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new c();
          qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          bYv();
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.b.bYc()) {
        break label247;
      }
      y.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new c();
      qQT = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.qQZ;
      g.kT(false);
    }
    for (;;)
    {
      bYv();
      return;
      label247:
      y.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      qQT = new a();
      localObject = g.qQZ;
      g.kS(false);
      qQT.init();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.e
 * JD-Core Version:    0.7.0.1
 */