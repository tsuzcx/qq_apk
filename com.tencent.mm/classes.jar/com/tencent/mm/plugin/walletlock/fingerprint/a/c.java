package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.soter.a.a;

public final class c
  implements com.tencent.mm.ak.f, d
{
  d.a DLM = null;
  private d.a DLN = null;
  private boolean DLO = false;
  boolean isCancelled = false;
  private String jth = null;
  
  static void kE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  private void uN(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    ae.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.DLO) {}
    for (Object localObject = null;; localObject = new g(this.jth))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.jth = paramBundle.getString("key_pay_passwd");
    this.DLO = paramBundle.getBoolean("key_fp_lock_offline_mode");
    ae.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.jth, Boolean.valueOf(this.DLO) });
    this.DLM = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.DNF.DNG = null;
    com.tencent.mm.plugin.walletlock.c.g.DNF.DNH = null;
    com.tencent.mm.kernel.g.ajj().a(1967, this);
    com.tencent.mm.kernel.g.ajj().a(1548, this);
    if (this.DLO)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.DNF.DNG = String.valueOf(l);
      uN(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (ak.fox() == null)
    {
      if (this.DLM != null) {
        this.DLM.bb(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.ejm();
    parama = paramBundle.AXb;
    paramBundle = paramBundle.AXc;
    ae.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((bu.isNullOrNil(parama)) || (bu.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.this.isCancelled)
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.d.d.ejm();
            c.kE(paramAnonymousString.AXb, paramAnonymousString.AXc);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.this.DLM != null) {
            c.this.DLM.bb(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    kE(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    ae.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.DLN = parama;
    com.tencent.mm.kernel.g.ajj().a(new f(paramString2, paramString3, paramString1), 0);
    AppMethodBeat.o(129680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(129682);
    ae.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
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
        paramn = paramString.trY;
        com.tencent.mm.plugin.walletlock.c.g.DNF.DNG = paramn;
        uN(paramString.DLQ);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.DLM != null)
      {
        this.DLM.bb(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramn instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.uR(true);
        if (this.DLN != null)
        {
          this.DLN.bb(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.ahx(3);
        h.uR(false);
        if (this.DLN != null) {
          this.DLN.bb(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    ae.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.DLM = null;
    this.DLN = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.g.ajj().b(1967, this);
    com.tencent.mm.kernel.g.ajj().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */