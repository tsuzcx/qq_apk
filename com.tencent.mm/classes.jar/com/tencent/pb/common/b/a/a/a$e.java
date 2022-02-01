package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$e
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int ZeO = 0;
  public a.ay ZeS = null;
  public a.bf ZeU = null;
  public int ZeW = 0;
  public String[] ZeZ = g.EMPTY_STRING_ARRAY;
  public a.o[] Zfa = a.o.ikL();
  public int Zfb = 0;
  public a.u Zfc = null;
  public int Zfd = 0;
  public String groupId = "";
  public int netType = 0;
  public int xbJ = 0;
  
  public a$e()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int i2 = 0;
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
    if (this.ZeU != null) {
      j = i + b.b(4, this.ZeU);
    }
    i = j;
    if (this.xbJ != 0) {
      i = j + b.bM(5, this.xbJ);
    }
    j = i;
    if (this.ZeW != 0) {
      j = i + b.bN(6, this.ZeW);
    }
    i = j;
    if (this.ZeO != 0) {
      i = j + b.bM(7, this.ZeO);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.bN(8, this.netType);
    }
    j = k;
    if (this.ZeS != null) {
      j = k + b.b(200, this.ZeS);
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
    if (this.Zfc != null) {
      i = j + b.b(203, this.Zfc);
    }
    j = i;
    if (this.Zfd != 0) {
      j = i + b.bN(204, this.Zfd);
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
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    if (this.ZeU != null) {
      paramb.a(4, this.ZeU);
    }
    if (this.xbJ != 0) {
      paramb.bJ(5, this.xbJ);
    }
    if (this.ZeW != 0) {
      paramb.bK(6, this.ZeW);
    }
    if (this.ZeO != 0) {
      paramb.bJ(7, this.ZeO);
    }
    if (this.netType != 0) {
      paramb.bK(8, this.netType);
    }
    if (this.ZeS != null) {
      paramb.a(200, this.ZeS);
    }
    int i;
    Object localObject;
    if ((this.ZeZ != null) && (this.ZeZ.length > 0))
    {
      i = 0;
      while (i < this.ZeZ.length)
      {
        localObject = this.ZeZ[i];
        if (localObject != null) {
          paramb.f(201, (String)localObject);
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
    if (this.Zfc != null) {
      paramb.a(203, this.Zfc);
    }
    if (this.Zfd != 0) {
      paramb.bK(204, this.Zfd);
    }
    if (this.Zfb != 0) {
      paramb.bK(240, this.Zfb);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */