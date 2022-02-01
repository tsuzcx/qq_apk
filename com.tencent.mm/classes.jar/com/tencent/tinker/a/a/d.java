package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int McB;
  public int[][] McC;
  public int[][] McD;
  public int[][] McE;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.McB = paramInt2;
    this.McC = paramArrayOfInt1;
    this.McD = paramArrayOfInt2;
    this.McE = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.McB != paramd.McB)
    {
      j = c.kY(this.McB, paramd.McB);
      return j;
    }
    int n = this.McC.length;
    int j = this.McD.length;
    int m = this.McE.length;
    int i = paramd.McC.length;
    int i1 = paramd.McD.length;
    int i2 = paramd.McE.length;
    if (n != i) {
      return c.kZ(n, i);
    }
    if (j != i1) {
      return c.kZ(j, i1);
    }
    if (m != i2) {
      return c.kZ(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.McC[i][0];
      i2 = this.McC[i][1];
      i3 = paramd.McC[i][0];
      int i4 = paramd.McC[i][1];
      if (i1 != i3) {
        return c.kY(i1, i3);
      }
      if (i2 != i4) {
        return c.kZ(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.McD[i][0];
      i1 = this.McD[i][1];
      i2 = paramd.McD[i][0];
      i3 = paramd.McD[i][1];
      if (n != i2) {
        return c.kY(n, i2);
      }
      if (i1 != i3) {
        return c.kZ(i1, i3);
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
      j = this.McE[i][0];
      n = this.McE[i][1];
      i1 = paramd.McE[i][0];
      i2 = paramd.McE[i][1];
      if (j != i1) {
        return c.kY(j, i1);
      }
      if (n != i2) {
        return c.kZ(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.McB), this.McC, this.McD, this.McE });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */