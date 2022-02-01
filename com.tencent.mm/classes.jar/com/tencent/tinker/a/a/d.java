package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int SfA;
  public int[][] SfB;
  public int[][] SfC;
  public int[][] SfD;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.SfA = paramInt2;
    this.SfB = paramArrayOfInt1;
    this.SfC = paramArrayOfInt2;
    this.SfD = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.SfA != paramd.SfA)
    {
      j = c.mD(this.SfA, paramd.SfA);
      return j;
    }
    int n = this.SfB.length;
    int j = this.SfC.length;
    int m = this.SfD.length;
    int i = paramd.SfB.length;
    int i1 = paramd.SfC.length;
    int i2 = paramd.SfD.length;
    if (n != i) {
      return c.mE(n, i);
    }
    if (j != i1) {
      return c.mE(j, i1);
    }
    if (m != i2) {
      return c.mE(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.SfB[i][0];
      i2 = this.SfB[i][1];
      i3 = paramd.SfB[i][0];
      int i4 = paramd.SfB[i][1];
      if (i1 != i3) {
        return c.mD(i1, i3);
      }
      if (i2 != i4) {
        return c.mE(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.SfC[i][0];
      i1 = this.SfC[i][1];
      i2 = paramd.SfC[i][0];
      i3 = paramd.SfC[i][1];
      if (n != i2) {
        return c.mD(n, i2);
      }
      if (i1 != i3) {
        return c.mE(i1, i3);
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = this.SfD[i][0];
      n = this.SfD[i][1];
      i1 = paramd.SfD[i][0];
      i2 = paramd.SfD[i][1];
      if (j != i1) {
        return c.mD(j, i1);
      }
      if (n != i2) {
        return c.mE(n, i2);
      }
      i += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d)) {}
    while (a((d)paramObject) != 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return e.hash(new Object[] { Integer.valueOf(this.SfA), this.SfB, this.SfC, this.SfD });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */