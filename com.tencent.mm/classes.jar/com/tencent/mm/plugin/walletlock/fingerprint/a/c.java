package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.a;

public final class c
  implements i, d
{
  private d.a Ppg = null;
  private d.a Pph = null;
  private boolean Ppi = false;
  private boolean isCancelled = false;
  private String njf = null;
  
  private void Cx(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.Ppi) {}
    for (Object localObject = null;; localObject = new g(this.njf))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  private static void lU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.njf = paramBundle.getString("key_pay_passwd");
    this.Ppi = paramBundle.getBoolean("key_fp_lock_offline_mode");
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.njf, Boolean.valueOf(this.Ppi) });
    this.Ppg = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.PqZ.Pra = null;
    com.tencent.mm.plugin.walletlock.c.g.PqZ.Prb = null;
    com.tencent.mm.kernel.h.aGY().a(1967, this);
    com.tencent.mm.kernel.h.aGY().a(1548, this);
    if (this.Ppi)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.PqZ.Pra = String.valueOf(l);
      Cx(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (MMApplicationContext.getDefaultPreference() == null)
    {
      if (this.Ppg != null) {
        this.Ppg.bh(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.gai();
    parama = paramBundle.Lwz;
    paramBundle = paramBundle.ktM;
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((Util.isNullOrNil(parama)) || (Util.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bh(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.a(c.this))
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.d.d.gai();
            c.lV(paramAnonymousString.Lwz, paramAnonymousString.ktM);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.b(c.this) != null) {
            c.b(c.this).bh(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    lU(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.Pph = parama;
    com.tencent.mm.kernel.h.aGY().a(new f(paramString2, paramString3, paramString1), 0);
    AppMethodBeat.o(129680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(129682);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129682);
      return;
    }
    if ((paramq instanceof e))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (e)paramq;
        paramq = paramString.ByB;
        com.tencent.mm.plugin.walletlock.c.g.PqZ.Pra = paramq;
        Cx(paramString.Ppk);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.Ppg != null)
      {
        this.Ppg.bh(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramq instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.walletlock.c.h.CB(true);
        if (this.Pph != null)
        {
          this.Pph.bh(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.aAx(3);
        com.tencent.mm.plugin.walletlock.c.h.CB(false);
        if (this.Pph != null) {
          this.Pph.bh(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    Log.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.Ppg = null;
    this.Pph = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.h.aGY().b(1967, this);
    com.tencent.mm.kernel.h.aGY().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */