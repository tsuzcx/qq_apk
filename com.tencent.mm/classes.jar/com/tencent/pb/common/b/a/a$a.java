package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$a
  extends e
{
  public int[] BdD = g.bgZ;
  public int BdE = 0;
  public String[] BdF = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  public int twP = 0;
  public long twQ = 0L;
  
  public a$a()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    int i;
    if ((this.BdD != null) && (this.BdD.length > 0))
    {
      i = 0;
      while (i < this.BdD.length)
      {
        paramb.bk(4, this.BdD[i]);
        i += 1;
      }
    }
    if (this.BdE != 0) {
      paramb.bj(5, this.BdE);
    }
    if ((this.BdF != null) && (this.BdF.length > 0))
    {
      i = j;
      while (i < this.BdF.length)
      {
        String str = this.BdF[i];
        if (str != null) {
          paramb.e(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    j = i;
    int k;
    if (this.BdD != null)
    {
      j = i;
      if (this.BdD.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.BdD.length)
        {
          k += b.eY(this.BdD[j]);
          j += 1;
        }
        j = i + k + this.BdD.length * 1;
      }
    }
    i = j;
    if (this.BdE != 0) {
      i = j + b.bl(5, this.BdE);
    }
    j = i;
    if (this.BdF != null)
    {
      j = i;
      if (this.BdF.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.BdF.length; m = n)
        {
          String str = this.BdF[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.bf(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */