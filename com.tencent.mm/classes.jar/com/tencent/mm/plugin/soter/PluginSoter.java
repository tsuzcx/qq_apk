package com.tencent.mm.plugin.soter;

import android.os.Build;
import android.util.SparseArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c AED;
  private static com.tencent.mm.plugin.soter.d.b AEE;
  private com.tencent.mm.plugin.soter.d.f AEB = null;
  private boolean AEC = false;
  private int AEF = 0;
  private com.tencent.mm.vending.b.b jEv;
  private String lEN = "";
  
  static
  {
    AppMethodBeat.i(130796);
    AED = new com.tencent.mm.plugin.soter.d.c();
    AEE = new com.tencent.mm.plugin.soter.d.b();
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
        if (!com.tencent.mm.kernel.g.ajA().aiK())
        {
          ad.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str1;
        String str2;
        if (!bt.isNullOrNil(PluginSoter.this.lEN))
        {
          str1 = PluginSoter.this.lEN;
          str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICO, "");
          ad.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", new Object[] { str2, str1, PluginSoter.this.lEN });
          if ((bt.isNullOrNil(str1)) && (PluginSoter.this.AEF < 10)) {
            break label307;
          }
          if ((bt.isNullOrNil(str2)) || (str2.equals(str1))) {
            break label242;
          }
          ad.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", new Object[] { str2, str1 });
          m.AFG = str2;
          label153:
          ad.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.AEF), str1, m.AFG });
          if (PluginSoter.this.AEF < 10) {
            break label269;
          }
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 44);
        }
        for (;;)
        {
          com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$200(PluginSoter.this), new PluginSoter.1.1(this));
          AppMethodBeat.o(130782);
          return false;
          str1 = u.aAp();
          break;
          label242:
          if (bt.isNullOrNil(str2)) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICO, str1);
          }
          m.AFG = str1;
          break label153;
          label269:
          if (PluginSoter.this.AEF > 0) {
            com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 45);
          } else {
            com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 47);
          }
        }
        label307:
        ad.i("MicroMsg.PluginSoter", "username is null, delay init");
        PluginSoter.access$108(PluginSoter.this);
        AppMethodBeat.o(130782);
        return true;
      }
    }, true).az(100L, 1000L);
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
    if (com.tencent.mm.sdk.b.a.IbL.e(paramc))
    {
      ad.w("MicroMsg.PluginSoter", "hy: already has listener");
      AppMethodBeat.o(130787);
      return;
    }
    com.tencent.mm.sdk.b.a.IbL.c(paramc);
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
    com.tencent.mm.sdk.b.a.IbL.d(paramc);
    AppMethodBeat.o(130788);
  }
  
  private boolean shouldPreparedASK()
  {
    AppMethodBeat.i(130790);
    com.tencent.mm.plugin.soter.d.e locale = d.efE();
    if ((!bt.isNullOrNil(locale.AFy)) && (!bt.isNullOrNil(locale.AFz))) {}
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
    if (paramg.akw())
    {
      ad.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.AEC = true;
      ad.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.AEB = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.AEB);
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
    ad.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.AEC) });
    if (this.AEC)
    {
      m.efG();
      this.lEN = u.aAp();
      initSoter();
      this.jEv = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          ad.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          h.LTJ.aR(new PluginSoter.2.1(this));
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.fUW().isInit()) && (((String)com.tencent.soter.a.c.b.fUW().fUY().get(1)).equals("WechatAuthKeyPay&null")))
          {
            ad.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.fUW().zs(false);
            PluginSoter.access$300(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!com.tencent.mm.sdk.b.a.IbL.e(AED)) {
      com.tencent.mm.sdk.b.a.IbL.c(AED);
    }
    if (!com.tencent.mm.sdk.b.a.IbL.e(AEE)) {
      com.tencent.mm.sdk.b.a.IbL.c(AEE);
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    ad.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.AEC) {
      this.jEv.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.AEB);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */