package com.tencent.mm.plugin.soter;

import android.os.Build;
import android.util.SparseArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c AWg;
  private static com.tencent.mm.plugin.soter.d.b AWh;
  private com.tencent.mm.plugin.soter.d.f AWe = null;
  private boolean AWf = false;
  private int AWi = 0;
  private com.tencent.mm.vending.b.b jHu;
  private String lJm = "";
  
  static
  {
    AppMethodBeat.i(130796);
    AWg = new com.tencent.mm.plugin.soter.d.c();
    AWh = new com.tencent.mm.plugin.soter.d.b();
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
    new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130782);
        if (!com.tencent.mm.kernel.g.ajP().aiZ())
        {
          ae.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str1;
        String str2;
        if (!bu.isNullOrNil(PluginSoter.this.lJm))
        {
          str1 = PluginSoter.this.lJm;
          str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXo, "");
          ae.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", new Object[] { str2, str1, PluginSoter.this.lJm });
          if ((bu.isNullOrNil(str1)) && (PluginSoter.this.AWi < 10)) {
            break label307;
          }
          if ((bu.isNullOrNil(str2)) || (str2.equals(str1))) {
            break label242;
          }
          ae.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", new Object[] { str2, str1 });
          m.AXj = str2;
          label153:
          ae.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.AWi), str1, m.AXj });
          if (PluginSoter.this.AWi < 10) {
            break label269;
          }
          com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 44);
        }
        for (;;)
        {
          com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$200(PluginSoter.this), new PluginSoter.1.1(this));
          AppMethodBeat.o(130782);
          return false;
          str1 = v.aAF();
          break;
          label242:
          if (bu.isNullOrNil(str2)) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXo, str1);
          }
          m.AXj = str1;
          break label153;
          label269:
          if (PluginSoter.this.AWi > 0) {
            com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 45);
          } else {
            com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 47);
          }
        }
        label307:
        ae.i("MicroMsg.PluginSoter", "username is null, delay init");
        PluginSoter.access$108(PluginSoter.this);
        AppMethodBeat.o(130782);
        return true;
      }
    }, true).ay(100L, 1000L);
    AppMethodBeat.o(130791);
  }
  
  private void safeAddListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(130787);
    if (paramc == null)
    {
      ae.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
      AppMethodBeat.o(130787);
      return;
    }
    if (com.tencent.mm.sdk.b.a.IvT.e(paramc))
    {
      ae.w("MicroMsg.PluginSoter", "hy: already has listener");
      AppMethodBeat.o(130787);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.c(paramc);
    AppMethodBeat.o(130787);
  }
  
  private void safeRemoveListener(com.tencent.mm.sdk.b.c paramc)
  {
    AppMethodBeat.i(130788);
    if (paramc == null)
    {
      ae.w("MicroMsg.PluginSoter", "alvinluo listener is null");
      AppMethodBeat.o(130788);
      return;
    }
    com.tencent.mm.sdk.b.a.IvT.d(paramc);
    AppMethodBeat.o(130788);
  }
  
  private boolean shouldPreparedASK()
  {
    AppMethodBeat.i(130790);
    com.tencent.mm.plugin.soter.d.e locale = d.ejm();
    if ((!bu.isNullOrNil(locale.AXb)) && (!bu.isNullOrNil(locale.AXc))) {}
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
    if (paramg.akL())
    {
      ae.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.AWf = true;
      ae.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.AWe = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.AWe);
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
    ae.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.AWf) });
    if (this.AWf)
    {
      m.ejo();
      this.lJm = v.aAF();
      initSoter();
      this.jHu = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          ae.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          h.MqF.aO(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130783);
              long l1 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWY, Long.valueOf(0L))).longValue();
              long l2 = System.currentTimeMillis();
              if ((l2 - l1 > 86400000L) && (com.tencent.soter.a.a.fZr()))
              {
                com.tencent.mm.plugin.report.service.g.yxI.dD(1034, 1);
                com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWY, Long.valueOf(l2));
              }
              AppMethodBeat.o(130783);
            }
          });
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.fZv().isInit()) && (((String)com.tencent.soter.a.c.b.fZv().fZx().get(1)).equals("WechatAuthKeyPay&null")))
          {
            ae.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.fZv().zG(false);
            PluginSoter.access$300(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!com.tencent.mm.sdk.b.a.IvT.e(AWg)) {
      com.tencent.mm.sdk.b.a.IvT.c(AWg);
    }
    if (!com.tencent.mm.sdk.b.a.IvT.e(AWh)) {
      com.tencent.mm.sdk.b.a.IvT.c(AWh);
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    ae.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.AWf) {
      this.jHu.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.AWe);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */