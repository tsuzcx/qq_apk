package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int MdA;
  public int MdB;
  public int Mdz;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.Mdz = paramInt2;
    this.MdB = paramInt3;
    this.MdA = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.Mdz != paramp.Mdz) {
      return c.kY(this.Mdz, paramp.Mdz);
    }
    if (this.MdA != paramp.MdA) {
      return c.kY(this.MdA, paramp.MdA);
    }
    return c.kY(this.MdB, paramp.MdB);
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
    return e.hash(new Object[] { Integer.valueOf(this.Mdz), Integer.valueOf(this.MdB), Integer.valueOf(this.MdA) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */