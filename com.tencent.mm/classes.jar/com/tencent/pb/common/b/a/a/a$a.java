package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$a
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int[] McW = g.bQP;
  public int McX = 0;
  public String[] McY = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  
  public a$a()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(2, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(3, this.Cug);
    }
    int i;
    if ((this.McW != null) && (this.McW.length > 0))
    {
      i = 0;
      while (i < this.McW.length)
      {
        paramb.by(4, this.McW[i]);
        i += 1;
      }
    }
    if (this.McX != 0) {
      paramb.bx(5, this.McX);
    }
    if ((this.McY != null) && (this.McY.length > 0))
    {
      i = j;
      while (i < this.McY.length)
      {
        String str = this.McY[i];
        if (str != null) {
          paramb.d(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.Cuf != 0) {
      j = i + b.bz(2, this.Cuf);
    }
    i = j;
    if (this.Cug != 0L) {
      i = j + b.p(3, this.Cug);
    }
    j = i;
    int k;
    if (this.McW != null)
    {
      j = i;
      if (this.McW.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.McW.length)
        {
          k += b.fP(this.McW[j]);
          j += 1;
        }
        j = i + k + this.McW.length * 1;
      }
    }
    i = j;
    if (this.McX != 0) {
      i = j + b.bz(5, this.McX);
    }
    j = i;
    if (this.McY != null)
    {
      j = i;
      if (this.McY.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.McY.length; m = n)
        {
          String str = this.McY[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.cc(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */