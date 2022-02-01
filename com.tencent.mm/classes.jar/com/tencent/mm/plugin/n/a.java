package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.n.a.a
{
  private bu vUu;
  
  public final bu azN()
  {
    AppMethodBeat.i(151497);
    g.ajS();
    g.ajP().aiU();
    bu localbu = this.vUu;
    AppMethodBeat.o(151497);
    return localbu;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(151499);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bu.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151499);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151498);
    this.vUu = new bu(paramh1);
    AppMethodBeat.o(151498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.n.a
 * JD-Core Version:    0.7.0.1
 */