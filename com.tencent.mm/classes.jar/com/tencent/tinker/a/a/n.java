package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int McN;
  public int MdA;
  public int Mdz;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.Mdz = paramInt2;
    this.McN = paramInt3;
    this.MdA = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.Mdz != paramn.Mdz) {
      return c.kY(this.Mdz, paramn.Mdz);
    }
    if (this.MdA != paramn.MdA) {
      return c.kY(this.MdA, paramn.MdA);
    }
    return c.kY(this.McN, paramn.McN);
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
    return e.hash(new Object[] { Integer.valueOf(this.Mdz), Integer.valueOf(this.McN), Integer.valueOf(this.MdA) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */