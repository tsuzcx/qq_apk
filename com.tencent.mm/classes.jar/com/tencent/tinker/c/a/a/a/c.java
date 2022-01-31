package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.t.a;

public final class c
  extends i<com.tencent.tinker.a.a.b>
{
  private t.a BqS = null;
  private i.e BqT = null;
  
  public c(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, com.tencent.tinker.c.a.c.c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.BqS = parami2.Bpj.BpN;
      this.BqT = parami2.a(this.BqS);
    }
  }
  
  protected final void a(com.tencent.tinker.c.a.c.c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      paramc.Bsr.SN(paramInt2);
    }
  }
  
  protected final void a(com.tencent.tinker.c.a.c.c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != paramInt4) {
      paramc.Bsd.put(paramInt2, paramInt4);
    }
  }
  
  protected final t.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.Bpj.BpN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */