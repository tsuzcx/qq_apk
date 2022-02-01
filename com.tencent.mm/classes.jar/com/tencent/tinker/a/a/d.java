package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int KmD;
  public int[][] KmE;
  public int[][] KmF;
  public int[][] KmG;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.KmD = paramInt2;
    this.KmE = paramArrayOfInt1;
    this.KmF = paramArrayOfInt2;
    this.KmG = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.KmD != paramd.KmD)
    {
      j = c.kJ(this.KmD, paramd.KmD);
      return j;
    }
    int n = this.KmE.length;
    int j = this.KmF.length;
    int m = this.KmG.length;
    int i = paramd.KmE.length;
    int i1 = paramd.KmF.length;
    int i2 = paramd.KmG.length;
    if (n != i) {
      return c.kK(n, i);
    }
    if (j != i1) {
      return c.kK(j, i1);
    }
    if (m != i2) {
      return c.kK(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.KmE[i][0];
      i2 = this.KmE[i][1];
      i3 = paramd.KmE[i][0];
      int i4 = paramd.KmE[i][1];
      if (i1 != i3) {
        return c.kJ(i1, i3);
      }
      if (i2 != i4) {
        return c.kK(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.KmF[i][0];
      i1 = this.KmF[i][1];
      i2 = paramd.KmF[i][0];
      i3 = paramd.KmF[i][1];
      if (n != i2) {
        return c.kJ(n, i2);
      }
      if (i1 != i3) {
        return c.kK(i1, i3);
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
      j = this.KmG[i][0];
      n = this.KmG[i][1];
      i1 = paramd.KmG[i][0];
      i2 = paramd.KmG[i][1];
      if (j != i1) {
        return c.kJ(j, i1);
      }
      if (n != i2) {
        return c.kK(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.KmD), this.KmE, this.KmF, this.KmG });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */