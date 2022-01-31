package com.tencent.mm.plugin.r;

import com.tencent.mm.cf.h;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bh;
import java.util.HashMap;

public final class a
  implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.r.a.a
{
  private bh mbT;
  
  public final bh FD()
  {
    g.DQ();
    g.DN().CX();
    return this.mbT;
  }
  
  public final HashMap<Integer, h.d> collectDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("MediaCheckDumplicationStorage".hashCode()), new a.1(this));
    return localHashMap;
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    this.mbT = new bh(paramh1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.r.a
 * JD-Core Version:    0.7.0.1
 */