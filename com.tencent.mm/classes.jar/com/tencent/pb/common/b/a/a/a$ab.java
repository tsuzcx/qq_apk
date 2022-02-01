package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int SoO = -1;
  public String ZeQ = "";
  public a.ay ZeS = null;
  public int ZeV = 0;
  public a.ba[] ZfD = a.ba.ikV();
  public a.ax ZfE = null;
  public int ZfG = 0;
  public a.ba[] ZfK = a.ba.ikV();
  public int Zfw = 0;
  public int ZgA = 0;
  public byte[] ZgB = g.ccX;
  public int[] ZgC = g.bZR;
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
  
  public a$ab()
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
    int k = j;
    if (this.NOd != 0L) {
      k = j + b.p(3, this.NOd);
    }
    i = k;
    if (this.ZeV != 0) {
      i = k + b.bN(4, this.ZeV);
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
            k = i + b.b(5, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Zgr != null)
    {
      i = j;
      if (this.Zgr.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Zgr.length)
        {
          localObject = this.Zgr[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(6, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.ZfE != null) {
      j = i + b.b(7, this.ZfE);
    }
    i = j;
    if (!this.ZeQ.equals("")) {
      i = j + b.g(8, this.ZeQ);
    }
    j = i;
    if (this.ZfD != null)
    {
      j = i;
      if (this.ZfD.length > 0)
      {
        j = 0;
        while (j < this.ZfD.length)
        {
          localObject = this.ZfD[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(9, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Zgs != 0) {
      i = j + b.bM(10, this.Zgs);
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
    k = j;
    if (this.ZeS != null) {
      k = j + b.b(12, this.ZeS);
    }
    i = k;
    if (this.Zfw != 0) {
      i = k + b.bN(13, this.Zfw);
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
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    k = j;
    if (this.Zgv != 0) {
      k = j + b.bN(15, this.Zgv);
    }
    i = k;
    if (this.Zgw != 0) {
      i = k + b.bN(16, this.Zgw);
    }
    j = i;
    if (this.ZfK != null)
    {
      j = i;
      if (this.ZfK.length > 0)
      {
        j = 0;
        while (j < this.ZfK.length)
        {
          localObject = this.ZfK[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(17, (e)localObject);
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
            k = i + b.b(18, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Zgy != 0) {
      j = i + b.bM(19, this.Zgy);
    }
    i = j;
    if (this.Zgz != 0) {
      i = j + b.bM(20, this.Zgz);
    }
    j = i;
    if (this.ZgA != 0) {
      j = i + b.bM(21, this.ZgA);
    }
    k = j;
    if (!Arrays.equals(this.ZgB, g.ccX)) {
      k = j + b.c(22, this.ZgB);
    }
    i = k;
    if (this.SoO != -1) {
      i = k + b.bM(23, this.SoO);
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
      i = j + b.bN(25, this.ZfG);
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
    if (this.ZeV != 0) {
      paramb.bK(4, this.ZeV);
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
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Zgr != null) && (this.Zgr.length > 0))
    {
      i = 0;
      while (i < this.Zgr.length)
      {
        localObject = this.Zgr[i];
        if (localObject != null) {
          paramb.a(6, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZfE != null) {
      paramb.a(7, this.ZfE);
    }
    if (!this.ZeQ.equals("")) {
      paramb.f(8, this.ZeQ);
    }
    if ((this.ZfD != null) && (this.ZfD.length > 0))
    {
      i = 0;
      while (i < this.ZfD.length)
      {
        localObject = this.ZfD[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zgs != 0) {
      paramb.bJ(10, this.Zgs);
    }
    if ((this.Zgt != null) && (this.Zgt.length > 0))
    {
      i = 0;
      while (i < this.Zgt.length)
      {
        paramb.bJ(11, this.Zgt[i]);
        i += 1;
      }
    }
    if (this.ZeS != null) {
      paramb.a(12, this.ZeS);
    }
    if (this.Zfw != 0) {
      paramb.bK(13, this.Zfw);
    }
    if ((this.Zgu != null) && (this.Zgu.length > 0))
    {
      i = 0;
      while (i < this.Zgu.length)
      {
        localObject = this.Zgu[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zgv != 0) {
      paramb.bK(15, this.Zgv);
    }
    if (this.Zgw != 0) {
      paramb.bK(16, this.Zgw);
    }
    if ((this.ZfK != null) && (this.ZfK.length > 0))
    {
      i = 0;
      while (i < this.ZfK.length)
      {
        localObject = this.ZfK[i];
        if (localObject != null) {
          paramb.a(17, (e)localObject);
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
          paramb.a(18, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zgy != 0) {
      paramb.bJ(19, this.Zgy);
    }
    if (this.Zgz != 0) {
      paramb.bJ(20, this.Zgz);
    }
    if (this.ZgA != 0) {
      paramb.bJ(21, this.ZgA);
    }
    if (!Arrays.equals(this.ZgB, g.ccX)) {
      paramb.b(22, this.ZgB);
    }
    if (this.SoO != -1) {
      paramb.bJ(23, this.SoO);
    }
    if ((this.ZgC != null) && (this.ZgC.length > 0))
    {
      i = j;
      while (i < this.ZgC.length)
      {
        paramb.bK(24, this.ZgC[i]);
        i += 1;
      }
    }
    if (this.ZfG != 0) {
      paramb.bK(25, this.ZfG);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */