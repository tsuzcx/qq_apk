package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int MAu;
  public int MAv;
  public int MzI;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.MAu = paramInt2;
    this.MzI = paramInt3;
    this.MAv = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.MAu != paramn.MAu) {
      return c.lf(this.MAu, paramn.MAu);
    }
    if (this.MAv != paramn.MAv) {
      return c.lf(this.MAv, paramn.MAv);
    }
    return c.lf(this.MzI, paramn.MzI);
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
    return e.hash(new Object[] { Integer.valueOf(this.MAu), Integer.valueOf(this.MzI), Integer.valueOf(this.MAv) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */