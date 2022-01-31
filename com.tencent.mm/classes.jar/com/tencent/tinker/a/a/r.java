package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class r
  extends t.a.a<r>
{
  public int BpA;
  public int BpB;
  public int BpC;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.BpA = paramInt2;
    this.BpB = paramInt3;
    this.BpC = paramInt4;
  }
  
  private int b(r paramr)
  {
    int i = c.ip(this.BpA, paramr.BpA);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.ip(this.BpB, paramr.BpB);
      i = j;
    } while (j != 0);
    return c.iq(this.BpC, paramr.BpC);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof r)) {}
    while (b((r)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.BpA), Integer.valueOf(this.BpB), Integer.valueOf(this.BpC) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tinker.a.a.r
 * JD-Core Version:    0.7.0.1
 */