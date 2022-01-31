package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.mm.a.h;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class PluginSecInfoReport
  extends f
  implements b
{
  private static HandlerThread nQf = null;
  private static ah nQg = null;
  
  private void reportSecurityInfoAsync(final int paramInt)
  {
    if (nQg == null)
    {
      y.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      return;
    }
    nQg.post(new Runnable()
    {
      public final void run()
      {
        int k = 1;
        for (;;)
        {
          int j;
          int i;
          int m;
          try
          {
            if (com.tencent.mm.plugin.secinforeport.a.d.nQr.M(1, 86400000L))
            {
              j = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("DisableRiskScanSdkProb", 0);
              i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("DisableInstalledPkgInfoReportProb", 0);
              com.tencent.mm.kernel.g.DN();
              m = h.aT(com.tencent.mm.kernel.a.CK(), 101);
              if ((j > 0) && (m >= 0) && (m <= j))
              {
                j = 1;
                break label127;
                com.tencent.mm.plugin.secinforeport.a.d.nQr.dI(paramInt, j);
              }
            }
            else
            {
              return;
            }
            j = 0;
          }
          catch (Throwable localThrowable)
          {
            y.printErrStackTrace("MicroMsg.PSIR", localThrowable, "unexpected exception was thrown.", new Object[0]);
            return;
          }
          k = 0;
          label127:
          if ((i > 0) && (m >= 0) && (m <= i))
          {
            i = 12;
            if (j == 0) {
              i = 13;
            }
            j = i;
            if (k == 0) {
              j = i | 0x2;
            }
          }
        }
      }
    });
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.plugin.secinforeport.a.d.a(c.nQj);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.nQd);
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (nQf == null) {}
    try
    {
      paramg = com.tencent.mm.sdk.f.e.aap("SIRWorker");
      nQf = paramg;
      paramg.start();
      nQg = new ah(nQf.getLooper());
      com.tencent.mm.sdk.b.a.udP.b(new PluginSecInfoReport.1(this));
      com.tencent.mm.sdk.b.a.udP.b(new PluginSecInfoReport.2(this));
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new PluginSecInfoReport.3(this));
      return;
    }
    catch (Throwable paramg)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.PSIR", paramg, "[tomys] unexpected exception.", new Object[0]);
      }
    }
  }
  
  public void installed()
  {
    alias(b.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport
 * JD-Core Version:    0.7.0.1
 */