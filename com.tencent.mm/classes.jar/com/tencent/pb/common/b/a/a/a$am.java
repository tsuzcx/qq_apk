package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$am
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int SoO = -1;
  public a.ay ZeS = null;
  public a.ax ZfE = null;
  public int ZfG = 0;
  public a.ba[] ZfK = a.ba.ikV();
  public int ZgA = 0;
  public byte[] ZgB = g.ccX;
  public int[] ZgC = g.bZR;
  public a.ba[] Zgp = a.ba.ikV();
  public a.q[] Zgq = a.q.ikN();
  public a.bb[] Zgr = a.bb.ikW();
  public int Zgs = 0;
  public int[] Zgt = g.bZR;
  public a.q[] Zgu = a.q.ikN();
  public a.q[] Zgx = a.q.ikN();
  public int Zgy = 0;
  public int Zgz = 0;
  public String groupId = "";
  
  public a$am()
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
    int k = i;
    if (this.ZfE != null) {
      k = i + b.b(6, this.ZfE);
    }
    j = k;
    if (this.Zgs != 0) {
      j = k + b.bM(7, this.Zgs);
    }
    i = j;
    if (this.Zgt != null)
    {
      i = j;
      if (this.Zgt.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.Zgt.length)
        {
          k += b.gM(this.Zgt[i]);
          i += 1;
        }
        i = j + k + this.Zgt.length * 1;
      }
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
            k = i + b.b(9, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ZeS != null) {
      i = j + b.b(10, this.ZeS);
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
            k = i + b.b(11, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ZfK != null)
    {
      i = j;
      if (this.ZfK.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.ZfK.length)
        {
          localObject = this.ZfK[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(12, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Zgx != null)
    {
      j = i;
      if (this.Zgx.length > 0)
      {
        j = 0;
        while (j < this.Zgx.length)
        {
          localObject = this.Zgx[j];
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
    if (this.Zgy != 0) {
      i = j + b.bM(14, this.Zgy);
    }
    j = i;
    if (this.Zgz != 0) {
      j = i + b.bM(15, this.Zgz);
    }
    i = j;
    if (this.ZgA != 0) {
      i = j + b.bM(16, this.ZgA);
    }
    j = i;
    if (!Arrays.equals(this.ZgB, g.ccX)) {
      j = i + b.c(17, this.ZgB);
    }
    i = j;
    if (this.SoO != -1) {
      i = j + b.bM(18, this.SoO);
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
      i = j + b.bN(20, this.ZfG);
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
    if ((this.Zgr != null) && (this.Zgr.length > 0))
    {
      i = 0;
      while (i < this.Zgr.length)
      {
        localObject = this.Zgr[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ZeS != null) {
      paramb.a(10, this.ZeS);
    }
    if ((this.Zgu != null) && (this.Zgu.length > 0))
    {
      i = 0;
      while (i < this.Zgu.length)
      {
        localObject = this.Zgu[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.ZfK != null) && (this.ZfK.length > 0))
    {
      i = 0;
      while (i < this.ZfK.length)
      {
        localObject = this.ZfK[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
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
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zgy != 0) {
      paramb.bJ(14, this.Zgy);
    }
    if (this.Zgz != 0) {
      paramb.bJ(15, this.Zgz);
    }
    if (this.ZgA != 0) {
      paramb.bJ(16, this.ZgA);
    }
    if (!Arrays.equals(this.ZgB, g.ccX)) {
      paramb.b(17, this.ZgB);
    }
    if (this.SoO != -1) {
      paramb.bJ(18, this.SoO);
    }
    if ((this.ZgC != null) && (this.ZgC.length > 0))
    {
      i = j;
      while (i < this.ZgC.length)
      {
        paramb.bK(19, this.ZgC[i]);
        i += 1;
      }
    }
    if (this.ZfG != 0) {
      paramb.bK(20, this.ZfG);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.am
 * JD-Core Version:    0.7.0.1
 */