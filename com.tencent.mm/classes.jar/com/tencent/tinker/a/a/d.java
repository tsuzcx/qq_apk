package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int IAu;
  public int[][] IAv;
  public int[][] IAw;
  public int[][] IAx;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.IAu = paramInt2;
    this.IAv = paramArrayOfInt1;
    this.IAw = paramArrayOfInt2;
    this.IAx = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.IAu != paramd.IAu)
    {
      j = c.ks(this.IAu, paramd.IAu);
      return j;
    }
    int n = this.IAv.length;
    int j = this.IAw.length;
    int m = this.IAx.length;
    int i = paramd.IAv.length;
    int i1 = paramd.IAw.length;
    int i2 = paramd.IAx.length;
    if (n != i) {
      return c.kt(n, i);
    }
    if (j != i1) {
      return c.kt(j, i1);
    }
    if (m != i2) {
      return c.kt(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.IAv[i][0];
      i2 = this.IAv[i][1];
      i3 = paramd.IAv[i][0];
      int i4 = paramd.IAv[i][1];
      if (i1 != i3) {
        return c.ks(i1, i3);
      }
      if (i2 != i4) {
        return c.kt(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.IAw[i][0];
      i1 = this.IAw[i][1];
      i2 = paramd.IAw[i][0];
      i3 = paramd.IAw[i][1];
      if (n != i2) {
        return c.ks(n, i2);
      }
      if (i1 != i3) {
        return c.kt(i1, i3);
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
      j = this.IAx[i][0];
      n = this.IAx[i][1];
      i1 = paramd.IAx[i][0];
      i2 = paramd.IAx[i][1];
      if (j != i1) {
        return c.ks(j, i1);
      }
      if (n != i2) {
        return c.kt(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.IAu), this.IAv, this.IAw, this.IAx });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */