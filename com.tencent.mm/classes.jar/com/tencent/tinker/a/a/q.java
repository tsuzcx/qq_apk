package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int KnE;
  public int KnF;
  public int KnG;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.KnE = paramInt2;
    this.KnF = paramInt3;
    this.KnG = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.kJ(this.KnE, paramq.KnE);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.kJ(this.KnF, paramq.KnF);
      i = j;
    } while (j != 0);
    return c.kK(this.KnG, paramq.KnG);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof q)) {}
    while (b((q)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.KnE), Integer.valueOf(this.KnF), Integer.valueOf(this.KnG) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */