package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.soter.a.a;

public final class c
  implements com.tencent.mm.al.f, d
{
  d.a Duh = null;
  private d.a Dui = null;
  private boolean Duj = false;
  boolean isCancelled = false;
  private String jqo = null;
  
  static void kx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  private void uF(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.Duj) {}
    for (Object localObject = null;; localObject = new g(this.jqo))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.jqo = paramBundle.getString("key_pay_passwd");
    this.Duj = paramBundle.getBoolean("key_fp_lock_offline_mode");
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.jqo, Boolean.valueOf(this.Duj) });
    this.Duh = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwb = null;
    com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwc = null;
    com.tencent.mm.kernel.g.aiU().a(1967, this);
    com.tencent.mm.kernel.g.aiU().a(1548, this);
    if (this.Duj)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwb = String.valueOf(l);
      uF(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (aj.fkD() == null)
    {
      if (this.Duh != null) {
        this.Duh.bc(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.efE();
    parama = paramBundle.AFy;
    paramBundle = paramBundle.AFz;
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((bt.isNullOrNil(parama)) || (bt.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bc(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.this.isCancelled)
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.d.d.efE();
            c.kx(paramAnonymousString.AFy, paramAnonymousString.AFz);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.this.Duh != null) {
            c.this.Duh.bc(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    kx(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.Dui = parama;
    com.tencent.mm.kernel.g.aiU().a(new f(paramString2, paramString3, paramString1), 0);
    AppMethodBeat.o(129680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(129682);
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129682);
      return;
    }
    if ((paramn instanceof e))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (e)paramn;
        paramn = paramString.thf;
        com.tencent.mm.plugin.walletlock.c.g.Dwa.Dwb = paramn;
        uF(paramString.Dul);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.Duh != null)
      {
        this.Duh.bc(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.uJ(true);
        if (this.Dui != null)
        {
          this.Dui.bc(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.agO(3);
        h.uJ(false);
        if (this.Dui != null) {
          this.Dui.bc(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    ad.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.Duh = null;
    this.Dui = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.g.aiU().b(1967, this);
    com.tencent.mm.kernel.g.aiU().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */