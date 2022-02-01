package com.tencent.mm.plugin.soter;

import android.os.Build;
import android.util.SparseArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c xZJ;
  private static com.tencent.mm.plugin.soter.d.b xZK;
  private com.tencent.mm.vending.b.b iKz;
  private com.tencent.mm.plugin.soter.d.f xZH = null;
  private boolean xZI = false;
  private int xZL = 0;
  
  static
  {
    AppMethodBeat.i(130796);
    xZJ = new com.tencent.mm.plugin.soter.d.c();
    xZK = new com.tencent.mm.plugin.soter.d.b();
    AppMethodBeat.o(130796);
  }
  
  private boolean block()
  {
    AppMethodBeat.i(130789);
    String str = Build.MODEL;
    if (("NCE-AL10".equals(str)) || ("NCE-AL00".equals(str)) || ("NCE-TL10".equals(str)))
    {
      AppMethodBeat.o(130789);
      return true;
    }
    AppMethodBeat.o(130789);
    return false;
  }
  
  private void initSoter()
  {
    AppMethodBeat.i(130791);
    new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130782);
        if (!com.tencent.mm.kernel.g.afz().aeI())
        {
          ad.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str = u.aqJ();
        if ((!bt.isNullOrNil(str)) || (PluginSoter.this.xZL >= 10))
        {
          ad.i("MicroMsg.PluginSoter", "do init soter: %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.xZL), str });
          if (PluginSoter.this.xZL >= 10) {
            com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 44);
          }
          for (;;)
          {
            com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$100(PluginSoter.this), new com.tencent.mm.plugin.soter.d.g()
            {
              public final void aU(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(130781);
                ad.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
                nd localnd = new nd();
                localnd.dsj.errCode = paramAnonymous2Int;
                localnd.dsj.errMsg = paramAnonymous2String;
                com.tencent.mm.sdk.b.a.ESL.l(localnd);
                AppMethodBeat.o(130781);
              }
            });
            AppMethodBeat.o(130782);
            return false;
            if (PluginSoter.this.xZL > 0) {
              com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 45);
            } else {
              com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 47);
            }
          }
        }
        ad.i("MicroMsg.PluginSoter", "username is null, delay init");
        PluginSoter.access$008(PluginSoter.this);
        AppMethodBeat.o(130782);
        return true;
      }
    }, true).av(100L, 1000L);
    AppMethodBeat.o(130791);
  }
  
  private void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(130787);
    if (paramc == null)
    {
      ad.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
      AppMethodBeat.o(130787);
      return;
    }
    if (com.tencent.mm.sdk.b.a.ESL.e(paramc))
    {
      ad.w("MicroMsg.PluginSoter", "hy: already has listener");
      AppMethodBeat.o(130787);
      return;
    }
    com.tencent.mm.sdk.b.a.ESL.c(paramc);
    AppMethodBeat.o(130787);
  }
  
  private void safeRemoveListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(130788);
    if (paramc == null)
    {
      ad.w("MicroMsg.PluginSoter", "alvinluo listener is null");
      AppMethodBeat.o(130788);
      return;
    }
    com.tencent.mm.sdk.b.a.ESL.d(paramc);
    AppMethodBeat.o(130788);
  }
  
  private boolean shouldPreparedASK()
  {
    AppMethodBeat.i(130790);
    com.tencent.mm.plugin.soter.d.e locale = d.dEQ();
    if ((!bt.isNullOrNil(locale.yaF)) && (!bt.isNullOrNil(locale.yaG))) {}
    for (int i = 1; (i == 0) && (!block()); i = 0)
    {
      AppMethodBeat.o(130790);
      return true;
    }
    AppMethodBeat.o(130790);
    return false;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(130785);
    if (paramg.agu())
    {
      ad.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.xZI = true;
      ad.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.xZH = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.xZH);
    }
    AppMethodBeat.o(130785);
  }
  
  public String name()
  {
    return "plugin-soter";
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(130792);
    ad.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.xZI) });
    if (this.xZI)
    {
      m.dES();
      initSoter();
      this.iKz = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          ad.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          com.tencent.e.h.Iye.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130783);
              long l1 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fsn, Long.valueOf(0L))).longValue();
              long l2 = System.currentTimeMillis();
              if ((l2 - l1 > 86400000L) && (com.tencent.soter.a.a.fnk()))
              {
                com.tencent.mm.plugin.report.service.h.vKh.dB(1034, 1);
                com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fsn, Long.valueOf(l2));
              }
              AppMethodBeat.o(130783);
            }
          });
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.fno().isInit()) && (((String)com.tencent.soter.a.c.b.fno().fnq().get(1)).equals("WechatAuthKeyPay&null")))
          {
            ad.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.fno().xv(false);
            PluginSoter.access$200(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!com.tencent.mm.sdk.b.a.ESL.e(xZJ)) {
      com.tencent.mm.sdk.b.a.ESL.c(xZJ);
    }
    if (!com.tencent.mm.sdk.b.a.ESL.e(xZK)) {
      com.tencent.mm.sdk.b.a.ESL.c(xZK);
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    ad.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.xZI) {
      this.iKz.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.xZH);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */