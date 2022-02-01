package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$a
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int[] JMj = g.bGB;
  public int JMk = 0;
  public String[] JMl = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  
  public a$a()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.ADE != 0) {
      paramb.bv(2, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(3, this.ADF);
    }
    int i;
    if ((this.JMj != null) && (this.JMj.length > 0))
    {
      i = 0;
      while (i < this.JMj.length)
      {
        paramb.bw(4, this.JMj[i]);
        i += 1;
      }
    }
    if (this.JMk != 0) {
      paramb.bv(5, this.JMk);
    }
    if ((this.JMl != null) && (this.JMl.length > 0))
    {
      i = j;
      while (i < this.JMl.length)
      {
        String str = this.JMl[i];
        if (str != null) {
          paramb.d(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.ADE != 0) {
      j = i + b.bx(2, this.ADE);
    }
    i = j;
    if (this.ADF != 0L) {
      i = j + b.p(3, this.ADF);
    }
    j = i;
    int k;
    if (this.JMj != null)
    {
      j = i;
      if (this.JMj.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.JMj.length)
        {
          k += b.fM(this.JMj[j]);
          j += 1;
        }
        j = i + k + this.JMj.length * 1;
      }
    }
    i = j;
    if (this.JMk != 0) {
      i = j + b.bx(5, this.JMk);
    }
    j = i;
    if (this.JMl != null)
    {
      j = i;
      if (this.JMl.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.JMl.length; m = n)
        {
          String str = this.JMl[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.bj(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */