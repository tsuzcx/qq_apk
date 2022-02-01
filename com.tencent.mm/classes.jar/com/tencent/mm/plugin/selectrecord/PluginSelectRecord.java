package com.tencent.mm.plugin.selectrecord;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginSelectRecord
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, c, a
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.plugin.selectrecord.c.a Jcr;
  private com.tencent.mm.plugin.selectrecord.d.b Jcs;
  
  static
  {
    AppMethodBeat.i(255185);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SELECTRECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.selectrecord.d.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(255185);
  }
  
  public PluginSelectRecord()
  {
    AppMethodBeat.i(255177);
    this.Jcr = new com.tencent.mm.plugin.selectrecord.c.a();
    this.Jcs = null;
    AppMethodBeat.o(255177);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(255181);
    if (paramg.aIE()) {
      h.b(y.class, new com.tencent.mm.plugin.selectrecord.a.a());
    }
    AppMethodBeat.o(255181);
  }
  
  public com.tencent.mm.plugin.selectrecord.d.b getSelectRecordStorage()
  {
    AppMethodBeat.i(255183);
    h.aHE().aGH();
    if (this.Jcs == null)
    {
      h.aHH();
      this.Jcs = new com.tencent.mm.plugin.selectrecord.d.b(h.aHG().kcF);
    }
    com.tencent.mm.plugin.selectrecord.d.b localb = this.Jcs;
    AppMethodBeat.o(255183);
    return localb;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(255179);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("revokehistoryinjoinroommsg", this.Jcr);
    AppMethodBeat.o(255179);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(255180);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("revokehistoryinjoinroommsg", this.Jcr);
    AppMethodBeat.o(255180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.PluginSelectRecord
 * JD-Core Version:    0.7.0.1
 */