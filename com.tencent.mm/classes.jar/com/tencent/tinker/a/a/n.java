package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int ZIx;
  public int ZJj;
  public int ZJk;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.ZJj = paramInt2;
    this.ZIx = paramInt3;
    this.ZJk = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.ZJj != paramn.ZJj) {
      return c.nU(this.ZJj, paramn.ZJj);
    }
    if (this.ZJk != paramn.ZJk) {
      return c.nU(this.ZJk, paramn.ZJk);
    }
    return c.nU(this.ZIx, paramn.ZIx);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof n)) {}
    while (b((n)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.ZJj), Integer.valueOf(this.ZIx), Integer.valueOf(this.ZJk) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */