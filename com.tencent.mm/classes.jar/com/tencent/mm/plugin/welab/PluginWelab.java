package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWelab
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.welab.a.a
{
  private c QED;
  private boolean QEE;
  
  public PluginWelab()
  {
    AppMethodBeat.i(146191);
    this.QED = new c();
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
        AppMethodBeat.i(248442);
        String str = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo");
        AppMethodBeat.o(248442);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(146199);
    return localHashMap;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(146194);
    if (!paramg.aIE())
    {
      AppMethodBeat.o(146194);
      return;
    }
    Log.v("PluginWelab", "configure");
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.welab.a.a.d.class, new e(new d()));
    com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.welab.b.a.class, new e(new com.tencent.mm.plugin.welab.b.b()));
    AppMethodBeat.o(146194);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(146193);
    dependsOn(v.class);
    AppMethodBeat.o(146193);
  }
  
  public void execute(g paramg)
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
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(146197);
    Log.v("PluginWelab", "onAccountInitialized");
    MMApplicationContext.getContext();
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
    this.QEE = paramc.kcX;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("newabtestlabs", this.QED, true);
    AppMethodBeat.o(146197);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146198);
    Log.v("PluginWelab", "onAccountRelease");
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("newabtestlabs", this.QED, true);
    AppMethodBeat.o(146198);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(146196);
    Log.v("PluginWelab", "onDataBaseOpened");
    b.hcS().QFd = new com.tencent.mm.plugin.welab.d.a(paramh1);
    AppMethodBeat.o(146196);
  }
  
  public String toString()
  {
    return "plugin-welab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.PluginWelab
 * JD-Core Version:    0.7.0.1
 */