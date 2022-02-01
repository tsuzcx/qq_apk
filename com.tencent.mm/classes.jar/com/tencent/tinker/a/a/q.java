package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int ahOn;
  public int ahOo;
  public int ahOp;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.ahOn = paramInt2;
    this.ahOo = paramInt3;
    this.ahOp = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.pR(this.ahOn, paramq.ahOn);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.pR(this.ahOo, paramq.ahOo);
      i = j;
    } while (j != 0);
    return c.pS(this.ahOp, paramq.ahOp);
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
    return e.hash(new Object[] { Integer.valueOf(this.ahOn), Integer.valueOf(this.ahOo), Integer.valueOf(this.ahOp) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */