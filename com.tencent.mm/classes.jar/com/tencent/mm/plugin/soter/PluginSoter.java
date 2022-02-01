package com.tencent.mm.plugin.soter;

import android.os.Build;
import android.util.SparseArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.d.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, a
{
  private static com.tencent.mm.plugin.soter.d.c LvE;
  private static com.tencent.mm.plugin.soter.d.b LvF;
  private com.tencent.mm.plugin.soter.d.f LvC = null;
  private boolean LvD = false;
  private int LvG = 0;
  private com.tencent.mm.vending.b.b nDk;
  private String pRV = "";
  
  static
  {
    AppMethodBeat.i(130796);
    LvE = new com.tencent.mm.plugin.soter.d.c();
    LvF = new com.tencent.mm.plugin.soter.d.b();
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
    new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(130782);
        if (!com.tencent.mm.kernel.h.aHE().aGM())
        {
          Log.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str1;
        String str2;
        if (!Util.isNullOrNil(PluginSoter.this.pRV))
        {
          str1 = PluginSoter.this.pRV;
          str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtV, "");
          Log.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", new Object[] { str2, str1, PluginSoter.this.pRV });
          if ((Util.isNullOrNil(str1)) && (PluginSoter.this.LvG < 10)) {
            break label307;
          }
          if ((Util.isNullOrNil(str2)) || (str2.equals(str1))) {
            break label242;
          }
          Log.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", new Object[] { str2, str1 });
          m.LwG = str2;
          label153:
          Log.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.LvG), str1, m.LwG });
          if (PluginSoter.this.LvG < 10) {
            break label269;
          }
          com.tencent.mm.plugin.report.service.h.IzE.el(1104, 44);
        }
        for (;;)
        {
          com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$200(PluginSoter.this), new com.tencent.mm.plugin.soter.d.g()
          {
            public final void bh(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(130781);
              Log.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              pk localpk = new pk();
              localpk.fOe.errCode = paramAnonymous2Int;
              localpk.fOe.errMsg = paramAnonymous2String;
              EventCenter.instance.publish(localpk);
              AppMethodBeat.o(130781);
            }
          });
          AppMethodBeat.o(130782);
          return false;
          str1 = z.bdc();
          break;
          label242:
          if (Util.isNullOrNil(str2)) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtV, str1);
          }
          m.LwG = str1;
          break label153;
          label269:
          if (PluginSoter.this.LvG > 0) {
            com.tencent.mm.plugin.report.service.h.IzE.el(1104, 45);
          } else {
            com.tencent.mm.plugin.report.service.h.IzE.el(1104, 47);
          }
        }
        label307:
        Log.i("MicroMsg.PluginSoter", "username is null, delay init");
        PluginSoter.access$108(PluginSoter.this);
        AppMethodBeat.o(130782);
        return true;
      }
    }, true).startTimer(100L, 1000L);
    AppMethodBeat.o(130791);
  }
  
  private void safeAddListener(IListener paramIListener)
  {
    AppMethodBeat.i(130787);
    if (paramIListener == null)
    {
      Log.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
      AppMethodBeat.o(130787);
      return;
    }
    if (EventCenter.instance.hadListened(paramIListener))
    {
      Log.w("MicroMsg.PluginSoter", "hy: already has listener");
      AppMethodBeat.o(130787);
      return;
    }
    EventCenter.instance.addListener(paramIListener);
    AppMethodBeat.o(130787);
  }
  
  private void safeRemoveListener(IListener paramIListener)
  {
    AppMethodBeat.i(130788);
    if (paramIListener == null)
    {
      Log.w("MicroMsg.PluginSoter", "alvinluo listener is null");
      AppMethodBeat.o(130788);
      return;
    }
    EventCenter.instance.removeListener(paramIListener);
    AppMethodBeat.o(130788);
  }
  
  private boolean shouldPreparedASK()
  {
    AppMethodBeat.i(130790);
    e locale = d.gai();
    if ((!Util.isNullOrNil(locale.Lwz)) && (!Util.isNullOrNil(locale.ktM))) {}
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
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.LvD = true;
      Log.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.LvC = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.LvC);
    }
    AppMethodBeat.o(130785);
  }
  
  public String name()
  {
    return "plugin-soter";
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(130792);
    Log.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.LvD) });
    if (this.LvD)
    {
      m.gak();
      this.pRV = z.bdc();
      initSoter();
      this.nDk = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          Log.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          com.tencent.e.h.ZvG.be(new PluginSoter.2.1(this));
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.ipf().isInit()) && (((String)com.tencent.soter.a.c.b.ipf().iph().get(1)).equals("WechatAuthKeyPay&null")))
          {
            Log.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.ipf().Ir(false);
            PluginSoter.access$300(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!EventCenter.instance.hadListened(LvE)) {
      EventCenter.instance.addListener(LvE);
    }
    if (!EventCenter.instance.hadListened(LvF)) {
      EventCenter.instance.addListener(LvF);
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    Log.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.LvD) {
      this.nDk.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.LvC);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */