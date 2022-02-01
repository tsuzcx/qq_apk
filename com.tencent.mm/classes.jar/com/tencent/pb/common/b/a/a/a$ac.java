package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ac
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int SoO = -1;
  public a.ay ZeS = null;
  public a.ax ZfE = null;
  public int ZfG = 0;
  public a.ba[] ZfK = a.ba.ikV();
  public int Zfw = 0;
  public int ZgA = 0;
  public byte[] ZgB = g.ccX;
  public int[] ZgC = g.bZR;
  public a.ba[] Zgp = a.ba.ikV();
  public a.q[] Zgq = a.q.ikN();
  public a.bb[] Zgr = a.bb.ikW();
  public int Zgs = 0;
  public int[] Zgt = g.bZR;
  public a.q[] Zgu = a.q.ikN();
  public int Zgv = 0;
  public int Zgw = 0;
  public a.q[] Zgx = a.q.ikN();
  public int Zgy = 0;
  public int Zgz = 0;
  public String groupId = "";
  public int xbJ = 0;
  
  public a$ac()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int m = 0;
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
    Object localObject;
    if (this.Zgq != null)
    {
      j = i;
      if (this.Zgq.length > 0)
      {
        j = 0;
        while (j < this.Zgq.length)
        {
          localObject = this.Zgq[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(4, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Zgp != null)
    {
      i = j;
      if (this.Zgp.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Zgp.length)
        {
          localObject = this.Zgp[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(5, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.ZfE != null) {
      j = i + b.b(6, this.ZfE);
    }
    i = j;
    if (this.Zgs != 0) {
      i = j + b.bM(7, this.Zgs);
    }
    j = i;
    if (this.Zgt != null)
    {
      j = i;
      if (this.Zgt.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Zgt.length)
        {
          k += b.gM(this.Zgt[j]);
          j += 1;
        }
        j = i + k + this.Zgt.length * 1;
      }
    }
    i = j;
    if (this.xbJ != 0) {
      i = j + b.bM(9, this.xbJ);
    }
    j = i;
    if (this.Zgr != null)
    {
      j = i;
      if (this.Zgr.length > 0)
      {
        j = 0;
        while (j < this.Zgr.length)
        {
          localObject = this.Zgr[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(10, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.ZeS != null) {
      k = j + b.b(11, this.ZeS);
    }
    i = k;
    if (this.Zfw != 0) {
      i = k + b.bN(12, this.Zfw);
    }
    j = i;
    if (this.Zgu != null)
    {
      j = i;
      if (this.Zgu.length > 0)
      {
        j = 0;
        while (j < this.Zgu.length)
        {
          localObject = this.Zgu[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(13, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Zgx != null)
    {
      i = j;
      if (this.Zgx.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Zgx.length)
        {
          localObject = this.Zgx[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Zgy != 0) {
      j = i + b.bM(15, this.Zgy);
    }
    i = j;
    if (this.Zgz != 0) {
      i = j + b.bM(16, this.Zgz);
    }
    j = i;
    if (this.ZgA != 0) {
      j = i + b.bM(17, this.ZgA);
    }
    k = j;
    if (!Arrays.equals(this.ZgB, g.ccX)) {
      k = j + b.c(18, this.ZgB);
    }
    i = k;
    if (this.SoO != -1) {
      i = k + b.bM(19, this.SoO);
    }
    j = i;
    if (this.ZgC != null)
    {
      j = i;
      if (this.ZgC.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ZgC.length)
        {
          k += b.gR(this.ZgC[j]);
          j += 1;
        }
        j = i + k + this.ZgC.length * 2;
      }
    }
    i = j;
    if (this.ZfG != 0) {
      i = j + b.bN(21, this.ZfG);
    }
    j = i;
    if (this.Zgv != 0) {
      j = i + b.bN(100, this.Zgv);
    }
    i = j;
    if (this.Zgw != 0) {
      i = j + b.bN(101, this.Zgw);
    }
    k = i;
    if (this.ZfK != null)
    {
      k = i;
      if (this.ZfK.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.ZfK.length) {
            break;
          }
          localObject = this.ZfK[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(102, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
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
    Object localObject;
    if ((this.Zgq != null) && (this.Zgq.length > 0))
    {
      i = 0;
      while (i < this.Zgq.length)
      {
        localObject = this.Zgq[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Zgp != null) && (this.Zgp.length > 0))
    {
      i = 0;
      while (i < this.Zgp.length)
      {
        localObject = this.Zgp[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZfE != null) {
      paramb.a(6, this.ZfE);
    }
    if (this.Zgs != 0) {
      paramb.bJ(7, this.Zgs);
    }
    if ((this.Zgt != null) && (this.Zgt.length > 0))
    {
      i = 0;
      while (i < this.Zgt.length)
      {
        paramb.bJ(8, this.Zgt[i]);
        i += 1;
      }
    }
    if (this.xbJ != 0) {
      paramb.bJ(9, this.xbJ);
    }
    if ((this.Zgr != null) && (this.Zgr.length > 0))
    {
      i = 0;
      while (i < this.Zgr.length)
      {
        localObject = this.Zgr[i];
        if (localObject != null) {
          paramb.a(10, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZeS != null) {
      paramb.a(11, this.ZeS);
    }
    if (this.Zfw != 0) {
      paramb.bK(12, this.Zfw);
    }
    if ((this.Zgu != null) && (this.Zgu.length > 0))
    {
      i = 0;
      while (i < this.Zgu.length)
      {
        localObject = this.Zgu[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Zgx != null) && (this.Zgx.length > 0))
    {
      i = 0;
      while (i < this.Zgx.length)
      {
        localObject = this.Zgx[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zgy != 0) {
      paramb.bJ(15, this.Zgy);
    }
    if (this.Zgz != 0) {
      paramb.bJ(16, this.Zgz);
    }
    if (this.ZgA != 0) {
      paramb.bJ(17, this.ZgA);
    }
    if (!Arrays.equals(this.ZgB, g.ccX)) {
      paramb.b(18, this.ZgB);
    }
    if (this.SoO != -1) {
      paramb.bJ(19, this.SoO);
    }
    if ((this.ZgC != null) && (this.ZgC.length > 0))
    {
      i = 0;
      while (i < this.ZgC.length)
      {
        paramb.bK(20, this.ZgC[i]);
        i += 1;
      }
    }
    if (this.ZfG != 0) {
      paramb.bK(21, this.ZfG);
    }
    if (this.Zgv != 0) {
      paramb.bK(100, this.Zgv);
    }
    if (this.Zgw != 0) {
      paramb.bK(101, this.Zgw);
    }
    if ((this.ZfK != null) && (this.ZfK.length > 0))
    {
      i = j;
      while (i < this.ZfK.length)
      {
        localObject = this.ZfK[i];
        if (localObject != null) {
          paramb.a(102, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ac
 * JD-Core Version:    0.7.0.1
 */