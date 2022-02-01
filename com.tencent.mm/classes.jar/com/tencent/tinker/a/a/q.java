package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int SgB;
  public int SgC;
  public int SgD;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.SgB = paramInt2;
    this.SgC = paramInt3;
    this.SgD = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.mD(this.SgB, paramq.SgB);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.mD(this.SgC, paramq.SgC);
      i = j;
    } while (j != 0);
    return c.mE(this.SgD, paramq.SgD);
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
    return e.hash(new Object[] { Integer.valueOf(this.SgB), Integer.valueOf(this.SgC), Integer.valueOf(this.SgD) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */