package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.e;

public final class d
  extends s.a.a<d>
{
  public int ahNo;
  public int[][] ahNp;
  public int[][] ahNq;
  public int[][] ahNr;
  
  public d(int paramInt1, int paramInt2, int[][] paramArrayOfInt1, int[][] paramArrayOfInt2, int[][] paramArrayOfInt3)
  {
    super(paramInt1);
    this.ahNo = paramInt2;
    this.ahNp = paramArrayOfInt1;
    this.ahNq = paramArrayOfInt2;
    this.ahNr = paramArrayOfInt3;
  }
  
  private int a(d paramd)
  {
    int k = 0;
    if (this.ahNo != paramd.ahNo)
    {
      j = c.pR(this.ahNo, paramd.ahNo);
      return j;
    }
    int n = this.ahNp.length;
    int j = this.ahNq.length;
    int m = this.ahNr.length;
    int i = paramd.ahNp.length;
    int i1 = paramd.ahNq.length;
    int i2 = paramd.ahNr.length;
    if (n != i) {
      return c.pS(n, i);
    }
    if (j != i1) {
      return c.pS(j, i1);
    }
    if (m != i2) {
      return c.pS(m, i2);
    }
    i = 0;
    int i3;
    while (i < n)
    {
      i1 = this.ahNp[i][0];
      i2 = this.ahNp[i][1];
      i3 = paramd.ahNp[i][0];
      int i4 = paramd.ahNp[i][1];
      if (i1 != i3) {
        return c.pR(i1, i3);
      }
      if (i2 != i4) {
        return c.pS(i2, i4);
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      n = this.ahNq[i][0];
      i1 = this.ahNq[i][1];
      i2 = paramd.ahNq[i][0];
      i3 = paramd.ahNq[i][1];
      if (n != i2) {
        return c.pR(n, i2);
      }
      if (i1 != i3) {
        return c.pS(i1, i3);
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
      j = this.ahNr[i][0];
      n = this.ahNr[i][1];
      i1 = paramd.ahNr[i][0];
      i2 = paramd.ahNr[i][1];
      if (j != i1) {
        return c.pR(j, i1);
      }
      if (n != i2) {
        return c.pS(n, i2);
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
    return e.hash(new Object[] { Integer.valueOf(this.ahNo), this.ahNp, this.ahNq, this.ahNr });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.d
 * JD-Core Version:    0.7.0.1
 */