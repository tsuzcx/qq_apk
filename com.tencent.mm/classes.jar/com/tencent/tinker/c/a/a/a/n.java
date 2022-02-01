package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.s.a;
import com.tencent.tinker.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class n
  extends i<r>
{
  private s.a Mfo = null;
  private s.a Mfp = null;
  private i.e Mfq = null;
  private i.e Mfr = null;
  
  public n(com.tencent.tinker.c.a.b.a parama, com.tencent.tinker.a.a.i parami1, com.tencent.tinker.a.a.i parami2, c paramc)
  {
    super(parama, parami1, paramc);
    if (parami2 != null)
    {
      this.Mfo = parami2.Mdl.MdS;
      this.Mfp = parami2.Mdl.MdG;
      this.Mfq = parami2.a(this.Mfo);
      this.Mfr = parami2.a(this.Mfp);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      paramc.Mgm.ahU(paramInt1);
    }
  }
  
  protected final void a(c paramc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      paramc.MfY.put(paramInt1, paramInt3);
    }
  }
  
  protected final s.a c(com.tencent.tinker.a.a.i parami)
  {
    return parami.Mdl.MdS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */