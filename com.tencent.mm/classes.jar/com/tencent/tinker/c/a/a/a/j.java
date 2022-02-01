package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.s.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class j
  extends i<n>
{
  private s.a MCd = null;
  private i.e MCe = null;
  
  public j(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.MCd = parami2.MAg.MAE;
      this.MCe = parami2.a(this.MCd);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      paramc.MDm.aiD(paramInt1);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      paramc.MCY.put(paramInt1, paramInt3);
    }
  }
  
  protected final s.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.MAg.MAE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */