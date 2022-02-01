package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.s.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g
  extends i<com.tencent.tinker.a.a.g>
{
  private s.a Mfc = null;
  private i.e Mfd = null;
  
  public g(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.Mfc = parami2.Mdl.MdR;
      this.Mfd = parami2.a(this.Mfc);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      paramc.Mgz.ahU(paramInt2);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != paramInt4) {
      paramc.Mgl.put(paramInt2, paramInt4);
    }
  }
  
  protected final s.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.Mdl.MdR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */