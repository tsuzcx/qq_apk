package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.r.a.a
{
  private cb KOv;
  
  public final cb bzI()
  {
    AppMethodBeat.i(151497);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    cb localcb = this.KOv;
    AppMethodBeat.o(151497);
    return localcb;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(151499);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return cb.SQL_CREATE;
      }
    });
    AppMethodBeat.o(151499);
    return localHashMap;
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(151498);
    this.KOv = new cb(paramh1);
    AppMethodBeat.o(151498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.r.a
 * JD-Core Version:    0.7.0.1
 */