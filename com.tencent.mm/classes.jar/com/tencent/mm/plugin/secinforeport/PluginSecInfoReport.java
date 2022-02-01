package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.md;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.f.a.st;
import com.tencent.mm.f.a.su;
import com.tencent.mm.f.a.sz;
import com.tencent.mm.f.a.ta;
import com.tencent.mm.f.a.tc;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.normsg.d.j;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class PluginSecInfoReport
  extends f
  implements b
{
  private static MMHandler JbY = null;
  private o.a appForegroundListener;
  
  public PluginSecInfoReport()
  {
    AppMethodBeat.i(89155);
    this.appForegroundListener = new o.a()
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
        if (MMApplicationContext.isMainProcess()) {
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
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89162);
      return;
    }
    if ((com.tencent.mm.plugin.secinforeport.a.d.Jcm.aS(3, 86400000L)) || (!com.tencent.mm.plugin.normsg.a.d.GxJ.fjp()))
    {
      Log.i("MicroMsg.PSIR", "[+] req task posted.");
      if ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert) && (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)))
      {
        Log.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
        AppMethodBeat.o(89162);
        return;
      }
      JbY.post(new Runnable()
      {
        public final void run()
        {
          int i = -1;
          AppMethodBeat.i(249826);
          j localj = new j();
          if (!com.tencent.mm.plugin.normsg.a.d.GxJ.fjp())
          {
            localObject = com.tencent.mm.plugin.normsg.a.d.GxJ.aaz(1);
            if (localObject == null) {}
            for (;;)
            {
              Log.d("TrustRequestManager", "[debug] doScene type:[init] dlen:[%d]", new Object[] { Integer.valueOf(i) });
              if ((localObject != null) && (localObject.length != 0)) {
                break;
              }
              AppMethodBeat.o(249826);
              return;
              i = localObject.length;
            }
            localj.fjV();
            if (h.aHB()) {}
            for (localObject = new com.tencent.mm.plugin.normsg.b.b(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.b(true, (byte[])localObject))
            {
              if (!h.aGY().a((q)localObject, 0))
              {
                Log.e("TrustRequestManager", "[debug] doScene faild");
                localj.fjW();
              }
              AppMethodBeat.o(249826);
              return;
            }
          }
          Object localObject = com.tencent.mm.plugin.normsg.a.d.GxJ.aaz(2);
          if (localObject == null) {}
          for (;;)
          {
            Log.d("TrustRequestManager", "[debug] doScene type:[refesh] dlen:[%d]", new Object[] { Integer.valueOf(i) });
            if ((localObject != null) && (localObject.length != 0)) {
              break;
            }
            AppMethodBeat.o(249826);
            return;
            i = localObject.length;
          }
          localj.fjV();
          if (h.aHB()) {}
          for (localObject = new com.tencent.mm.plugin.normsg.b.a(false, (byte[])localObject);; localObject = new com.tencent.mm.plugin.normsg.b.a(true, (byte[])localObject))
          {
            if (!h.aGY().a((q)localObject, Util.getIntRandom(600000, 0)))
            {
              Log.e("TrustRequestManager", "[debug] doScene faild");
              localj.fjW();
            }
            AppMethodBeat.o(249826);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(89162);
  }
  
  private void asyncReportFinderSecurityInfoThroughCgi(final int paramInt)
  {
    AppMethodBeat.i(249882);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[finder] is null, give up doing rest ops.");
      AppMethodBeat.o(249882);
      return;
    }
    JbY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249850);
        Log.i("MicroMsg.PSIR", "[+] report finder task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.aeg(paramInt);
          AppMethodBeat.o(249850);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[finder] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(249850);
        }
      }
    });
    AppMethodBeat.o(249882);
  }
  
  private void asyncReportNewInstallAppThroughCgi(final Intent paramIntent)
  {
    AppMethodBeat.i(249881);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(249881);
      return;
    }
    JbY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249816);
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.aT(paramIntent);
          AppMethodBeat.o(249816);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(249816);
        }
      }
    });
    AppMethodBeat.o(249881);
  }
  
  private void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89160);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[yap] is null, give up doing rest ops.");
      AppMethodBeat.o(89160);
      return;
    }
    JbY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249837);
        Log.i("MicroMsg.PSIR", "[+] report yap task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.fFu();
          AppMethodBeat.o(249837);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[yap] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(249837);
        }
      }
    });
    AppMethodBeat.o(89160);
  }
  
  private void asyncReportSecurityInfoRoutine()
  {
    AppMethodBeat.i(249887);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(249887);
      return;
    }
    if (!h.aHB())
    {
      AppMethodBeat.o(249887);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.Jcm.aT(9, 86400000L)) {
      asyncReportSecurityInfoThroughCgi(0);
    }
    AppMethodBeat.o(249887);
  }
  
  private void asyncReportSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(249885);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(249885);
      return;
    }
    JbY.post(new PluginSecInfoReport.8(this, paramInt));
    AppMethodBeat.o(249885);
  }
  
  private void asyncReportSensorSceneInfoThroughCgi(final String paramString, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249877);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[sensor] is null, give up doing rest ops.");
      AppMethodBeat.o(249877);
      return;
    }
    JbY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249825);
        Log.i("MicroMsg.PSIR", "[+] report sensor scene info task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.z(paramString, paramArrayOfByte);
          AppMethodBeat.o(249825);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[sensor] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(249825);
        }
      }
    });
    AppMethodBeat.o(249877);
  }
  
  private void asyncReportTuringOwnerThroughCgi(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(249879);
    if (JbY == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[TuringOwner] is null, give up doing rest ops.");
      AppMethodBeat.o(249879);
      return;
    }
    JbY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249831);
        Log.i("MicroMsg.PSIR", "[+] report turing owner task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.Jcm.cq(paramArrayOfByte);
          AppMethodBeat.o(249831);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[TuringOwner] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(249831);
        }
      }
    });
    AppMethodBeat.o(249879);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(89158);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.Jce);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.JbW);
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
    if (JbY == null) {}
    try
    {
      JbY = new MMHandler("SIRWorker");
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      ((com.tencent.mm.plugin.auth.a.c)h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(249855);
          Log.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {
            PluginSecInfoReport.access$100(PluginSecInfoReport.this);
          }
          for (;;)
          {
            paramAnonymoush = com.tencent.mm.plugin.normsg.a.d.GxJ.aTp("ce_login_id");
            if ((!TextUtils.isEmpty(paramAnonymoush)) && (!paramAnonymousBoolean)) {
              com.tencent.mm.plugin.normsg.a.d.GxJ.fx(paramAnonymoush, 2);
            }
            AppMethodBeat.o(249855);
            return;
            PluginSecInfoReport.access$700(PluginSecInfoReport.this, 540999680);
          }
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(249857);
          Log.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
          PluginSecInfoReport.access$700(PluginSecInfoReport.this, 540999681);
          paramAnonymousb = com.tencent.mm.plugin.normsg.a.d.GxJ.aTp("ce_reg");
          if (!TextUtils.isEmpty(paramAnonymousb)) {
            com.tencent.mm.plugin.normsg.a.d.GxJ.fx(paramAnonymousb, 1);
          }
          AppMethodBeat.o(249857);
        }
      });
      this.appForegroundListener.alive();
      AppMethodBeat.o(89159);
      return;
    }
    catch (Throwable paramg)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PSIR", paramg, "[tomys] unexpected exception.", new Object[0]);
      }
    }
  }
  
  public void installed()
  {
    AppMethodBeat.i(89156);
    alias(b.class);
    AppMethodBeat.o(89156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport
 * JD-Core Version:    0.7.0.1
 */