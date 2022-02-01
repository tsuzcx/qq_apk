package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.i;

public class PluginSecInfoReport
  extends f
  implements b
{
  private static ao xnE = null;
  private n.a appForegroundListener;
  
  public PluginSecInfoReport()
  {
    AppMethodBeat.i(89155);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89144);
        ai.cin();
        AppMethodBeat.o(89144);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89143);
        if (ai.cin()) {
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
    if (xnE == null)
    {
      ac.e("MicroMsg.PSIR", "[debug] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89162);
      return;
    }
    if ((com.tencent.mm.plugin.secinforeport.a.d.xnP.as(3, 86400000L)) || (!com.tencent.mm.plugin.normsg.a.b.vor.dkE()))
    {
      ac.i("MicroMsg.PSIR", "[+] req task posted.");
      if ((i.GqL) && (i.GqK) && (ai.getContext().getSharedPreferences(ai.eUX(), 0).getBoolean("gprs_alert", true)))
      {
        ac.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
        AppMethodBeat.o(89162);
        return;
      }
      xnE.post(new PluginSecInfoReport.4(this));
    }
    AppMethodBeat.o(89162);
  }
  
  private void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(207469);
    if (xnE == null)
    {
      ac.e("MicroMsg.PSIR", "[debug] workerposter[finder] is null, give up doing rest ops.");
      AppMethodBeat.o(207469);
      return;
    }
    xnE.post(new PluginSecInfoReport.12(this, paramInt));
    AppMethodBeat.o(207469);
  }
  
  private void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89160);
    if (xnE == null)
    {
      ac.e("MicroMsg.PSIR", "[debug] workerposter[yap] is null, give up doing rest ops.");
      AppMethodBeat.o(89160);
      return;
    }
    xnE.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89153);
        ac.i("MicroMsg.PSIR", "[+] report yap task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.xnP.dBC();
          AppMethodBeat.o(89153);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[yap] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(89153);
        }
      }
    });
    AppMethodBeat.o(89160);
  }
  
  private void reportSecurityInfoAsync(int paramInt)
  {
    AppMethodBeat.i(89161);
    if (xnE == null)
    {
      ac.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89161);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.xnP.ar(1, 86400000L))
    {
      ac.i("MicroMsg.PSIR", "[+] report task posted.");
      xnE.post(new PluginSecInfoReport.2(this, paramInt));
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.xnP.ar(2, 86400000L)) {
      xnE.post(new PluginSecInfoReport.3(this));
    }
    AppMethodBeat.o(89161);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89158);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.xnI);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.xnC);
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
    if (xnE == null) {}
    try
    {
      xnE = new ao("SIRWorker");
      com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.GpY.b(new com.tencent.mm.sdk.b.c() {});
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          int i = 0;
          AppMethodBeat.i(207467);
          ac.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {}
          for (;;)
          {
            PluginSecInfoReport.access$100(PluginSecInfoReport.this, i);
            AppMethodBeat.o(207467);
            return;
            i = 540999680;
          }
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(207468);
          ac.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
          PluginSecInfoReport.access$100(PluginSecInfoReport.this, 540999681);
          AppMethodBeat.o(207468);
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
        ac.printErrStackTrace("MicroMsg.PSIR", paramg, "[tomys] unexpected exception.", new Object[0]);
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