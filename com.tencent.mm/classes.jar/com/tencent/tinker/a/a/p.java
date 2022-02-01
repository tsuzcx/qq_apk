package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int IBs;
  public int IBt;
  public int IBu;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.IBs = paramInt2;
    this.IBu = paramInt3;
    this.IBt = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.IBs != paramp.IBs) {
      return c.ks(this.IBs, paramp.IBs);
    }
    if (this.IBt != paramp.IBt) {
      return c.ks(this.IBt, paramp.IBt);
    }
    return c.ks(this.IBu, paramp.IBu);
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
    return e.hash(new Object[] { Integer.valueOf(this.IBs), Integer.valueOf(this.IBu), Integer.valueOf(this.IBt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */