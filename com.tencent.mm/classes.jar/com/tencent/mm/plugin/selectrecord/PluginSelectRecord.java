package com.tencent.mm.plugin.selectrecord;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.selectrecord.d.b;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSelectRecord
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.selectrecord.c.a yRV;
  private b yRW;
  
  static
  {
    AppMethodBeat.i(193984);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SELECTRECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(193984);
  }
  
  public PluginSelectRecord()
  {
    AppMethodBeat.i(193979);
    this.yRV = new com.tencent.mm.plugin.selectrecord.c.a();
    this.yRW = null;
    AppMethodBeat.o(193979);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(193982);
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(v.class, new com.tencent.mm.plugin.selectrecord.a.a());
    }
    AppMethodBeat.o(193982);
  }
  
  public b getSelectRecordStorage()
  {
    AppMethodBeat.i(193983);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.yRW == null)
    {
      com.tencent.mm.kernel.g.ajS();
      this.yRW = new b(com.tencent.mm.kernel.g.ajR().gDX);
    }
    b localb = this.yRW;
    AppMethodBeat.o(193983);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(193980);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("revokehistoryinjoinroommsg", this.yRV);
    AppMethodBeat.o(193980);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(193981);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("revokehistoryinjoinroommsg", this.yRV);
    AppMethodBeat.o(193981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.PluginSelectRecord
 * JD-Core Version:    0.7.0.1
 */