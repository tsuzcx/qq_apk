package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.s.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class o
  extends i<Integer>
{
  private s.a IDl = null;
  private i.e IDm = null;
  
  public o(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.IDl = parami2.IBe.IBA;
      this.IDm = parami2.a(this.IDl);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      paramc.IEg.acy(paramInt1);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      paramc.IDS.put(paramInt1, paramInt3);
    }
  }
  
  protected final s.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.IBe.IBA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */