package com.tencent.mm.plugin.soter;

import android.os.Build;
import android.util.SparseArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c zmJ;
  private static com.tencent.mm.plugin.soter.d.b zmK;
  private com.tencent.mm.vending.b.b jkF;
  private String lhM = "";
  private com.tencent.mm.plugin.soter.d.f zmH = null;
  private boolean zmI = false;
  private int zmL = 0;
  
  static
  {
    AppMethodBeat.i(130796);
    zmJ = new com.tencent.mm.plugin.soter.d.c();
    zmK = new com.tencent.mm.plugin.soter.d.b();
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
    new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130782);
        if (!com.tencent.mm.kernel.g.agP().afY())
        {
          ac.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str1;
        String str2;
        if (!bs.isNullOrNil(PluginSoter.this.lhM))
        {
          str1 = PluginSoter.this.lhM;
          str2 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQu, "");
          ac.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", new Object[] { str2, str1, PluginSoter.this.lhM });
          if ((bs.isNullOrNil(str1)) && (PluginSoter.this.zmL < 10)) {
            break label307;
          }
          if ((bs.isNullOrNil(str2)) || (str2.equals(str1))) {
            break label242;
          }
          ac.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", new Object[] { str2, str1 });
          m.znM = str2;
          label153:
          ac.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.zmL), str1, m.znM });
          if (PluginSoter.this.zmL < 10) {
            break label269;
          }
          com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 44);
        }
        for (;;)
        {
          com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$200(PluginSoter.this), new com.tencent.mm.plugin.soter.d.g()
          {
            public final void aZ(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(130781);
              ac.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              nm localnm = new nm();
              localnm.dpU.errCode = paramAnonymous2Int;
              localnm.dpU.errMsg = paramAnonymous2String;
              com.tencent.mm.sdk.b.a.GpY.l(localnm);
              AppMethodBeat.o(130781);
            }
          });
          AppMethodBeat.o(130782);
          return false;
          str1 = u.axz();
          break;
          label242:
          if (bs.isNullOrNil(str2)) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQu, str1);
          }
          m.znM = str1;
          break label153;
          label269:
          if (PluginSoter.this.zmL > 0) {
            com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 45);
          } else {
            com.tencent.mm.plugin.report.service.h.wUl.dB(1104, 47);
          }
        }
        label307:
        ac.i("MicroMsg.PluginSoter", "username is null, delay init");
        PluginSoter.access$108(PluginSoter.this);
        AppMethodBeat.o(130782);
        return true;
      }
    }, true).au(100L, 1000L);
    AppMethodBeat.o(130791);
  }
  
  private void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(130787);
    if (paramc == null)
    {
      ac.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
      AppMethodBeat.o(130787);
      return;
    }
    if (com.tencent.mm.sdk.b.a.GpY.e(paramc))
    {
      ac.w("MicroMsg.PluginSoter", "hy: already has listener");
      AppMethodBeat.o(130787);
      return;
    }
    com.tencent.mm.sdk.b.a.GpY.c(paramc);
    AppMethodBeat.o(130787);
  }
  
  private void safeRemoveListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(130788);
    if (paramc == null)
    {
      ac.w("MicroMsg.PluginSoter", "alvinluo listener is null");
      AppMethodBeat.o(130788);
      return;
    }
    com.tencent.mm.sdk.b.a.GpY.d(paramc);
    AppMethodBeat.o(130788);
  }
  
  private boolean shouldPreparedASK()
  {
    AppMethodBeat.i(130790);
    com.tencent.mm.plugin.soter.d.e locale = d.dTq();
    if ((!bs.isNullOrNil(locale.znE)) && (!bs.isNullOrNil(locale.znF))) {}
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
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.zmI = true;
      ac.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.zmH = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.zmH);
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
    ac.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.zmI) });
    if (this.zmI)
    {
      m.dTs();
      this.lhM = u.axz();
      initSoter();
      this.jkF = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          ac.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          com.tencent.e.h.JZN.aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130783);
              long l1 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQe, Long.valueOf(0L))).longValue();
              long l2 = System.currentTimeMillis();
              if ((l2 - l1 > 86400000L) && (com.tencent.soter.a.a.fDA()))
              {
                com.tencent.mm.plugin.report.service.h.wUl.dB(1034, 1);
                com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQe, Long.valueOf(l2));
              }
              AppMethodBeat.o(130783);
            }
          });
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.fDE().isInit()) && (((String)com.tencent.soter.a.c.b.fDE().fDG().get(1)).equals("WechatAuthKeyPay&null")))
          {
            ac.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.fDE().yF(false);
            PluginSoter.access$300(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!com.tencent.mm.sdk.b.a.GpY.e(zmJ)) {
      com.tencent.mm.sdk.b.a.GpY.c(zmJ);
    }
    if (!com.tencent.mm.sdk.b.a.GpY.e(zmK)) {
      com.tencent.mm.sdk.b.a.GpY.c(zmK);
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    ac.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.zmI) {
      this.jkF.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.zmH);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */