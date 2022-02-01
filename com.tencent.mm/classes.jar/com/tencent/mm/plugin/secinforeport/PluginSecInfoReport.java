package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.e;
import com.tencent.mm.autogen.a.nj;
import com.tencent.mm.autogen.a.qv;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.autogen.a.ui;
import com.tencent.mm.autogen.a.uj;
import com.tencent.mm.autogen.a.uo;
import com.tencent.mm.autogen.a.up;
import com.tencent.mm.autogen.a.ur;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.normsg.d.j;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;

public class PluginSecInfoReport
  extends com.tencent.mm.kernel.b.f
  implements b
{
  private q.a appForegroundListener;
  
  public PluginSecInfoReport()
  {
    AppMethodBeat.i(89155);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89144);
        MMApplicationContext.isMainProcess();
        AppMethodBeat.o(89144);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89143);
        if (MMApplicationContext.isMainProcess())
        {
          if ((TextUtils.isEmpty(com.tencent.mm.compatible.deviceinfo.q.getAndroidId())) && (!com.tencent.mm.kernel.h.baz()))
          {
            AppMethodBeat.o(89143);
            return;
          }
          PluginSecInfoReport.access$000(PluginSecInfoReport.this);
        }
        AppMethodBeat.o(89143);
      }
    };
    AppMethodBeat.o(89155);
  }
  
  private void TrustIdRequestAsync()
  {
    AppMethodBeat.i(89162);
    if ((com.tencent.mm.plugin.secinforeport.a.d.Pmb.aZ(3, 86400000L)) || ((!com.tencent.mm.plugin.normsg.a.d.MtP.gtG()) && (com.tencent.mm.plugin.secinforeport.a.d.Pmb.aZ(10, 21600000L))))
    {
      Log.i("MicroMsg.PSIR", "[+] req task posted.");
      if ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert) && (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)))
      {
        Log.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
        AppMethodBeat.o(89162);
        return;
      }
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          int i = -1;
          AppMethodBeat.i(261972);
          j localj = new j();
          if (!com.tencent.mm.plugin.normsg.a.d.MtP.gtG())
          {
            localObject = com.tencent.mm.plugin.normsg.a.d.MtP.aeS(1);
            if (localObject == null) {}
            for (;;)
            {
              Log.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
              if ((localObject != null) && (localObject.length != 0)) {
                break;
              }
              AppMethodBeat.o(261972);
              return;
              i = localObject.length;
            }
            localj.gun();
            if (com.tencent.mm.kernel.h.baz()) {}
            for (localObject = new com.tencent.mm.plugin.normsg.b.b(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.b(true, (byte[])localObject))
            {
              if (!com.tencent.mm.kernel.h.aZW().a((p)localObject, 0))
              {
                Log.e("TrustRequestManager", "[debug] doScene faild");
                localj.guo();
              }
              AppMethodBeat.o(261972);
              return;
            }
          }
          Object localObject = com.tencent.mm.plugin.normsg.a.d.MtP.aeS(2);
          if (localObject == null) {}
          for (;;)
          {
            Log.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
            if ((localObject != null) && (localObject.length != 0)) {
              break;
            }
            AppMethodBeat.o(261972);
            return;
            i = localObject.length;
          }
          localj.gun();
          if (com.tencent.mm.kernel.h.baz()) {}
          for (localObject = new com.tencent.mm.plugin.normsg.b.a(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.a(true, (byte[])localObject))
          {
            if (!com.tencent.mm.kernel.h.aZW().a((p)localObject, Util.getIntRandom(600000, 0)))
            {
              Log.e("TrustRequestManager", "[debug] doScene faild");
              localj.guo();
            }
            AppMethodBeat.o(261972);
            return;
          }
        }
      }, "SIRWorker");
    }
    AppMethodBeat.o(89162);
  }
  
  private void asyncReportFinderSecurityInfoThroughCgi(final int paramInt)
  {
    AppMethodBeat.i(261968);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261970);
        Log.i("MicroMsg.PSIR", "[+] report finder task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.aiL(paramInt);
          AppMethodBeat.o(261970);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[finder] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(261970);
        }
      }
    }, "SIRWorker");
    AppMethodBeat.o(261968);
  }
  
  private void asyncReportNewInstallAppThroughCgi(final Intent paramIntent)
  {
    AppMethodBeat.i(261964);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261967);
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.br(paramIntent);
          AppMethodBeat.o(261967);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(261967);
        }
      }
    }, "SIRWorker");
    AppMethodBeat.o(261964);
  }
  
  private void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89160);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261962);
        Log.i("MicroMsg.PSIR", "[+] report yap task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.gUC();
          AppMethodBeat.o(261962);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[yap] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(261962);
        }
      }
    }, "SIRWorker");
    AppMethodBeat.o(89160);
  }
  
  private void asyncReportSecurityInfoRoutine()
  {
    AppMethodBeat.i(261973);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(261973);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.Pmb.ba(9, 86400000L)) {
      asyncReportSecurityInfoThroughCgi(0);
    }
    AppMethodBeat.o(261973);
  }
  
  private void asyncReportSecurityInfoThroughCgi(final int paramInt)
  {
    AppMethodBeat.i(261969);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261966);
        Log.i("MicroMsg.PSIR", "[+] report task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.kZ(paramInt, 1008);
          AppMethodBeat.o(261966);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(261966);
        }
      }
    }, "SIRWorker");
    AppMethodBeat.o(261969);
  }
  
  private void asyncReportSensorSceneInfoThroughCgi(final String paramString, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261960);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261958);
        Log.i("MicroMsg.PSIR", "[+] report sensor scene info task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.C(paramString, paramArrayOfByte);
          AppMethodBeat.o(261958);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[sensor] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(261958);
        }
      }
    }, "SIRWorker");
    AppMethodBeat.o(261960);
  }
  
  private void asyncReportTuringOwnerThroughCgi(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261963);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(261965);
        Log.i("MicroMsg.PSIR", "[+] report turing owner task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Pmb.cs(paramArrayOfByte);
          AppMethodBeat.o(261965);
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[TuringOwner] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(261965);
        }
      }
    }, "SIRWorker");
    AppMethodBeat.o(261963);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(89158);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.PlT);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.PlM);
    AppMethodBeat.o(89158);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(89157);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
    AppMethodBeat.o(89157);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(89159);
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    new IListener(com.tencent.mm.app.f.hfK) {}.alive();
    ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
    {
      public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(261959);
        Log.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean) {
          PluginSecInfoReport.access$100(PluginSecInfoReport.this);
        }
        for (;;)
        {
          paramAnonymoush = com.tencent.mm.plugin.normsg.a.d.MtP.aQp("ce_login_id");
          if ((!TextUtils.isEmpty(paramAnonymoush)) && (!paramAnonymousBoolean)) {
            com.tencent.mm.plugin.normsg.a.d.MtP.gq(paramAnonymoush, 2);
          }
          AppMethodBeat.o(261959);
          return;
          PluginSecInfoReport.access$700(PluginSecInfoReport.this, 540999680);
        }
      }
      
      public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
      {
        AppMethodBeat.i(261961);
        Log.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
        PluginSecInfoReport.access$700(PluginSecInfoReport.this, 540999681);
        paramAnonymousb = com.tencent.mm.plugin.normsg.a.d.MtP.aQp("ce_reg");
        if (!TextUtils.isEmpty(paramAnonymousb)) {
          com.tencent.mm.plugin.normsg.a.d.MtP.gq(paramAnonymousb, 1);
        }
        AppMethodBeat.o(261961);
      }
    });
    this.appForegroundListener.alive();
    AppMethodBeat.o(89159);
  }
  
  public void installed()
  {
    AppMethodBeat.i(89156);
    alias(b.class);
    AppMethodBeat.o(89156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport
 * JD-Core Version:    0.7.0.1
 */