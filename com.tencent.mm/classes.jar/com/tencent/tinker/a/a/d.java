package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int Mzw;
  public int[][] Mzx;
  public int[][] Mzy;
  public int[][] Mzz;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.Mzw = paramInt2;
    this.Mzx = paramArrayOfInt1;
    this.Mzy = paramArrayOfInt2;
    this.Mzz = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.Mzw != paramd.Mzw)
    {
      j = c.lf(this.Mzw, paramd.Mzw);
      return j;
    }
    int n = this.Mzx.length;
    int j = this.Mzy.length;
    int m = this.Mzz.length;
    int i = paramd.Mzx.length;
    int i1 = paramd.Mzy.length;
    int i2 = paramd.Mzz.length;
    if (n != i) {
      return c.lg(n, i);
    }
    if (j != i1) {
      return c.lg(j, i1);
    }
    if (m != i2) {
      return c.lg(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.Mzx[i][0];
      i2 = this.Mzx[i][1];
      i3 = paramd.Mzx[i][0];
      int i4 = paramd.Mzx[i][1];
      if (i1 != i3) {
        return c.lf(i1, i3);
      }
      if (i2 != i4) {
        return c.lg(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.Mzy[i][0];
      i1 = this.Mzy[i][1];
      i2 = paramd.Mzy[i][0];
      i3 = paramd.Mzy[i][1];
      if (n != i2) {
        return c.lf(n, i2);
      }
      if (i1 != i3) {
        return c.lg(i1, i3);
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
      j = this.Mzz[i][0];
      n = this.Mzz[i][1];
      i1 = paramd.Mzz[i][0];
      i2 = paramd.Mzz[i][1];
      if (j != i1) {
        return c.lf(j, i1);
      }
      if (n != i2) {
        return c.lg(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.Mzw), this.Mzx, this.Mzy, this.Mzz });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */