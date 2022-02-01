package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.a.a;

public final class c
  implements com.tencent.mm.am.h, d
{
  private d.a WfP = null;
  private d.a WfQ = null;
  private boolean WfR = false;
  private boolean isCancelled = false;
  private String qgt = null;
  
  private void Ic(boolean paramBoolean)
  {
    AppMethodBeat.i(129678);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.soter.a.b.b local1 = new com.tencent.soter.a.b.b() {};
    if (this.WfR) {}
    for (Object localObject = null;; localObject = new g(this.qgt))
    {
      a.a(local1, paramBoolean, 3, (com.tencent.soter.a.f.e)localObject, new com.tencent.mm.plugin.soter.b.f());
      AppMethodBeat.o(129678);
      return;
    }
  }
  
  private static void nG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(129679);
    paramString1 = new e(paramString1, paramString2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(129679);
  }
  
  public final void a(d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(129677);
    this.qgt = paramBundle.getString("key_pay_passwd");
    this.WfR = paramBundle.getBoolean("key_fp_lock_offline_mode");
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[] { this.qgt, Boolean.valueOf(this.WfR) });
    this.WfP = parama;
    this.isCancelled = false;
    com.tencent.mm.plugin.walletlock.model.f.WhM.WhN = null;
    com.tencent.mm.plugin.walletlock.model.f.WhM.WhO = null;
    com.tencent.mm.kernel.h.aZW().a(1967, this);
    com.tencent.mm.kernel.h.aZW().a(1548, this);
    if (this.WfR)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.walletlock.model.f.WhM.WhN = String.valueOf(l);
      Ic(false);
      AppMethodBeat.o(129677);
      return;
    }
    if (MMApplicationContext.getDefaultPreference() == null)
    {
      if (this.WfP != null) {
        this.WfP.bL(2, "system error");
      }
      AppMethodBeat.o(129677);
      return;
    }
    paramBundle = com.tencent.mm.plugin.soter.model.b.htz();
    parama = paramBundle.RZY;
    paramBundle = paramBundle.mXG;
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[] { parama, paramBundle });
    if ((Util.isNullOrNil(parama)) || (Util.isNullOrNil(paramBundle)))
    {
      com.tencent.mm.plugin.soter.d.b.a(true, new com.tencent.mm.plugin.soter.model.d()
      {
        public final void bL(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(129676);
          if (c.a(c.this))
          {
            AppMethodBeat.o(129676);
            return;
          }
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = com.tencent.mm.plugin.soter.model.b.htz();
            c.nH(paramAnonymousString.RZY, paramAnonymousString.mXG);
            AppMethodBeat.o(129676);
            return;
          }
          if (c.b(c.this) != null) {
            c.b(c.this).bL(2, "init soter failed");
          }
          AppMethodBeat.o(129676);
        }
      });
      AppMethodBeat.o(129677);
      return;
    }
    nG(parama, paramBundle);
    AppMethodBeat.o(129677);
  }
  
  public final void a(d.a parama, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(129680);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
    this.WfQ = parama;
    com.tencent.mm.kernel.h.aZW().a(new f(paramString2, paramString3, paramString1), 0);
    AppMethodBeat.o(129680);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(129682);
    Log.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if (this.isCancelled)
    {
      AppMethodBeat.o(129682);
      return;
    }
    if ((paramp instanceof e))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (e)paramp;
        paramp = paramString.Hgd;
        com.tencent.mm.plugin.walletlock.model.f.WhM.WhN = paramp;
        Ic(paramString.WfT);
        AppMethodBeat.o(129682);
        return;
      }
      if (this.WfP != null)
      {
        this.WfP.bL(7, "get challenge failed");
        AppMethodBeat.o(129682);
      }
    }
    else if ((paramp instanceof f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.walletlock.model.g.Ig(true);
        if (this.WfQ != null)
        {
          this.WfQ.bL(0, "open touch lock ok");
          AppMethodBeat.o(129682);
        }
      }
      else
      {
        a.aHj(3);
        com.tencent.mm.plugin.walletlock.model.g.Ig(false);
        if (this.WfQ != null) {
          this.WfQ.bL(6, "open touch lock failed");
        }
      }
    }
    AppMethodBeat.o(129682);
  }
  
  public final void release()
  {
    AppMethodBeat.i(129681);
    Log.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
    this.WfP = null;
    this.WfQ = null;
    this.isCancelled = true;
    com.tencent.mm.kernel.h.aZW().b(1967, this);
    com.tencent.mm.kernel.h.aZW().b(1548, this);
    AppMethodBeat.o(129681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c
 * JD-Core Version:    0.7.0.1
 */