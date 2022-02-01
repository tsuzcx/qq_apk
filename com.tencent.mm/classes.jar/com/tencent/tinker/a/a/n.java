package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int ahNA;
  public int ahOk;
  public int ahOl;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.ahOk = paramInt2;
    this.ahNA = paramInt3;
    this.ahOl = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.ahOk != paramn.ahOk) {
      return c.pR(this.ahOk, paramn.ahOk);
    }
    if (this.ahOl != paramn.ahOl) {
      return c.pR(this.ahOl, paramn.ahOl);
    }
    return c.pR(this.ahNA, paramn.ahNA);
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
    return e.hash(new Object[] { Integer.valueOf(this.ahOk), Integer.valueOf(this.ahNA), Integer.valueOf(this.ahOl) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */