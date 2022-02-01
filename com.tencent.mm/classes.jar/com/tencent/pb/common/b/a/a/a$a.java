package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$a
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int[] ZeN = g.bZR;
  public int ZeO = 0;
  public String[] ZeP = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  
  public a$a()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(1, this.groupId);
    }
    j = i;
    if (this.NOc != 0) {
      j = i + b.bM(2, this.NOc);
    }
    i = j;
    if (this.NOd != 0L) {
      i = j + b.p(3, this.NOd);
    }
    j = i;
    int k;
    if (this.ZeN != null)
    {
      j = i;
      if (this.ZeN.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ZeN.length)
        {
          k += b.gR(this.ZeN[j]);
          j += 1;
        }
        j = i + k + this.ZeN.length * 1;
      }
    }
    i = j;
    if (this.ZeO != 0) {
      i = j + b.bM(5, this.ZeO);
    }
    j = i;
    if (this.ZeP != null)
    {
      j = i;
      if (this.ZeP.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.ZeP.length; m = n)
        {
          String str = this.ZeP[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.cv(str);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 2;
      }
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    int i;
    if ((this.ZeN != null) && (this.ZeN.length > 0))
    {
      i = 0;
      while (i < this.ZeN.length)
      {
        paramb.bK(4, this.ZeN[i]);
        i += 1;
      }
    }
    if (this.ZeO != 0) {
      paramb.bJ(5, this.ZeO);
    }
    if ((this.ZeP != null) && (this.ZeP.length > 0))
    {
      i = j;
      while (i < this.ZeP.length)
      {
        String str = this.ZeP[i];
        if (str != null) {
          paramb.f(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */