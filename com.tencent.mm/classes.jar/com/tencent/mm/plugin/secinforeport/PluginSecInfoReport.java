package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.k;

public class PluginSecInfoReport
  extends f
  implements b
{
  private static aq yRF = null;
  private o.a appForegroundListener;
  
  public PluginSecInfoReport()
  {
    AppMethodBeat.i(89155);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89144);
        ak.coh();
        AppMethodBeat.o(89144);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89143);
        if (ak.coh()) {
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
    if (yRF == null)
    {
      ae.e("MicroMsg.PSIR", "[debug] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89162);
      return;
    }
    if ((com.tencent.mm.plugin.secinforeport.a.d.yRQ.az(3, 86400000L)) || (!com.tencent.mm.plugin.normsg.a.b.wJt.dyg()))
    {
      ae.i("MicroMsg.PSIR", "[+] req task posted.");
      if ((k.IwK) && (k.IwJ) && (ak.getContext().getSharedPreferences(ak.fow(), 0).getBoolean("gprs_alert", true)))
      {
        ae.i("MicroMsg.PSIR", "CTA alert is not checked Return here.");
        AppMethodBeat.o(89162);
        return;
      }
      yRF.post(new PluginSecInfoReport.4(this));
    }
    AppMethodBeat.o(89162);
  }
  
  private void asyncReportFinderSecurityInfoThroughCgi(final int paramInt)
  {
    AppMethodBeat.i(210882);
    if (yRF == null)
    {
      ae.e("MicroMsg.PSIR", "[debug] workerposter[finder] is null, give up doing rest ops.");
      AppMethodBeat.o(210882);
      return;
    }
    yRF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89154);
        ae.i("MicroMsg.PSIR", "[+] report finder task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.yRQ.PE(paramInt);
          AppMethodBeat.o(89154);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[finder] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(89154);
        }
      }
    });
    AppMethodBeat.o(210882);
  }
  
  private void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89160);
    if (yRF == null)
    {
      ae.e("MicroMsg.PSIR", "[debug] workerposter[yap] is null, give up doing rest ops.");
      AppMethodBeat.o(89160);
      return;
    }
    yRF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89153);
        ae.i("MicroMsg.PSIR", "[+] report yap task start running.");
        try
        {
          com.tencent.mm.plugin.secinforeport.a.d.yRQ.dQs();
          AppMethodBeat.o(89153);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.PSIR", localThrowable, "[yap] unexpected exception was thrown.", new Object[0]);
          AppMethodBeat.o(89153);
        }
      }
    });
    AppMethodBeat.o(89160);
  }
  
  private void reportSecurityInfoAsync(int paramInt)
  {
    AppMethodBeat.i(89161);
    if (yRF == null)
    {
      ae.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(89161);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.yRQ.ay(1, 86400000L))
    {
      ae.i("MicroMsg.PSIR", "[+] report task posted.");
      yRF.post(new PluginSecInfoReport.2(this, paramInt));
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.yRQ.ay(2, 86400000L)) {
      yRF.post(new PluginSecInfoReport.3(this));
    }
    AppMethodBeat.o(89161);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89158);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.yRJ);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.yRD);
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
    if (yRF == null) {}
    try
    {
      yRF = new aq("SIRWorker");
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
      com.tencent.mm.sdk.b.a.IvT.b(new com.tencent.mm.sdk.b.c() {});
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          int i = 0;
          AppMethodBeat.i(210880);
          ae.i("MicroMsg.PSIR", "[+] type 1 report triggered, autoauth: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean) {}
          for (;;)
          {
            PluginSecInfoReport.access$100(PluginSecInfoReport.this, i);
            AppMethodBeat.o(210880);
            return;
            i = 540999680;
          }
        }
        
        public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(210881);
          ae.i("MicroMsg.PSIR", "[+] type 2 report triggered.");
          PluginSecInfoReport.access$100(PluginSecInfoReport.this, 540999681);
          AppMethodBeat.o(210881);
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
        ae.printErrStackTrace("MicroMsg.PSIR", paramg, "[tomys] unexpected exception.", new Object[0]);
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