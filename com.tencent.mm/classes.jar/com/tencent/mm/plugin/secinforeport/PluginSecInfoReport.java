package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.j;

public class PluginSecInfoReport
  extends f
  implements b
{
  private static ap yBF = null;
  private n.a appForegroundListener;
  
  public PluginSecInfoReport()
  {
    AppMethodBeat.i(89155);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89144);
        aj.cmR();
        AppMethodBeat.o(89144);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89143);
        if (aj.cmR()) {
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
    if (yBF == null)
    {
      ad.e("MicroMsg.PSIR", "[debug] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89162);
      return;
    }
    if ((com.tencent.mm.plugin.secinforeport.a.d.yBQ.az(3, 86400000L)) || (!com.tencent.mm.plugin.normsg.a.b.wtJ.duQ()))
    {
      ad.i("MicroMsg.PSIR", "[+] req task posted.");
      if ((j.Icz) && (j.Icy) && (aj.getContext().getSharedPreferences(aj.fkC(), 0).getBoolean("gprs_alert", true)))
      {
        ad.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
        AppMethodBeat.o(89162);
        return;
      }
      yBF.post(new PluginSecInfoReport.4(this));
    }
    AppMethodBeat.o(89162);
  }
  
  private void asyncReportFinderSecurityInfoThroughCgi(final int paramInt)
  {
    AppMethodBeat.i(197164);
    if (yBF == null)
    {
      ad.e("MicroMsg.PSIR", "[debug] workerposter[finder] is null, give up doing rest ops.");
      AppMethodBeat.o(197164);
      return;
    }
    yBF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89154);
        ad.i("MicroMsg.PSIR", "[+] report finder task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.yBQ.OX(paramInt);
          AppMethodBeat.o(89154);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[finder] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(89154);
        }
      }
    });
    AppMethodBeat.o(197164);
  }
  
  private void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89160);
    if (yBF == null)
    {
      ad.e("MicroMsg.PSIR", "[debug] workerposter[yap] is null, give up doing rest ops.");
      AppMethodBeat.o(89160);
      return;
    }
    yBF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89153);
        ad.i("MicroMsg.PSIR", "[+] report yap task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.yBQ.dMZ();
          AppMethodBeat.o(89153);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[yap] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(89153);
        }
      }
    });
    AppMethodBeat.o(89160);
  }
  
  private void reportSecurityInfoAsync(int paramInt)
  {
    AppMethodBeat.i(89161);
    if (yBF == null)
    {
      ad.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89161);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.yBQ.ay(1, 86400000L))
    {
      ad.i("MicroMsg.PSIR", "[+] report task posted.");
      yBF.post(new PluginSecInfoReport.2(this, paramInt));
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.yBQ.ay(2, 86400000L)) {
      yBF.post(new PluginSecInfoReport.3(this));
    }
    AppMethodBeat.o(89161);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89158);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.yBJ);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.yBD);
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
    if (yBF == null) {}
    try
    {
      yBF = new ap("SIRWorker");
      com.tencent.mm.sdk.b.a.IbL.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IbL.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IbL.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IbL.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IbL.b(new com.tencent.mm.sdk.b.c() {});
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          int i = 0;
          AppMethodBeat.i(197162);
          ad.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {}
          for (;;)
          {
            PluginSecInfoReport.access$100(PluginSecInfoReport.this, i);
            AppMethodBeat.o(197162);
            return;
            i = 540999680;
          }
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(197163);
          ad.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
          PluginSecInfoReport.access$100(PluginSecInfoReport.this, 540999681);
          AppMethodBeat.o(197163);
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
        ad.printErrStackTrace("MicroMsg.PSIR", paramg, "[tomys] unexpected exception.", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport
 * JD-Core Version:    0.7.0.1
 */