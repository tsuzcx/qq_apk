package com.tencent.mm.plugin.welab;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class PluginWelab
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.welab.a.a
{
  private c rEn = new c();
  private boolean rEo;
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    y.v("PluginWelab", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new PluginWelab.2(this));
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (!paramg.Ex()) {
      return;
    }
    y.v("PluginWelab", "configure");
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new e(new d()));
    ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new PluginWelab.1(this));
  }
  
  public void dependency()
  {
    dependsOn(p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.v("PluginWelab", "execute");
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.welab.a.a.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.v("PluginWelab", "onAccountInitialized");
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
    this.rEo = paramc.dKL;
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("newabtestlabs", this.rEn, true);
  }
  
  public void onAccountRelease()
  {
    y.v("PluginWelab", "onAccountRelease");
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("newabtestlabs", this.rEn, true);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2)
  {
    y.v("PluginWelab", "onDataBaseOpened");
    b.chc().rEr = new com.tencent.mm.plugin.welab.c.a(paramh1);
  }
  
  public String toString()
  {
    return "plugin-welab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.PluginWelab
 * JD-Core Version:    0.7.0.1
 */