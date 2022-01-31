package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class a
  extends i<com.tencent.tinker.a.a.a>
{
  private t.a BqO = null;
  private i.e BqP = null;
  
  public a(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.BqO = parami2.Bpj.BpS;
      this.BqP = parami2.a(this.BqO);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      paramc.Bsq.SN(paramInt2);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != paramInt4) {
      paramc.Bsc.put(paramInt2, paramInt4);
    }
  }
  
  protected final t.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.Bpj.BpS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */