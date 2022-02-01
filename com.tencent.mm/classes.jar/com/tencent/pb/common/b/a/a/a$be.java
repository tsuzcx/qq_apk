package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$be
  extends e
{
  public int IkG = 0;
  public a.ay[] IlV = a.ay.flz();
  public int InS = 0;
  public String InT = "";
  public String[] InU = g.EMPTY_STRING_ARRAY;
  public long InV = 0L;
  public String Ink = "";
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$be()
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
    if (this.IkG != 0) {
      paramb.bz(4, this.IkG);
    }
    if (this.InS != 0) {
      paramb.by(5, this.InS);
    }
    if (!this.Ink.equals("")) {
      paramb.d(6, this.Ink);
    }
    int i;
    Object localObject;
    if ((this.IlV != null) && (this.IlV.length > 0))
    {
      i = 0;
      while (i < this.IlV.length)
      {
        localObject = this.IlV[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.InT.equals("")) {
      paramb.d(8, this.InT);
    }
    if ((this.InU != null) && (this.InU.length > 0))
    {
      i = j;
      while (i < this.InU.length)
      {
        localObject = this.InU[i];
        if (localObject != null) {
          paramb.d(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.InV != 0L) {
      paramb.n(10, this.InV);
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
    if (this.IkG != 0) {
      j = i + b.bB(4, this.IkG);
    }
    int k = j;
    if (this.InS != 0) {
      k = j + b.bA(5, this.InS);
    }
    i = k;
    if (!this.Ink.equals("")) {
      i = k + b.e(6, this.Ink);
    }
    j = i;
    Object localObject;
    if (this.IlV != null)
    {
      j = i;
      if (this.IlV.length > 0)
      {
        j = 0;
        while (j < this.IlV.length)
        {
          localObject = this.IlV[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!this.InT.equals("")) {
      i = j + b.e(8, this.InT);
    }
    j = i;
    if (this.InU != null)
    {
      j = i;
      if (this.InU.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.InU.length; m = n)
        {
          localObject = this.InU[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.bs((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.InV != 0L) {
      i = j + b.p(10, this.InV);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */