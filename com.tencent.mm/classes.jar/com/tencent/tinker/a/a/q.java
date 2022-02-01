package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int MAx;
  public int MAy;
  public int MAz;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.MAx = paramInt2;
    this.MAy = paramInt3;
    this.MAz = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.lf(this.MAx, paramq.MAx);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.lf(this.MAy, paramq.MAy);
      i = j;
    } while (j != 0);
    return c.lg(this.MAz, paramq.MAz);
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
    return e.hash(new Object[] { Integer.valueOf(this.MAx), Integer.valueOf(this.MAy), Integer.valueOf(this.MAz) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */