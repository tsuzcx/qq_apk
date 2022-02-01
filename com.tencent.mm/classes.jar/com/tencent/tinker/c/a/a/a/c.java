package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.s.a;

public final class c
  extends i<com.tencent.tinker.a.a.b>
{
  private s.a ICN = null;
  private i.e ICO = null;
  
  public c(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, com.tencent.tinker.c.a.c.c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.ICN = parami2.IBe.IBI;
      this.ICO = parami2.a(this.ICN);
    }
  }
  
  protected final void a(com.tencent.tinker.c.a.c.c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      paramc.IEm.acy(paramInt2);
    }
  }
  
  protected final void a(com.tencent.tinker.c.a.c.c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != paramInt4) {
      paramc.IDY.put(paramInt2, paramInt4);
    }
  }
  
  protected final s.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.IBe.IBI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */