package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.soter.a.a;

public final class c
  implements com.tencent.mm.ak.g, d
{
  d.a BTN = null;
  private d.a BTO = null;
  private boolean BTP = false;
  private String iXf = null;
  boolean isCancelled = false;
  
  static void kd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  private void tV(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    ac.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.BTP) {}
    for (Object localObject = null;; localObject = new g(this.iXf))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.iXf = paramBundle.getString("key_pay_passwd");
    this.BTP = paramBundle.getBoolean("key_fp_lock_offline_mode");
    ac.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.iXf, Boolean.valueOf(this.BTP) });
    this.BTN = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.BVG.BVH = null;
    com.tencent.mm.plugin.walletlock.c.g.BVG.BVI = null;
    com.tencent.mm.kernel.g.agi().a(1967, this);
    com.tencent.mm.kernel.g.agi().a(1548, this);
    if (this.BTP)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.BVG.BVH = String.valueOf(l);
      tV(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (ai.eUY() == null)
    {
      if (this.BTN != null) {
        this.BTN.aZ(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.dTq();
    parama = paramBundle.znE;
    paramBundle = paramBundle.znF;
    ac.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((bs.isNullOrNil(parama)) || (bs.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void aZ(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.this.isCancelled)
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.d.d.dTq();
            c.kd(paramAnonymousString.znE, paramAnonymousString.znF);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.this.BTN != null) {
            c.this.BTN.aZ(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    kd(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    ac.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.BTO = parama;
    com.tencent.mm.kernel.g.agi().a(new f(paramString2, paramString3, paramString1), 0);
    AppMethodBeat.o(129680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(129682);
    ac.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
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
        paramn = paramString.skD;
        com.tencent.mm.plugin.walletlock.c.g.BVG.BVH = paramn;
        tV(paramString.BTR);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.BTN != null)
      {
        this.BTN.aZ(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.tZ(true);
        if (this.BTO != null)
        {
          this.BTO.aZ(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.aeo(3);
        h.tZ(false);
        if (this.BTO != null) {
          this.BTO.aZ(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    ac.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.BTN = null;
    this.BTO = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.g.agi().b(1967, this);
    com.tencent.mm.kernel.g.agi().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */