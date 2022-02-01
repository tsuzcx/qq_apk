package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int MdC;
  public int MdD;
  public int MdE;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.MdC = paramInt2;
    this.MdD = paramInt3;
    this.MdE = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.kY(this.MdC, paramq.MdC);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.kY(this.MdD, paramq.MdD);
      i = j;
    } while (j != 0);
    return c.kZ(this.MdE, paramq.MdE);
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
    return e.hash(new Object[] { Integer.valueOf(this.MdC), Integer.valueOf(this.MdD), Integer.valueOf(this.MdE) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */