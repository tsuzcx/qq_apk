package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$a
  extends e
{
  public String[] IkA = g.EMPTY_STRING_ARRAY;
  public int[] Iky = g.bIT;
  public int Ikz = 0;
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$a()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.zkT != 0) {
      paramb.by(2, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(3, this.zkU);
    }
    int i;
    if ((this.Iky != null) && (this.Iky.length > 0))
    {
      i = 0;
      while (i < this.Iky.length)
      {
        paramb.bz(4, this.Iky[i]);
        i += 1;
      }
    }
    if (this.Ikz != 0) {
      paramb.by(5, this.Ikz);
    }
    if ((this.IkA != null) && (this.IkA.length > 0))
    {
      i = j;
      while (i < this.IkA.length)
      {
        String str = this.IkA[i];
        if (str != null) {
          paramb.d(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.zkT != 0) {
      j = i + b.bA(2, this.zkT);
    }
    i = j;
    if (this.zkU != 0L) {
      i = j + b.q(3, this.zkU);
    }
    j = i;
    int k;
    if (this.Iky != null)
    {
      j = i;
      if (this.Iky.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Iky.length)
        {
          k += b.ga(this.Iky[j]);
          j += 1;
        }
        j = i + k + this.Iky.length * 1;
      }
    }
    i = j;
    if (this.Ikz != 0) {
      i = j + b.bA(5, this.Ikz);
    }
    j = i;
    if (this.IkA != null)
    {
      j = i;
      if (this.IkA.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.IkA.length; m = n)
        {
          String str = this.IkA[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.bs(str);
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