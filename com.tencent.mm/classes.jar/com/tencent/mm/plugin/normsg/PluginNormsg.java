package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
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
  implements com.tencent.mm.kernel.api.c, t, a
{
  private static final String GxF;
  private static final String GxG;
  private static final String GxH;
  
  static
  {
    AppMethodBeat.i(149007);
    GxF = b.Gxy.aTf("\034:/-9+\n.\"0:41\r\"!");
    GxG = b.Gxy.aTf("\005#64 2\004(,");
    GxH = b.Gxy.aTf("");
    AppMethodBeat.o(149007);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(148987);
    com.tencent.mm.plugin.normsg.a.d.a(b.Gxy);
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "wc-msaid-init";
      }
      
      public final void run()
      {
        AppMethodBeat.i(148982);
        com.tencent.d.e.b.a.a.b.lT(MMApplicationContext.getContext());
        b localb = b.Gxy;
        CrashReportFactory.setX86Env(b.isX86Env());
        localb = b.Gxy;
        CrashReportFactory.setDualByTools(b.isDualByTools());
        localb = b.Gxy;
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
      dependsOn(v.class);
    }
    AppMethodBeat.o(148986);
  }
  
  public void execute(g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(148985);
    alias(a.class);
    AppMethodBeat.o(148985);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(148988);
    paramc = com.tencent.mm.plugin.normsg.d.a.fjB();
    g localg = com.tencent.mm.kernel.h.aHD().aHf();
    if (!a.c.isEnabled()) {
      Log.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }
    for (;;)
    {
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a(GxF, this);
      k.start();
      AppMethodBeat.o(148988);
      return;
      int j = a.c.fjH();
      int i = j;
      if (j <= 0) {
        i = 26;
      }
      if (Build.VERSION.SDK_INT > i) {
        Log.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
      } else if (com.tencent.mm.plugin.normsg.d.a.Gyk.contains(com.tencent.mm.plugin.normsg.d.a.gT(localg.mProcessName))) {
        try
        {
          com.tencent.mm.plugin.normsg.d.b localb = com.tencent.mm.plugin.normsg.d.b.fjJ();
          localb.initialize(localg.Zw);
          localb.ensureInitialized();
          localb.GyQ.add(paramc);
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
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b(GxF, this);
    k.stop();
    AppMethodBeat.o(148989);
  }
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(148990);
    AppMethodBeat.o(148990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg
 * JD-Core Version:    0.7.0.1
 */