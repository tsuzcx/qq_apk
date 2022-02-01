package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int IAG;
  public int IBs;
  public int IBt;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.IBs = paramInt2;
    this.IAG = paramInt3;
    this.IBt = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.IBs != paramn.IBs) {
      return c.ks(this.IBs, paramn.IBs);
    }
    if (this.IBt != paramn.IBt) {
      return c.ks(this.IBt, paramn.IBt);
    }
    return c.ks(this.IAG, paramn.IAG);
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
    return e.hash(new Object[] { Integer.valueOf(this.IBs), Integer.valueOf(this.IAG), Integer.valueOf(this.IBt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */