package com.tencent.mm.plugin.n;

import com.tencent.mm.as.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.storage.bh;

public final class b
  extends p
{
  private static b lnM;
  
  private b()
  {
    super(o.class);
  }
  
  public static bh FD()
  {
    g.DN().CX();
    return ((com.tencent.mm.plugin.r.a.a)g.r(com.tencent.mm.plugin.r.a.a.class)).FD();
  }
  
  public static b bbs()
  {
    try
    {
      if (lnM == null) {
        lnM = new b();
      }
      b localb = lnM;
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.n.b
 * JD-Core Version:    0.7.0.1
 */