package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

final class PluginSecInfoReport$2
  implements Runnable
{
  PluginSecInfoReport$2(PluginSecInfoReport paramPluginSecInfoReport, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(89145);
    ad.i("MicroMsg.PSIR", "[+] report task start running.");
    for (;;)
    {
      int j;
      try
      {
        i = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("DisableRiskScanSdkProb", 0);
        j = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("DisableInstalledPkgInfoReportProb", 0);
        g.afz();
        k = i.cf(com.tencent.mm.kernel.a.getUin(), 101);
        if ((i > 0) && (k >= 0) && (k <= i))
        {
          i = 1;
          break label191;
          d.wcE.gU(this.wcv, i);
          AppMethodBeat.o(89145);
        }
        else
        {
          i = 0;
        }
      }
      catch (Throwable localThrowable2)
      {
        label105:
        ad.printErrStackTrace("MicroMsg.PSIR", localThrowable2, "unexpected exception was thrown.", new Object[0]);
        AppMethodBeat.o(89145);
        return;
      }
      int k = 0;
      break label206;
      try
      {
        label110:
        boolean bool = b.yL((String)g.afB().afk().get(274436, null));
        if (bool) {
          i = 0;
        }
      }
      catch (Throwable localThrowable1)
      {
        ad.printErrStackTrace("MicroMsg.PSIR", localThrowable1, "**** point 0, explained by source code.", new Object[0]);
        i = 0;
      }
      label191:
      label206:
      do
      {
        i = j;
        break;
        i = 1;
        continue;
        if ((j <= 0) || (k < 0) || (k > j)) {
          break label105;
        }
        k = 1;
        j = 16;
        if (i == 0) {
          j = 17;
        }
        if (k == 0) {
          break label110;
        }
        i = 0;
      } while (i == 0);
      int i = j | 0xE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.2
 * JD-Core Version:    0.7.0.1
 */