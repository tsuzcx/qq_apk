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
  implements com.tencent.mm.al.g, d
{
  d.a ABs = null;
  private d.a ABt = null;
  private boolean ABu = false;
  boolean isCancelled = false;
  private String ixc = null;
  
  static void jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  private void sU(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.ABu) {}
    for (Object localObject = null;; localObject = new g(this.ixc))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.ixc = paramBundle.getString("key_pay_passwd");
    this.ABu = paramBundle.getBoolean("key_fp_lock_offline_mode");
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.ixc, Boolean.valueOf(this.ABu) });
    this.ABs = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.ADl.ADm = null;
    com.tencent.mm.plugin.walletlock.c.g.ADl.ADn = null;
    com.tencent.mm.kernel.g.aeS().a(1967, this);
    com.tencent.mm.kernel.g.aeS().a(1548, this);
    if (this.ABu)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.ADl.ADm = String.valueOf(l);
      sU(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (aj.eFE() == null)
    {
      if (this.ABs != null) {
        this.ABs.aU(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.dEQ();
    parama = paramBundle.yaF;
    paramBundle = paramBundle.yaG;
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((bt.isNullOrNil(parama)) || (bt.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void aU(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.this.isCancelled)
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.d.d.dEQ();
            c.jH(paramAnonymousString.yaF, paramAnonymousString.yaG);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.this.ABs != null) {
            c.this.ABs.aU(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    jH(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    ad.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.ABt = parama;
    com.tencent.mm.kernel.g.aeS().a(new f(paramString2, paramString3, paramString1), 0);
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
        paramn = paramString.rcj;
        com.tencent.mm.plugin.walletlock.c.g.ADl.ADm = paramn;
        sU(paramString.ABw);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.ABs != null)
      {
        this.ABs.aU(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.sY(true);
        if (this.ABt != null)
        {
          this.ABt.aU(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.abV(3);
        h.sY(false);
        if (this.ABt != null) {
          this.ABt.aU(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    ad.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.ABs = null;
    this.ABt = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.g.aeS().b(1967, this);
    com.tencent.mm.kernel.g.aeS().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */