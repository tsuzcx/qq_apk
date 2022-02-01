package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int ZIl;
  public int[][] ZIm;
  public int[][] ZIn;
  public int[][] ZIo;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.ZIl = paramInt2;
    this.ZIm = paramArrayOfInt1;
    this.ZIn = paramArrayOfInt2;
    this.ZIo = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.ZIl != paramd.ZIl)
    {
      j = c.nU(this.ZIl, paramd.ZIl);
      return j;
    }
    int n = this.ZIm.length;
    int j = this.ZIn.length;
    int m = this.ZIo.length;
    int i = paramd.ZIm.length;
    int i1 = paramd.ZIn.length;
    int i2 = paramd.ZIo.length;
    if (n != i) {
      return c.nV(n, i);
    }
    if (j != i1) {
      return c.nV(j, i1);
    }
    if (m != i2) {
      return c.nV(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.ZIm[i][0];
      i2 = this.ZIm[i][1];
      i3 = paramd.ZIm[i][0];
      int i4 = paramd.ZIm[i][1];
      if (i1 != i3) {
        return c.nU(i1, i3);
      }
      if (i2 != i4) {
        return c.nV(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.ZIn[i][0];
      i1 = this.ZIn[i][1];
      i2 = paramd.ZIn[i][0];
      i3 = paramd.ZIn[i][1];
      if (n != i2) {
        return c.nU(n, i2);
      }
      if (i1 != i3) {
        return c.nV(i1, i3);
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
      j = this.ZIo[i][0];
      n = this.ZIo[i][1];
      i1 = paramd.ZIo[i][0];
      i2 = paramd.ZIo[i][1];
      if (j != i1) {
        return c.nU(j, i1);
      }
      if (n != i2) {
        return c.nV(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.ZIl), this.ZIm, this.ZIn, this.ZIo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */