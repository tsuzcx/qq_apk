package com.tencent.mm.plugin.selectrecord;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
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
  private com.tencent.mm.plugin.selectrecord.c.a CWL;
  private b CWM;
  
  static
  {
    AppMethodBeat.i(187906);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("SELECTRECORD_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(187906);
  }
  
  public PluginSelectRecord()
  {
    AppMethodBeat.i(187901);
    this.CWL = new com.tencent.mm.plugin.selectrecord.c.a();
    this.CWM = null;
    AppMethodBeat.o(187901);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(187904);
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(v.class, new com.tencent.mm.plugin.selectrecord.a.a());
    }
    AppMethodBeat.o(187904);
  }
  
  public b getSelectRecordStorage()
  {
    AppMethodBeat.i(187905);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.CWM == null)
    {
      com.tencent.mm.kernel.g.aAi();
      this.CWM = new b(com.tencent.mm.kernel.g.aAh().hqK);
    }
    b localb = this.CWM;
    AppMethodBeat.o(187905);
    return localb;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(187902);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("revokehistoryinjoinroommsg", this.CWL);
    AppMethodBeat.o(187902);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(187903);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("revokehistoryinjoinroommsg", this.CWL);
    AppMethodBeat.o(187903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.PluginSelectRecord
 * JD-Core Version:    0.7.0.1
 */