package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class p
  extends s.a.a<p>
{
  public int SgA;
  public int Sgy;
  public int Sgz;
  
  public p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.Sgy = paramInt2;
    this.SgA = paramInt3;
    this.Sgz = paramInt4;
  }
  
  private int b(p paramp)
  {
    if (this.Sgy != paramp.Sgy) {
      return c.mD(this.Sgy, paramp.Sgy);
    }
    if (this.Sgz != paramp.Sgz) {
      return c.mD(this.Sgz, paramp.Sgz);
    }
    return c.mD(this.SgA, paramp.SgA);
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
    return e.hash(new Object[] { Integer.valueOf(this.Sgy), Integer.valueOf(this.SgA), Integer.valueOf(this.Sgz) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.p
 * JD-Core Version:    0.7.0.1
 */