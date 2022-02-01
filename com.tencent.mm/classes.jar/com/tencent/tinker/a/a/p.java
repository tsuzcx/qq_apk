package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int ahOk;
  public int ahOl;
  public int ahOm;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.ahOk = paramInt2;
    this.ahOm = paramInt3;
    this.ahOl = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.ahOk != paramp.ahOk) {
      return c.pR(this.ahOk, paramp.ahOk);
    }
    if (this.ahOl != paramp.ahOl) {
      return c.pR(this.ahOl, paramp.ahOl);
    }
    return c.pR(this.ahOm, paramp.ahOm);
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
    return e.hash(new Object[] { Integer.valueOf(this.ahOk), Integer.valueOf(this.ahOm), Integer.valueOf(this.ahOl) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */