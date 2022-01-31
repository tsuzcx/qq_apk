package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class e
  extends i<com.tencent.tinker.a.a.e>
{
  private t.a BqW = null;
  private i.e BqX = null;
  
  public e(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.BqW = parami2.Bpj.BpO;
      this.BqX = parami2.a(this.BqW);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      paramc.Bsv.SN(paramInt2);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != paramInt4) {
      paramc.Bsh.put(paramInt2, paramInt4);
    }
  }
  
  protected final t.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.Bpj.BpO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */