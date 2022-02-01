package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.normsg.d.a.a;
import com.tencent.mm.plugin.normsg.d.a.c;
import com.tencent.mm.plugin.normsg.d.b.f;
import com.tencent.mm.plugin.normsg.d.k;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import java.util.Queue;

public class PluginNormsg
  extends f
  implements com.tencent.mm.kernel.api.c, q, a
{
  private static final String AEB;
  private static final String AEC;
  private static final String AED;
  
  static
  {
    AppMethodBeat.i(149007);
    AEB = b.AEu.aIJ("\034:/-9+\n.\"0:41\r\"!");
    AEC = b.AEu.aIJ("\005#64 2\004(,");
    AED = b.AEu.aIJ("");
    AppMethodBeat.o(149007);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(148987);
    com.tencent.mm.plugin.normsg.a.d.a(b.AEu);
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "wc-msaid-init";
      }
      
      public final void run()
      {
        AppMethodBeat.i(148982);
        com.tencent.e.e.b.a.a.b.kW(MMApplicationContext.getContext());
        b localb = b.AEu;
        CrashReportFactory.setX86Env(b.isX86Env());
        localb = b.AEu;
        CrashReportFactory.setDualByTools(b.isDualByTools());
        localb = b.AEu;
        CrashReportFactory.setHookedByXposed(b.isHookedByXposed());
        AppMethodBeat.o(148982);
      }
    });
    AppMethodBeat.o(148987);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(148986);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    if (MMApplicationContext.isMainProcess())
    {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
      dependsOn(s.class);
    }
    AppMethodBeat.o(148986);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(148985);
    alias(a.class);
    AppMethodBeat.o(148985);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(148988);
    paramc = com.tencent.mm.plugin.normsg.d.a.exW();
    com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.g.aAe().azG();
    if (!a.c.isEnabled()) {
      Log.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }
    for (;;)
    {
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a(AEB, this);
      k.start();
      AppMethodBeat.o(148988);
      return;
      int j = a.c.eyc();
      int i = j;
      if (j <= 0) {
        i = 26;
      }
      if (Build.VERSION.SDK_INT > i) {
        Log.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
      } else if (com.tencent.mm.plugin.normsg.d.a.AFa.contains(com.tencent.mm.plugin.normsg.d.a.gj(localg.mProcessName))) {
        try
        {
          com.tencent.mm.plugin.normsg.d.b localb = com.tencent.mm.plugin.normsg.d.b.eye();
          localb.initialize(localg.ca);
          localb.ensureInitialized();
          localb.AFG.add(paramc);
          Log.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
        }
        catch (b.f localf)
        {
          Log.printErrStackTrace("MircoMsg.AEDHLP", localf, "[tomys] aed install failed.", new Object[0]);
          paramc.n(localf);
        }
      } else {
        Log.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148989);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b(AEB, this);
    k.stop();
    AppMethodBeat.o(148989);
  }
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(148990);
    AppMethodBeat.o(148990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg
 * JD-Core Version:    0.7.0.1
 */