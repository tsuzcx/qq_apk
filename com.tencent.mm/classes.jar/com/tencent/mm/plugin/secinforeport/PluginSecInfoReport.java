package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;

public class PluginSecInfoReport
  extends f
  implements b
{
  private static HandlerThread qEc = null;
  private static ak qEd = null;
  
  private void reportSecurityInfoAsync(final int paramInt)
  {
    AppMethodBeat.i(57487);
    if (qEd == null)
    {
      ab.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
      AppMethodBeat.o(57487);
      return;
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.qEo.ac(1, 86400000L)) {
      qEd.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(57481);
          for (;;)
          {
            int j;
            try
            {
              i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("DisableRiskScanSdkProb", 0);
              j = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("DisableInstalledPkgInfoReportProb", 0);
              com.tencent.mm.kernel.g.RJ();
              k = i.bQ(com.tencent.mm.kernel.a.getUin(), 101);
              if ((i > 0) && (k >= 0) && (k <= i))
              {
                i = 1;
                break label184;
                com.tencent.mm.plugin.secinforeport.a.d.qEo.fq(paramInt, i);
                AppMethodBeat.o(57481);
              }
              else
              {
                i = 0;
              }
            }
            catch (Throwable localThrowable2)
            {
              label98:
              ab.printErrStackTrace("MicroMsg.PSIR", localThrowable2, "unexpected exception was thrown.", new Object[0]);
              AppMethodBeat.o(57481);
              return;
            }
            int k = 0;
            break label199;
            try
            {
              label103:
              boolean bool = com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null));
              if (bool) {
                i = 0;
              }
            }
            catch (Throwable localThrowable1)
            {
              ab.printErrStackTrace("MicroMsg.PSIR", localThrowable1, "**** point 0, explained by source code.", new Object[0]);
              i = 0;
            }
            label184:
            label199:
            do
            {
              i = j;
              break;
              i = 1;
              continue;
              if ((j <= 0) || (k < 0) || (k > j)) {
                break label98;
              }
              k = 1;
              j = 12;
              if (i == 0) {
                j = 13;
              }
              if (k == 0) {
                break label103;
              }
              i = 0;
            } while (i == 0);
            int i = j | 0x2;
          }
        }
      });
    }
    if (com.tencent.mm.plugin.secinforeport.a.d.qEo.ac(2, 86400000L)) {
      qEd.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(57482);
          com.tencent.mm.plugin.secinforeport.a.d.qEo.CU(-2147483646);
          AppMethodBeat.o(57482);
        }
      });
    }
    AppMethodBeat.o(57487);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(57485);
    com.tencent.mm.plugin.secinforeport.a.d.a(c.qEg);
    com.tencent.mm.plugin.secinforeport.a.a.a(a.qEa);
    AppMethodBeat.o(57485);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(57484);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    dependsOn(com.tencent.mm.plugin.normsg.a.class);
    AppMethodBeat.o(57484);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(57486);
    if (qEc == null) {}
    try
    {
      paramg = com.tencent.mm.sdk.g.d.aqu("SIRWorker");
      qEc = paramg;
      paramg.start();
      qEd = new ak(qEc.getLooper());
      com.tencent.mm.sdk.b.a.ymk.b(new PluginSecInfoReport.1(this));
      com.tencent.mm.sdk.b.a.ymk.b(new PluginSecInfoReport.2(this));
      ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
      {
        public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(57479);
          if (paramAnonymousBoolean) {}
          for (int i = 0;; i = 540999680)
          {
            PluginSecInfoReport.access$000(PluginSecInfoReport.this, i);
            AppMethodBeat.o(57479);
            return;
          }
        }
        
        public final void a(v.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2)
        {
          AppMethodBeat.i(57480);
          PluginSecInfoReport.access$000(PluginSecInfoReport.this, 540999681);
          AppMethodBeat.o(57480);
        }
      });
      AppMethodBeat.o(57486);
      return;
    }
    catch (Throwable paramg)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.PSIR", paramg, "[tomys] unexpected exception.", new Object[0]);
      }
    }
  }
  
  public void installed()
  {
    AppMethodBeat.i(57483);
    alias(b.class);
    AppMethodBeat.o(57483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.PluginSecInfoReport
 * JD-Core Version:    0.7.0.1
 */