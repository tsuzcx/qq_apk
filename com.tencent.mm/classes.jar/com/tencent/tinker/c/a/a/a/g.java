package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g
  extends i<com.tencent.tinker.a.a.g>
{
  private t.a Bra = null;
  private i.e Brb = null;
  
  public g(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.Bra = parami2.Bpj.BpP;
      this.Brb = parami2.a(this.Bra);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0) {
      paramc.Bsx.SN(paramInt2);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 != paramInt4) {
      paramc.Bsj.put(paramInt2, paramInt4);
    }
  }
  
  protected final t.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.Bpj.BpP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */