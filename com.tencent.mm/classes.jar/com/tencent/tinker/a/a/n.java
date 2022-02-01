package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class n
  extends s.a.a<n>
{
  public int SfM;
  public int Sgy;
  public int Sgz;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1);
    this.Sgy = paramInt2;
    this.SfM = paramInt3;
    this.Sgz = paramInt4;
  }
  
  private int b(n paramn)
  {
    if (this.Sgy != paramn.Sgy) {
      return c.mD(this.Sgy, paramn.Sgy);
    }
    if (this.Sgz != paramn.Sgz) {
      return c.mD(this.Sgz, paramn.Sgz);
    }
    return c.mD(this.SfM, paramn.SfM);
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
    return e.hash(new Object[] { Integer.valueOf(this.Sgy), Integer.valueOf(this.SfM), Integer.valueOf(this.Sgz) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.n
 * JD-Core Version:    0.7.0.1
 */