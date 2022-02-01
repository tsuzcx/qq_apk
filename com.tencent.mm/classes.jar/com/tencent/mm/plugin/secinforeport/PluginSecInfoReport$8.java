package com.tencent.mm.plugin.secinforeport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

final class PluginSecInfoReport$8
  implements Runnable
{
  PluginSecInfoReport$8(PluginSecInfoReport paramPluginSecInfoReport, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(249906);
    Log.i("MicroMsg.PSIR", "[+] report task start running.");
    for (;;)
    {
      int j;
      try
      {
        i = ((a)h.ae(a.class)).axc().getInt("DisableRiskScanSdkProb", 0);
        j = ((a)h.ae(a.class)).axc().getInt("DisableInstalledPkgInfoReportProb", 0);
        h.aHE();
        k = i.cA(com.tencent.mm.kernel.b.getUin(), 101);
        if ((i > 0) && (k >= 0) && (k <= i))
        {
          i = 1;
          break label197;
          d.Jcm.jr(this.Jcd, i | 0x20 | 0x40);
          AppMethodBeat.o(249906);
        }
        else
        {
          i = 0;
        }
      }
      catch (Throwable localThrowable2)
      {
        label111:
        Log.printErrStackTrace("MicroMsg.PSIR", localThrowable2, "unexpected exception was thrown.", new Object[0]);
        AppMethodBeat.o(249906);
        return;
      }
      int k = 0;
      break label212;
      try
      {
        label116:
        boolean bool = com.tencent.mm.az.b.WF((String)h.aHG().aHp().b(274436, null));
        if (bool) {
          i = 0;
        }
      }
      catch (Throwable localThrowable1)
      {
        Log.printErrStackTrace("MicroMsg.PSIR", localThrowable1, "**** point 0, explained by source code.", new Object[0]);
        i = 0;
      }
      label197:
      label212:
      do
      {
        i = j;
        break;
        i = 1;
        continue;
        if ((j <= 0) || (k < 0) || (k > j)) {
          break label111;
        }
        k = 1;
        j = 16;
        if (i == 0) {
          j = 17;
        }
        if (k == 0) {
          break label116;
        }
        i = 0;
      } while (i == 0);
      int i = j | 0xE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport.8
 * JD-Core Version:    0.7.0.1
 */