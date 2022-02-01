package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginWelab
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.welab.a.a
{
  private b ExE;
  private boolean ExF;
  
  public PluginWelab()
  {
    AppMethodBeat.i(146191);
    this.ExE = new b();
    AppMethodBeat.o(146191);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(146199);
    ad.v("PluginWelab", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(146190);
        String str = j.getCreateSQLs(com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo");
        AppMethodBeat.o(146190);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(146199);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146194);
    if (!paramg.akw())
    {
      AppMethodBeat.o(146194);
      return;
    }
    ad.v("PluginWelab", "configure");
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.b.a.class, new e(new com.tencent.mm.plugin.welab.b.b()));
    ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(146189);
        a.eWo();
        boolean bool = PluginWelab.this.ExF;
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          a.aK(bool, paramAnonymousBoolean);
          AppMethodBeat.o(146189);
          return;
        }
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    });
    AppMethodBeat.o(146194);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(146193);
    dependsOn(r.class);
    AppMethodBeat.o(146193);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(146195);
    ad.v("PluginWelab", "execute");
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
    ad.v("PluginWelab", "onAccountInitialized");
    aj.getContext();
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
    this.ExF = paramc.gBH;
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("newabtestlabs", this.ExE, true);
    AppMethodBeat.o(146197);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(146198);
    ad.v("PluginWelab", "onAccountRelease");
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("newabtestlabs", this.ExE, true);
    AppMethodBeat.o(146198);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(146196);
    ad.v("PluginWelab", "onDataBaseOpened");
    a.eWo().ExI = new com.tencent.mm.plugin.welab.d.a(paramh1);
    AppMethodBeat.o(146196);
  }
  
  public String toString()
  {
    return "plugin-welab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.PluginWelab
 * JD-Core Version:    0.7.0.1
 */