package com.tencent.mm.plugin.soter;

import android.os.Build;
import android.util.SparseArray;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.soter.d.d;
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
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static com.tencent.mm.plugin.soter.d.c FgZ;
  private static com.tencent.mm.plugin.soter.d.b Fha;
  private com.tencent.mm.plugin.soter.d.f FgX = null;
  private boolean FgY = false;
  private int Fhb = 0;
  private com.tencent.mm.vending.b.b kJs;
  private String mRa = "";
  
  static
  {
    AppMethodBeat.i(130796);
    FgZ = new com.tencent.mm.plugin.soter.d.c();
    Fha = new com.tencent.mm.plugin.soter.d.b();
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
        if (!com.tencent.mm.kernel.g.aAf().azp())
        {
          Log.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str1;
        String str2;
        if (!Util.isNullOrNil(PluginSoter.this.mRa))
        {
          str1 = PluginSoter.this.mRa;
          str2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OfH, "");
          Log.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", new Object[] { str2, str1, PluginSoter.this.mRa });
          if ((Util.isNullOrNil(str1)) && (PluginSoter.this.Fhb < 10)) {
            break label307;
          }
          if ((Util.isNullOrNil(str2)) || (str2.equals(str1))) {
            break label242;
          }
          Log.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", new Object[] { str2, str1 });
          m.Fib = str2;
          label153:
          Log.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.Fhb), str1, m.Fib });
          if (PluginSoter.this.Fhb < 10) {
            break label269;
          }
          com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 44);
        }
        for (;;)
        {
          com.tencent.mm.plugin.soter.e.b.a(PluginSoter.access$200(PluginSoter.this), new PluginSoter.1.1(this));
          AppMethodBeat.o(130782);
          return false;
          str1 = z.aUb();
          break;
          label242:
          if (Util.isNullOrNil(str2)) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfH, str1);
          }
          m.Fib = str1;
          break label153;
          label269:
          if (PluginSoter.this.Fhb > 0) {
            com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 45);
          } else {
            com.tencent.mm.plugin.report.service.h.CyF.dN(1104, 47);
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
    com.tencent.mm.plugin.soter.d.e locale = d.flM();
    if ((!Util.isNullOrNil(locale.FhU)) && (!Util.isNullOrNil(locale.hFF))) {}
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
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.FgY = true;
      Log.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.FgX = new com.tencent.mm.plugin.soter.d.f();
      safeAddListener(this.FgX);
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
    Log.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.FgY) });
    if (this.FgY)
    {
      m.flO();
      this.mRa = z.aUb();
      initSoter();
      this.kJs = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          Log.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          com.tencent.f.h.RTc.aX(new PluginSoter.2.1(this));
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.hlG().isInit()) && (((String)com.tencent.soter.a.c.b.hlG().hlI().get(1)).equals("WechatAuthKeyPay&null")))
          {
            Log.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.hlG().DQ(false);
            PluginSoter.access$300(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!EventCenter.instance.hadListened(FgZ)) {
      EventCenter.instance.addListener(FgZ);
    }
    if (!EventCenter.instance.hadListened(Fha)) {
      EventCenter.instance.addListener(Fha);
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    Log.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.FgY) {
      this.kJs.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.FgX);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */