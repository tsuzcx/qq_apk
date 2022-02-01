package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.b.i;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;

public class PluginSecInfoReport
  extends com.tencent.mm.kernel.b.f
  implements b
{
  private static MMHandler CWt = null;
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
    if (CWt == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89162);
      return;
    }
    if ((com.tencent.mm.plugin.secinforeport.a.d.CWG.aG(3, 86400000L)) || (!com.tencent.mm.plugin.normsg.a.d.AEF.exL()))
    {
      Log.i("MicroMsg.PSIR", "[+] req task posted.");
      if ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert) && (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("gprs_alert", true)))
      {
        Log.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
        AppMethodBeat.o(89162);
        return;
      }
      CWt.post(new PluginSecInfoReport.8(this));
    }
    AppMethodBeat.o(89162);
  }
  
  private void asyncReportFinderSecurityInfoThroughCgi(final int paramInt)
  {
    AppMethodBeat.i(214394);
    if (CWt == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[finder] is null, give up doing rest ops.");
      AppMethodBeat.o(214394);
      return;
    }
    CWt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214380);
        Log.i("MicroMsg.PSIR", "[+] report finder task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.CWG.Xi(paramInt);
          AppMethodBeat.o(214380);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[finder] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(214380);
        }
      }
    });
    AppMethodBeat.o(214394);
  }
  
  private void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89160);
    if (CWt == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[yap] is null, give up doing rest ops.");
      AppMethodBeat.o(89160);
      return;
    }
    CWt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89145);
        Log.i("MicroMsg.PSIR", "[+] report yap task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.CWG.eSt();
          AppMethodBeat.o(89145);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[yap] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(89145);
        }
      }
    });
    AppMethodBeat.o(89160);
  }
  
  private void asyncReportSensorSceneInfoThroughCgi(final String paramString, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214392);
    if (CWt == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[sensor] is null, give up doing rest ops.");
      AppMethodBeat.o(214392);
      return;
    }
    CWt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214378);
        Log.i("MicroMsg.PSIR", "[+] report sensor scene info task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.CWG.u(paramString, paramArrayOfByte);
          AppMethodBeat.o(214378);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[sensor] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(214378);
        }
      }
    });
    AppMethodBeat.o(214392);
  }
  
  private void asyncReportTuringOwnerThroughCgi(final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214393);
    if (CWt == null)
    {
      Log.e("MicroMsg.PSIR", "[debug] workerposter[TuringOwner] is null, give up doing rest ops.");
      AppMethodBeat.o(214393);
      return;
    }
    CWt.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214379);
        Log.i("MicroMsg.PSIR", "[+] report turing owner task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.CWG.ca(paramArrayOfByte);
          AppMethodBeat.o(214379);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[TuringOwner] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(214379);
        }
      }
    });
    AppMethodBeat.o(214393);
  }
  
  private void reportSecurityInfoAsync(final int paramInt)
  {
    AppMethodBeat.i(89161);
    if (CWt == null)
    {
      Log.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89161);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAc())
    {
      AppMethodBeat.o(89161);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.CWG.aF(1, 86400000L))
    {
      Log.i("MicroMsg.PSIR", "[+] report task posted.");
      CWt.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214381);
          Log.i("MicroMsg.PSIR", "[+] report task start running.");
          for (;;)
          {
            int j;
            try
            {
              i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("DisableRiskScanSdkProb", 0);
              j = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("DisableInstalledPkgInfoReportProb", 0);
              com.tencent.mm.kernel.g.aAf();
              k = i.ch(com.tencent.mm.kernel.a.getUin(), 101);
              if ((i > 0) && (k >= 0) && (k <= i))
              {
                i = 1;
                break label194;
                com.tencent.mm.plugin.secinforeport.a.d.CWG.ik(paramInt, i | 0x20);
                AppMethodBeat.o(214381);
              }
              else
              {
                i = 0;
              }
            }
            catch (Throwable localThrowable2)
            {
              label108:
              Log.printErrStackTrace("MicroMsg.PSIR", localThrowable2, "unexpected exception was thrown.", new Object[0]);
              AppMethodBeat.o(214381);
              return;
            }
            int k = 0;
            break label209;
            try
            {
              label113:
              boolean bool = com.tencent.mm.aw.b.Pi((String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null));
              if (bool) {
                i = 0;
              }
            }
            catch (Throwable localThrowable1)
            {
              Log.printErrStackTrace("MicroMsg.PSIR", localThrowable1, "**** point 0, explained by source code.", new Object[0]);
              i = 0;
            }
            label194:
            label209:
            do
            {
              i = j;
              break;
              i = 1;
              continue;
              if ((j <= 0) || (k < 0) || (k > j)) {
                break label108;
              }
              k = 1;
              j = 16;
              if (i == 0) {
                j = 17;
              }
              if (k == 0) {
                break label113;
              }
              i = 0;
            } while (i == 0);
            int i = j | 0xE;
          }
        }
      });
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.CWG.aF(2, 86400000L)) {
      CWt.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214382);
          com.tencent.mm.plugin.secinforeport.a.d.CWG.Xj(-2147483646);
          AppMethodBeat.o(214382);
        }
      });
    }
    AppMethodBeat.o(89161);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89158);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.CWz);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.CWr);
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
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89159);
    if (CWt == null) {}
    try
    {
      CWt = new MMHandler("SIRWorker");
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      EventCenter.instance.add(new IListener() {});
      ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.b()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          int i = 0;
          AppMethodBeat.i(214390);
          Log.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {}
          for (;;)
          {
            PluginSecInfoReport.access$100(PluginSecInfoReport.this, i);
            paramAnonymoush = com.tencent.mm.plugin.normsg.a.d.AEF.aIT("ce_login_id");
            if ((!TextUtils.isEmpty(paramAnonymoush)) && (!paramAnonymousBoolean)) {
              com.tencent.mm.plugin.normsg.a.d.AEF.eW(paramAnonymoush, 2);
            }
            AppMethodBeat.o(214390);
            return;
            i = 540999680;
          }
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(214391);
          Log.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
          PluginSecInfoReport.access$100(PluginSecInfoReport.this, 540999681);
          paramAnonymousb = com.tencent.mm.plugin.normsg.a.d.AEF.aIT("ce_reg");
          if (!TextUtils.isEmpty(paramAnonymousb)) {
            com.tencent.mm.plugin.normsg.a.d.AEF.eW(paramAnonymousb, 1);
          }
          AppMethodBeat.o(214391);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport
 * JD-Core Version:    0.7.0.1
 */