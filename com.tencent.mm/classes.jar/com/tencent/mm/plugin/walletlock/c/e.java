package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.plugin.walletlock.a.b.a;
import com.tencent.mm.plugin.walletlock.a.b.b;
import com.tencent.mm.plugin.walletlock.gesture.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class e
  extends a
{
  private static com.tencent.mm.plugin.walletlock.a.b BVA;
  
  private static void bgo()
  {
    AppMethodBeat.i(129898);
    ac.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init end, wallet lock type: %d", new Object[] { Integer.valueOf(g.BVG.evU()) });
    AppMethodBeat.o(129898);
  }
  
  public final void TU(int paramInt)
  {
    AppMethodBeat.i(129910);
    Object localObject;
    if (paramInt == 1)
    {
      ac.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to gesture");
      localObject = new c();
      BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.BVG;
      g.tY(true);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 2)
    {
      ac.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to fingerprint lock");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.BVG;
      g.tW(false);
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 3)
    {
      ac.i("MicroMsg.WalletLockImpl", "wallet lock switch to faceid lock");
      localObject = new com.tencent.mm.plugin.walletlock.b.a();
      BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      AppMethodBeat.o(129910);
      return;
    }
    if (paramInt == 0)
    {
      ac.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock switch to none");
      localObject = new a();
      BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.BVG;
      g.tX(true);
      AppMethodBeat.o(129910);
      return;
    }
    ac.e("MicroMsg.WalletLockImpl", "alvinluo unknown wallet lock type, ignore switch");
    AppMethodBeat.o(129910);
  }
  
  public final void a(Activity paramActivity, b.b paramb, b.a parama)
  {
    AppMethodBeat.i(129900);
    if (BVA != null) {
      BVA.a(paramActivity, paramb, parama);
    }
    AppMethodBeat.o(129900);
  }
  
  public final boolean a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(129899);
    if (BVA != null)
    {
      boolean bool = BVA.a(paramActivity, paramb);
      AppMethodBeat.o(129899);
      return bool;
    }
    AppMethodBeat.o(129899);
    return false;
  }
  
  public final void aJ(Activity paramActivity)
  {
    AppMethodBeat.i(129903);
    if (BVA != null) {
      BVA.aJ(paramActivity);
    }
    AppMethodBeat.o(129903);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129902);
    super.b(paramActivity, paramInt1, paramInt2);
    AppMethodBeat.o(129902);
  }
  
  public final void c(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(129908);
    if (BVA != null)
    {
      BVA.c(paramActivity, paramIntent);
      AppMethodBeat.o(129908);
      return;
    }
    super.c(paramActivity, paramIntent);
    AppMethodBeat.o(129908);
  }
  
  public final void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(129909);
    if (BVA != null)
    {
      BVA.c(paramActivity, paramIntent, paramInt);
      AppMethodBeat.o(129909);
      return;
    }
    super.c(paramActivity, paramIntent, paramInt);
    AppMethodBeat.o(129909);
  }
  
  public final b.b evh()
  {
    AppMethodBeat.i(129905);
    if (BVA != null)
    {
      b.b localb = BVA.evh();
      AppMethodBeat.o(129905);
      return localb;
    }
    AppMethodBeat.o(129905);
    return null;
  }
  
  public final boolean evi()
  {
    AppMethodBeat.i(129906);
    g localg = g.BVG;
    if (!g.evy())
    {
      localg = g.BVG;
      if (!g.evm()) {}
    }
    else
    {
      AppMethodBeat.o(129906);
      return true;
    }
    AppMethodBeat.o(129906);
    return false;
  }
  
  public final boolean evj()
  {
    AppMethodBeat.i(129907);
    if (BVA != null)
    {
      boolean bool = BVA.evj();
      AppMethodBeat.o(129907);
      return bool;
    }
    AppMethodBeat.o(129907);
    return false;
  }
  
  public final void init()
  {
    AppMethodBeat.i(129897);
    ac.i("MicroMsg.WalletLockImpl", "alvinluo WalletLock init start, call stack: %s", new Object[] { bs.m(new Throwable()) });
    int i = bs.l(com.tencent.mm.kernel.g.agR().agA().get(40, null), 0);
    ac.i("MicroMsg.WalletLockImpl", "alvinluo pluginSwitch %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i & 0x800000) });
    Object localObject;
    if ((i & 0x800000) != 0)
    {
      ac.i("MicroMsg.WalletLockImpl", "alvinluo fingerprint wallet lock is opened");
      localObject = new com.tencent.mm.plugin.walletlock.fingerprint.a.b();
      BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.BVG;
      boolean bool = g.evX();
      ac.i("MicroMsg.WalletLockImpl", "alvinluo init isSupportSoter: %b, isSupportFingerprintLock: %b", new Object[] { Boolean.valueOf(m.dTw()), Boolean.valueOf(bool) });
      if ((com.tencent.mm.plugin.walletlock.gesture.a.b.evy()) && (!bool))
      {
        bool = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GOO, false);
        ac.i("MicroMsg.WalletLockImpl", "alvinluo has opened fingerprint lock, but device not support soter, and use gesture, isAutoJumpToGesture: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject = new c();
          BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
          ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
          bgo();
          AppMethodBeat.o(129897);
        }
      }
    }
    else
    {
      if (!com.tencent.mm.plugin.walletlock.gesture.a.b.evy()) {
        break label262;
      }
      ac.i("MicroMsg.WalletLockImpl", "alvinluo gesture wallet lock is opened");
      localObject = new c();
      BVA = (com.tencent.mm.plugin.walletlock.a.b)localObject;
      ((com.tencent.mm.plugin.walletlock.a.b)localObject).init();
      localObject = g.BVG;
      g.tY(false);
    }
    for (;;)
    {
      bgo();
      AppMethodBeat.o(129897);
      return;
      label262:
      ac.i("MicroMsg.WalletLockImpl", "alvinluo wallet lock is not open");
      BVA = new a();
      localObject = g.BVG;
      g.tX(false);
      BVA.init();
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