package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int ZJj;
  public int ZJk;
  public int ZJl;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.ZJj = paramInt2;
    this.ZJl = paramInt3;
    this.ZJk = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.ZJj != paramp.ZJj) {
      return c.nU(this.ZJj, paramp.ZJj);
    }
    if (this.ZJk != paramp.ZJk) {
      return c.nU(this.ZJk, paramp.ZJk);
    }
    return c.nU(this.ZJl, paramp.ZJl);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof p)) {}
    while (b((p)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.ZJj), Integer.valueOf(this.ZJl), Integer.valueOf(this.ZJk) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */