package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWelab
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.welab.a.a
{
  private b JFN;
  private boolean JFO;
  
  public PluginWelab()
  {
    AppMethodBeat.i(146191);
    this.JFN = new b();
    AppMethodBeat.o(146191);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(146199);
    Log.v("PluginWelab", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(198778);
        String str = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo");
        AppMethodBeat.o(198778);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(146199);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146194);
    if (!paramg.aBb())
    {
      AppMethodBeat.o(146194);
      return;
    }
    Log.v("PluginWelab", "configure");
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.b.a.class, new e(new com.tencent.mm.plugin.welab.b.b()));
    AppMethodBeat.o(146194);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(146193);
    dependsOn(s.class);
    AppMethodBeat.o(146193);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146195);
    Log.v("PluginWelab", "execute");
    AppMethodBeat.o(146195);
  }
  
  public void installed()
  {
    AppMethodBeat.i(146192);
    alias(com.tencent.mm.plugin.welab.a.a.class);
    AppMethodBeat.o(146192);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146197);
    Log.v("PluginWelab", "onAccountInitialized");
    MMApplicationContext.getContext();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
    this.JFO = paramc.hrc;
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("newabtestlabs", this.JFN, true);
    AppMethodBeat.o(146197);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146198);
    Log.v("PluginWelab", "onAccountRelease");
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("newabtestlabs", this.JFN, true);
    AppMethodBeat.o(146198);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(146196);
    Log.v("PluginWelab", "onDataBaseOpened");
    a.gjg().JFR = new com.tencent.mm.plugin.welab.d.a(paramh1);
    AppMethodBeat.o(146196);
  }
  
  public String toString()
  {
    return "plugin-welab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.PluginWelab
 * JD-Core Version:    0.7.0.1
 */