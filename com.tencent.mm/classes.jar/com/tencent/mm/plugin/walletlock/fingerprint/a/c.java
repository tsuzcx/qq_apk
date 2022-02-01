package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.walletlock.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.a;

public final class c
  implements i, d
{
  d.a Ivb = null;
  private d.a Ivc = null;
  private boolean Ivd = false;
  boolean isCancelled = false;
  private String krw = null;
  
  static void lx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  private void yC(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.Ivd) {}
    for (Object localObject = null;; localObject = new g(this.krw))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.krw = paramBundle.getString("key_pay_passwd");
    this.Ivd = paramBundle.getBoolean("key_fp_lock_offline_mode");
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.krw, Boolean.valueOf(this.Ivd) });
    this.Ivb = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.c.g.IwU.IwV = null;
    com.tencent.mm.plugin.walletlock.c.g.IwU.IwW = null;
    com.tencent.mm.kernel.g.azz().a(1967, this);
    com.tencent.mm.kernel.g.azz().a(1548, this);
    if (this.Ivd)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.c.g.IwU.IwV = String.valueOf(l);
      yC(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (MMApplicationContext.getDefaultPreference() == null)
    {
      if (this.Ivb != null) {
        this.Ivb.bg(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.d.d.flM();
    parama = paramBundle.FhU;
    paramBundle = paramBundle.hFF;
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((Util.isNullOrNil(parama)) || (Util.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bg(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.this.isCancelled)
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.d.d.flM();
            c.lx(paramAnonymousString.FhU, paramAnonymousString.hFF);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.this.Ivb != null) {
            c.this.Ivb.bg(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    lx(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.Ivc = parama;
    com.tencent.mm.kernel.g.azz().a(new f(paramString2, paramString3, paramString1), 0);
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
        paramq = paramString.wFE;
        com.tencent.mm.plugin.walletlock.c.g.IwU.IwV = paramq;
        yC(paramString.Ivf);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.Ivb != null)
      {
        this.Ivb.bg(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramq instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        h.yG(true);
        if (this.Ivc != null)
        {
          this.Ivc.bg(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.aqK(3);
        h.yG(false);
        if (this.Ivc != null) {
          this.Ivc.bg(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    Log.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.Ivb = null;
    this.Ivc = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.g.azz().b(1967, this);
    com.tencent.mm.kernel.g.azz().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */