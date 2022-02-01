package com.tencent.mm.plugin.selectrecord;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.selectrecord.e.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSelectRecord
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b OdE;
  private com.tencent.mm.plugin.selectrecord.c.a yBV;
  
  static
  {
    AppMethodBeat.i(221243);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SELECTRECORD_TABLE".hashCode()), new PluginSelectRecord.1());
    AppMethodBeat.o(221243);
  }
  
  public PluginSelectRecord()
  {
    AppMethodBeat.i(207386);
    this.yBV = new com.tencent.mm.plugin.selectrecord.c.a();
    this.OdE = null;
    AppMethodBeat.o(207386);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(207389);
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(u.class, new com.tencent.mm.plugin.selectrecord.a.a());
    }
    AppMethodBeat.o(207389);
  }
  
  public b getSelectRecordStorage()
  {
    AppMethodBeat.i(221242);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.OdE == null)
    {
      com.tencent.mm.kernel.g.ajD();
      this.OdE = new b(com.tencent.mm.kernel.g.ajC().gBq);
    }
    b localb = this.OdE;
    AppMethodBeat.o(221242);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(207387);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("revokehistoryinjoinroommsg", this.yBV);
    AppMethodBeat.o(207387);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(207388);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("revokehistoryinjoinroommsg", this.yBV);
    AppMethodBeat.o(207388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.PluginSelectRecord
 * JD-Core Version:    0.7.0.1
 */