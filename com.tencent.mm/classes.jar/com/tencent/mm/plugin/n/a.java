package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.n.a.a
{
  private bk twY;
  
  public final bk apT()
  {
    AppMethodBeat.i(151497);
    g.afC();
    g.afz().aeD();
    bk localbk = this.twY;
    AppMethodBeat.o(151497);
    return localbk;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(151499);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bk.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151499);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(151498);
    this.twY = new bk(paramh1);
    AppMethodBeat.o(151498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.a
 * JD-Core Version:    0.7.0.1
 */