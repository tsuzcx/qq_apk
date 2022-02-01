package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$d
  extends e
{
  public String ZeQ = "";
  public a.ay ZeS = null;
  public int[] ZeT = g.bZR;
  public a.bf ZeU = null;
  public int ZeV = 0;
  public int ZeW = 0;
  public a.bd ZeX = null;
  public String ZeY = "";
  public String[] ZeZ = g.EMPTY_STRING_ARRAY;
  public a.o[] Zfa = a.o.ikL();
  public int Zfb = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int i2 = 0;
    int j = super.JG();
    int i = j;
    if (this.ZeS != null) {
      i = j + b.b(1, this.ZeS);
    }
    j = i;
    if (this.ZeT != null)
    {
      j = i;
      if (this.ZeT.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ZeT.length)
        {
          k += b.gR(this.ZeT[j]);
          j += 1;
        }
        j = i + k + this.ZeT.length * 1;
      }
    }
    i = j;
    if (this.ZeU != null) {
      i = j + b.b(3, this.ZeU);
    }
    j = i;
    if (this.ZeV != 0) {
      j = i + b.bN(4, this.ZeV);
    }
    i = j;
    if (this.ZeW != 0) {
      i = j + b.bN(5, this.ZeW);
    }
    j = i;
    if (this.ZeX != null) {
      j = i + b.b(6, this.ZeX);
    }
    i = j;
    if (!this.ZeQ.equals("")) {
      i = j + b.g(7, this.ZeQ);
    }
    int k = i;
    if (!this.ZeY.equals("")) {
      k = i + b.g(8, this.ZeY);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.bN(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.ZeZ != null)
    {
      i = j;
      if (this.ZeZ.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.ZeZ.length; m = n)
        {
          localObject = this.ZeZ[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cv((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.Zfa != null)
    {
      j = i;
      if (this.Zfa.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.Zfa.length) {
            break;
          }
          localObject = this.Zfa[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(202, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.Zfb != 0) {
      i = j + b.bN(240, this.Zfb);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.ZeS != null) {
      paramb.a(1, this.ZeS);
    }
    int i;
    if ((this.ZeT != null) && (this.ZeT.length > 0))
    {
      i = 0;
      while (i < this.ZeT.length)
      {
        paramb.bK(2, this.ZeT[i]);
        i += 1;
      }
    }
    if (this.ZeU != null) {
      paramb.a(3, this.ZeU);
    }
    if (this.ZeV != 0) {
      paramb.bK(4, this.ZeV);
    }
    if (this.ZeW != 0) {
      paramb.bK(5, this.ZeW);
    }
    if (this.ZeX != null) {
      paramb.a(6, this.ZeX);
    }
    if (!this.ZeQ.equals("")) {
      paramb.f(7, this.ZeQ);
    }
    if (!this.ZeY.equals("")) {
      paramb.f(8, this.ZeY);
    }
    if (this.netType != 0) {
      paramb.bK(9, this.netType);
    }
    Object localObject;
    if ((this.ZeZ != null) && (this.ZeZ.length > 0))
    {
      i = 0;
      while (i < this.ZeZ.length)
      {
        localObject = this.ZeZ[i];
        if (localObject != null) {
          paramb.f(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.Zfa != null) && (this.Zfa.length > 0))
    {
      i = j;
      while (i < this.Zfa.length)
      {
        localObject = this.Zfa[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zfb != 0) {
      paramb.bK(240, this.Zfb);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */