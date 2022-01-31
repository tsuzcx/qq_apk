package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$a
  extends e
{
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public int[] wGc = g.aUJ;
  public int wGd = 0;
  public String[] wGe = g.EMPTY_STRING_ARRAY;
  
  public a$a()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.pRI != 0) {
      paramb.aL(2, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(3, this.pRJ);
    }
    int i;
    if ((this.wGc != null) && (this.wGc.length > 0))
    {
      i = 0;
      while (i < this.wGc.length)
      {
        paramb.aM(4, this.wGc[i]);
        i += 1;
      }
    }
    if (this.wGd != 0) {
      paramb.aL(5, this.wGd);
    }
    if ((this.wGe != null) && (this.wGe.length > 0))
    {
      i = j;
      while (i < this.wGe.length)
      {
        String str = this.wGe[i];
        if (str != null) {
          paramb.d(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.pRI != 0) {
      j = i + b.aN(2, this.pRI);
    }
    i = j;
    if (this.pRJ != 0L) {
      i = j + b.k(3, this.pRJ);
    }
    j = i;
    int k;
    if (this.wGc != null)
    {
      j = i;
      if (this.wGc.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.wGc.length)
        {
          k += b.dS(this.wGc[j]);
          j += 1;
        }
        j = i + k + this.wGc.length * 1;
      }
    }
    i = j;
    if (this.wGd != 0) {
      i = j + b.aN(5, this.wGd);
    }
    j = i;
    if (this.wGe != null)
    {
      j = i;
      if (this.wGe.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.wGe.length; m = n)
        {
          String str = this.wGe[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.aI(str);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 2;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */