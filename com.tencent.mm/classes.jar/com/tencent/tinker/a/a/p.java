package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int KnB;
  public int KnC;
  public int KnD;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.KnB = paramInt2;
    this.KnD = paramInt3;
    this.KnC = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.KnB != paramp.KnB) {
      return c.kJ(this.KnB, paramp.KnB);
    }
    if (this.KnC != paramp.KnC) {
      return c.kJ(this.KnC, paramp.KnC);
    }
    return c.kJ(this.KnD, paramp.KnD);
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
    return e.hash(new Object[] { Integer.valueOf(this.KnB), Integer.valueOf(this.KnD), Integer.valueOf(this.KnC) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */