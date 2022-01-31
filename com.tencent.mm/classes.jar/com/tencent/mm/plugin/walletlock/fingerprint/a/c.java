package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.a.a;

public final class c
  implements com.tencent.mm.ai.f, d
{
  private String gJv = null;
  boolean isCancelled = false;
  d.a uEl = null;
  private d.a uEm = null;
  private boolean uEn = false;
  
  static void he(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51474);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
    AppMethodBeat.o(51474);
  }
  
  private void nZ(boolean paramBoolean)
  {
    AppMethodBeat.i(51473);
    ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.uEn) {}
    for (Object localObject = null;; localObject = new g(this.gJv))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(51473);
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(51472);
    this.gJv = paramBundle.getString("key_pay_passwd");
    this.uEn = paramBundle.getBoolean("key_fp_lock_offline_mode");
    ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.gJv, Boolean.valueOf(this.uEn) });
    this.uEl = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.uGh.uGi = null;
    com.tencent.mm.plugin.walletlock.c.g.uGh.uGj = null;
    com.tencent.mm.kernel.g.Rc().a(1967, this);
    com.tencent.mm.kernel.g.Rc().a(1548, this);
    if (this.uEn)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.uGh.uGi = String.valueOf(l);
      nZ(false);
      AppMethodBeat.o(51472);
      return;
    }
    if (ah.dsQ() == null)
    {
      if (this.uEl != null) {
        this.uEl.aC(2, "system error");
      }
      AppMethodBeat.o(51472);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.cyc();
    parama = paramBundle.son;
    paramBundle = paramBundle.kbP;
    ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((bo.isNullOrNil(parama)) || (bo.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, true, new c.2(this));
      AppMethodBeat.o(51472);
      return;
    }
    he(parama, paramBundle);
    AppMethodBeat.o(51472);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(51475);
    ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.uEm = parama;
    com.tencent.mm.kernel.g.Rc().a(new f(paramString2, paramString3, paramString1), 0);
    AppMethodBeat.o(51475);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(51477);
    ab.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(51477);
      return;
    }
    if ((paramm instanceof e))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (e)paramm;
        paramm = paramString.mGC;
        com.tencent.mm.plugin.walletlock.c.g.uGh.uGi = paramm;
        nZ(paramString.uEq);
        AppMethodBeat.o(51477);
        return;
      }
      if (this.uEl != null)
      {
        this.uEl.aC(7, "get challenge failed");
        AppMethodBeat.o(51477);
      }
    }
    else if ((paramm instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.od(true);
        if (this.uEm != null)
        {
          this.uEm.aC(0, "open touch lock ok");
          AppMethodBeat.o(51477);
        }
      }
      else
      {
        h.od(false);
        if (this.uEm != null) {
          this.uEm.aC(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(51477);
  }
  
  public final void release()
  {
    AppMethodBeat.i(51476);
    ab.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.uEl = null;
    this.uEm = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.g.Rc().b(1967, this);
    com.tencent.mm.kernel.g.Rc().b(1548, this);
    AppMethodBeat.o(51476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */