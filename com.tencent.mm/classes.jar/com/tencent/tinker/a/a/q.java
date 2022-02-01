package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class q
  extends s.a.a<q>
{
  public int IBv;
  public int IBw;
  public int IBx;
  
  public q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.IBv = paramInt2;
    this.IBw = paramInt3;
    this.IBx = paramInt4;
  }
  
  private int b(q paramq)
  {
    int i = c.ks(this.IBv, paramq.IBv);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = c.ks(this.IBw, paramq.IBw);
      i = j;
    } while (j != 0);
    return c.kt(this.IBx, paramq.IBx);
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
    return e.hash(new Object[] { Integer.valueOf(this.IBv), Integer.valueOf(this.IBw), Integer.valueOf(this.IBx) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.q
 * JD-Core Version:    0.7.0.1
 */