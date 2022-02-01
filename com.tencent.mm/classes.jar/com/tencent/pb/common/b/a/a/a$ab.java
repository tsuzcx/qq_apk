package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int EsY = -1;
  public int JMN = 0;
  public a.av JMV = null;
  public int JMX = 0;
  public a.aw JMo = null;
  public a.ay[] JNG = a.ay.fBQ();
  public a.p[] JNH = a.p.fBJ();
  public a.az[] JNI = a.az.fBR();
  public int JNJ = 0;
  public int[] JNK = g.bGB;
  public a.p[] JNL = a.p.fBJ();
  public int JNM = 0;
  public int JNN = 0;
  public a.p[] JNO = a.p.fBJ();
  public int JNP = 0;
  public int JNQ = 0;
  public int JNR = 0;
  public byte[] JNS = g.bGH;
  public int[] JNT = g.bGB;
  public a.ay[] JNb = a.ay.fBQ();
  public String groupId = "";
  public int urD = 0;
  
  public a$ab()
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
    Object localObject;
    if ((this.JNH != null) && (this.JNH.length > 0))
    {
      i = 0;
      while (i < this.JNH.length)
      {
        localObject = this.JNH[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.JNG != null) && (this.JNG.length > 0))
    {
      i = 0;
      while (i < this.JNG.length)
      {
        localObject = this.JNG[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMV != null) {
      paramb.a(6, this.JMV);
    }
    if (this.JNJ != 0) {
      paramb.bv(7, this.JNJ);
    }
    if ((this.JNK != null) && (this.JNK.length > 0))
    {
      i = 0;
      while (i < this.JNK.length)
      {
        paramb.bv(8, this.JNK[i]);
        i += 1;
      }
    }
    if (this.urD != 0) {
      paramb.bv(9, this.urD);
    }
    if ((this.JNI != null) && (this.JNI.length > 0))
    {
      i = 0;
      while (i < this.JNI.length)
      {
        localObject = this.JNI[i];
        if (localObject != null) {
          paramb.a(10, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMo != null) {
      paramb.a(11, this.JMo);
    }
    if (this.JMN != 0) {
      paramb.bw(12, this.JMN);
    }
    if ((this.JNL != null) && (this.JNL.length > 0))
    {
      i = 0;
      while (i < this.JNL.length)
      {
        localObject = this.JNL[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.JNO != null) && (this.JNO.length > 0))
    {
      i = 0;
      while (i < this.JNO.length)
      {
        localObject = this.JNO[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JNP != 0) {
      paramb.bv(15, this.JNP);
    }
    if (this.JNQ != 0) {
      paramb.bv(16, this.JNQ);
    }
    if (this.JNR != 0) {
      paramb.bv(17, this.JNR);
    }
    if (!Arrays.equals(this.JNS, g.bGH)) {
      paramb.b(18, this.JNS);
    }
    if (this.EsY != -1) {
      paramb.bv(19, this.EsY);
    }
    if ((this.JNT != null) && (this.JNT.length > 0))
    {
      i = 0;
      while (i < this.JNT.length)
      {
        paramb.bw(20, this.JNT[i]);
        i += 1;
      }
    }
    if (this.JMX != 0) {
      paramb.bw(21, this.JMX);
    }
    if (this.JNM != 0) {
      paramb.bw(100, this.JNM);
    }
    if (this.JNN != 0) {
      paramb.bw(101, this.JNN);
    }
    if ((this.JNb != null) && (this.JNb.length > 0))
    {
      i = j;
      while (i < this.JNb.length)
      {
        localObject = this.JNb[i];
        if (localObject != null) {
          paramb.a(102, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int m = 0;
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
    Object localObject;
    if (this.JNH != null)
    {
      j = i;
      if (this.JNH.length > 0)
      {
        j = 0;
        while (j < this.JNH.length)
        {
          localObject = this.JNH[j];
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
    if (this.JNG != null)
    {
      i = j;
      if (this.JNG.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.JNG.length)
        {
          localObject = this.JNG[j];
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
    if (this.JMV != null) {
      j = i + b.b(6, this.JMV);
    }
    i = j;
    if (this.JNJ != 0) {
      i = j + b.bx(7, this.JNJ);
    }
    j = i;
    if (this.JNK != null)
    {
      j = i;
      if (this.JNK.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.JNK.length)
        {
          k += b.fI(this.JNK[j]);
          j += 1;
        }
        j = i + k + this.JNK.length * 1;
      }
    }
    i = j;
    if (this.urD != 0) {
      i = j + b.bx(9, this.urD);
    }
    j = i;
    if (this.JNI != null)
    {
      j = i;
      if (this.JNI.length > 0)
      {
        j = 0;
        while (j < this.JNI.length)
        {
          localObject = this.JNI[j];
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
    if (this.JMo != null) {
      k = j + b.b(11, this.JMo);
    }
    i = k;
    if (this.JMN != 0) {
      i = k + b.by(12, this.JMN);
    }
    j = i;
    if (this.JNL != null)
    {
      j = i;
      if (this.JNL.length > 0)
      {
        j = 0;
        while (j < this.JNL.length)
        {
          localObject = this.JNL[j];
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
    if (this.JNO != null)
    {
      i = j;
      if (this.JNO.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.JNO.length)
        {
          localObject = this.JNO[j];
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
    if (this.JNP != 0) {
      j = i + b.bx(15, this.JNP);
    }
    i = j;
    if (this.JNQ != 0) {
      i = j + b.bx(16, this.JNQ);
    }
    j = i;
    if (this.JNR != 0) {
      j = i + b.bx(17, this.JNR);
    }
    k = j;
    if (!Arrays.equals(this.JNS, g.bGH)) {
      k = j + b.c(18, this.JNS);
    }
    i = k;
    if (this.EsY != -1) {
      i = k + b.bx(19, this.EsY);
    }
    j = i;
    if (this.JNT != null)
    {
      j = i;
      if (this.JNT.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.JNT.length)
        {
          k += b.fM(this.JNT[j]);
          j += 1;
        }
        j = i + k + this.JNT.length * 2;
      }
    }
    i = j;
    if (this.JMX != 0) {
      i = j + b.by(21, this.JMX);
    }
    j = i;
    if (this.JNM != 0) {
      j = i + b.by(100, this.JNM);
    }
    i = j;
    if (this.JNN != 0) {
      i = j + b.by(101, this.JNN);
    }
    k = i;
    if (this.JNb != null)
    {
      k = i;
      if (this.JNb.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.JNb.length) {
            break;
          }
          localObject = this.JNb[j];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */