package com.tencent.mm.plugin.selectrecord;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSelectRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.selectrecord.c.a Pmg;
  private com.tencent.mm.plugin.selectrecord.d.b Pmh;
  
  static
  {
    AppMethodBeat.i(266672);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SELECTRECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.selectrecord.d.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(266672);
  }
  
  public PluginSelectRecord()
  {
    AppMethodBeat.i(266669);
    this.Pmg = new com.tencent.mm.plugin.selectrecord.c.a();
    this.Pmh = null;
    AppMethodBeat.o(266669);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(266688);
    if (paramg.bbA()) {
      h.b(y.class, new com.tencent.mm.plugin.selectrecord.a.a());
    }
    AppMethodBeat.o(266688);
  }
  
  public com.tencent.mm.plugin.selectrecord.d.b getSelectRecordStorage()
  {
    AppMethodBeat.i(266702);
    h.baC().aZJ();
    if (this.Pmh == null)
    {
      h.baF();
      this.Pmh = new com.tencent.mm.plugin.selectrecord.d.b(h.baE().mCN);
    }
    com.tencent.mm.plugin.selectrecord.d.b localb = this.Pmh;
    AppMethodBeat.o(266702);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(266678);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("revokehistoryinjoinroommsg", this.Pmg);
    AppMethodBeat.o(266678);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(266683);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("revokehistoryinjoinroommsg", this.Pmg);
    AppMethodBeat.o(266683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.PluginSelectRecord
 * JD-Core Version:    0.7.0.1
 */