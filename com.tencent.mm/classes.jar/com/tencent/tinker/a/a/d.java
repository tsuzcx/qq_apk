package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends t.a.a<d>
{
  public int[][] BoA;
  public int[][] BoB;
  public int[][] BoC;
  public int Boz;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.Boz = paramInt2;
    this.BoA = paramArrayOfInt1;
    this.BoB = paramArrayOfInt2;
    this.BoC = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.Boz != paramd.Boz)
    {
      j = c.ip(this.Boz, paramd.Boz);
      return j;
    }
    int n = this.BoA.length;
    int j = this.BoB.length;
    int m = this.BoC.length;
    int i = paramd.BoA.length;
    int i1 = paramd.BoB.length;
    int i2 = paramd.BoC.length;
    if (n != i) {
      return c.iq(n, i);
    }
    if (j != i1) {
      return c.iq(j, i1);
    }
    if (m != i2) {
      return c.iq(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.BoA[i][0];
      i2 = this.BoA[i][1];
      i3 = paramd.BoA[i][0];
      int i4 = paramd.BoA[i][1];
      if (i1 != i3) {
        return c.ip(i1, i3);
      }
      if (i2 != i4) {
        return c.iq(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.BoB[i][0];
      i1 = this.BoB[i][1];
      i2 = paramd.BoB[i][0];
      i3 = paramd.BoB[i][1];
      if (n != i2) {
        return c.ip(n, i2);
      }
      if (i1 != i3) {
        return c.iq(i1, i3);
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
      j = this.BoC[i][0];
      n = this.BoC[i][1];
      i1 = paramd.BoC[i][0];
      i2 = paramd.BoC[i][1];
      if (j != i1) {
        return c.ip(j, i1);
      }
      if (n != i2) {
        return c.iq(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.Boz), this.BoA, this.BoB, this.BoC });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */