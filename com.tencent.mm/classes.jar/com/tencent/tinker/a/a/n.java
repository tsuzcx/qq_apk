package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int KmP;
  public int KnB;
  public int KnC;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.KnB = paramInt2;
    this.KmP = paramInt3;
    this.KnC = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.KnB != paramn.KnB) {
      return c.kJ(this.KnB, paramn.KnB);
    }
    if (this.KnC != paramn.KnC) {
      return c.kJ(this.KnC, paramn.KnC);
    }
    return c.kJ(this.KmP, paramn.KmP);
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
    return e.hash(new Object[] { Integer.valueOf(this.KnB), Integer.valueOf(this.KmP), Integer.valueOf(this.KnC) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */