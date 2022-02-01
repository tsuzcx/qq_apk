package com.tencent.mm.plugin.soter;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qx;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.soter.model.GetIsEnrolledListener;
import com.tencent.mm.plugin.soter.model.GetSupportSoterEventListener;
import com.tencent.mm.plugin.soter.model.SoterDynamicConfigUpdatedEventListener;
import com.tencent.mm.plugin.soter.model.d;
import com.tencent.mm.plugin.soter.model.j;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;

public class PluginSoter
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.soter.a.a
{
  private static GetSupportSoterEventListener RZc;
  private static GetIsEnrolledListener RZd;
  private SoterDynamicConfigUpdatedEventListener RZb = null;
  private int RZe = 0;
  private com.tencent.mm.vending.b.b qDd;
  private boolean rgc = false;
  private String sWX = "";
  
  static
  {
    AppMethodBeat.i(130796);
    RZc = new GetSupportSoterEventListener();
    RZd = new GetIsEnrolledListener();
    AppMethodBeat.o(130796);
  }
  
  private boolean block()
  {
    AppMethodBeat.i(130789);
    String str = q.aPo();
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
        if (!com.tencent.mm.kernel.h.baC().aZN())
        {
          Log.i("MicroMsg.PluginSoter", "account not ready.");
          AppMethodBeat.o(130782);
          return false;
        }
        String str1;
        String str2;
        if (!Util.isNullOrNil(PluginSoter.this.sWX))
        {
          str1 = PluginSoter.this.sWX;
          str2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVA, "");
          Log.i("MicroMsg.PluginSoter", "username old: %s, new: %s, %s", new Object[] { str2, str1, PluginSoter.this.sWX });
          if ((Util.isNullOrNil(str1)) && (PluginSoter.this.RZe < 10)) {
            break label307;
          }
          if ((Util.isNullOrNil(str2)) || (str2.equals(str1))) {
            break label242;
          }
          Log.i("MicroMsg.PluginSoter", "have changed username, old: %s, new: %s", new Object[] { str2, str1 });
          j.Saf = str2;
          label153:
          Log.i("MicroMsg.PluginSoter", "do init soter: %s, %s, %s", new Object[] { Integer.valueOf(PluginSoter.this.RZe), str1, j.Saf });
          if (PluginSoter.this.RZe < 10) {
            break label269;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 44);
        }
        for (;;)
        {
          com.tencent.mm.plugin.soter.d.b.a(PluginSoter.access$200(PluginSoter.this), new d()
          {
            public final void bL(int paramAnonymous2Int, String paramAnonymous2String)
            {
              AppMethodBeat.i(130781);
              Log.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int), paramAnonymous2String });
              qx localqx = new qx();
              localqx.hTW.errCode = paramAnonymous2Int;
              localqx.hTW.errMsg = paramAnonymous2String;
              localqx.publish();
              AppMethodBeat.o(130781);
            }
          });
          AppMethodBeat.o(130782);
          return false;
          str1 = z.bAP();
          break;
          label242:
          if (Util.isNullOrNil(str2)) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acVA, str1);
          }
          j.Saf = str1;
          break label153;
          label269:
          if (PluginSoter.this.RZe > 0) {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 45);
          } else {
            com.tencent.mm.plugin.report.service.h.OAn.kJ(1104, 47);
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
    paramIListener.alive();
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
    paramIListener.dead();
    AppMethodBeat.o(130788);
  }
  
  private boolean shouldPreparedASK()
  {
    AppMethodBeat.i(130790);
    com.tencent.mm.plugin.soter.model.c localc = com.tencent.mm.plugin.soter.model.b.htz();
    if ((!Util.isNullOrNil(localc.RZY)) && (!Util.isNullOrNil(localc.mXG))) {}
    for (int i = 1; (i == 0) && (!block()); i = 0)
    {
      AppMethodBeat.o(130790);
      return true;
    }
    AppMethodBeat.o(130790);
    return false;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(130785);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", new Object[] { paramg.mProcessName });
      this.rgc = true;
      Log.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
      this.RZb = new SoterDynamicConfigUpdatedEventListener();
      safeAddListener(this.RZb);
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
    Log.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", new Object[] { Boolean.valueOf(this.rgc) });
    if (this.rgc)
    {
      j.htB();
      this.sWX = z.bAP();
      initSoter();
      this.qDd = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
      {
        public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(130784);
          Log.i("MicroMsg.PluginSoter", "autoAuth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          com.tencent.threadpool.h.ahAA.bm(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130783);
              long l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVi, Long.valueOf(0L))).longValue();
              long l2 = System.currentTimeMillis();
              if ((l2 - l1 > 86400000L) && (com.tencent.soter.a.a.jYp()))
              {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1034, 1);
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acVi, Long.valueOf(l2));
              }
              AppMethodBeat.o(130783);
            }
          });
          if ((!paramAnonymousBoolean) && (com.tencent.soter.a.c.b.jYt().isInit()) && (((String)com.tencent.soter.a.c.b.jYt().jYv().get(1)).equals("WechatAuthKeyPay&null")))
          {
            Log.i("MicroMsg.PluginSoter", "init error, reinit");
            com.tencent.soter.a.c.b.jYt().Ot(false);
            PluginSoter.access$300(PluginSoter.this);
          }
          AppMethodBeat.o(130784);
        }
        
        public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
      });
    }
    if (!EventCenter.instance.hadListened(RZc)) {
      RZc.alive();
    }
    if (!EventCenter.instance.hadListened(RZd)) {
      RZd.alive();
    }
    AppMethodBeat.o(130792);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(130793);
    Log.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    if (this.rgc) {
      this.qDd.dead();
    }
    AppMethodBeat.o(130793);
  }
  
  public void uninstalled()
  {
    AppMethodBeat.i(130786);
    super.uninstalled();
    safeRemoveListener(this.RZb);
    AppMethodBeat.o(130786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter
 * JD-Core Version:    0.7.0.1
 */