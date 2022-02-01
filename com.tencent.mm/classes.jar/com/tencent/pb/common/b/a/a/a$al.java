package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$al
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int EsY = -1;
  public a.av JMV = null;
  public int JMX = 0;
  public a.aw JMo = null;
  public a.ay[] JNG = a.ay.fBQ();
  public a.p[] JNH = a.p.fBJ();
  public a.az[] JNI = a.az.fBR();
  public int JNJ = 0;
  public int[] JNK = g.bGB;
  public a.p[] JNL = a.p.fBJ();
  public a.p[] JNO = a.p.fBJ();
  public int JNP = 0;
  public int JNQ = 0;
  public int JNR = 0;
  public byte[] JNS = g.bGH;
  public int[] JNT = g.bGB;
  public a.ay[] JNb = a.ay.fBQ();
  public String groupId = "";
  
  public a$al()
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
    if ((this.JNI != null) && (this.JNI.length > 0))
    {
      i = 0;
      while (i < this.JNI.length)
      {
        localObject = this.JNI[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMo != null) {
      paramb.a(10, this.JMo);
    }
    if ((this.JNL != null) && (this.JNL.length > 0))
    {
      i = 0;
      while (i < this.JNL.length)
      {
        localObject = this.JNL[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.JNb != null) && (this.JNb.length > 0))
    {
      i = 0;
      while (i < this.JNb.length)
      {
        localObject = this.JNb[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
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
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JNP != 0) {
      paramb.bv(14, this.JNP);
    }
    if (this.JNQ != 0) {
      paramb.bv(15, this.JNQ);
    }
    if (this.JNR != 0) {
      paramb.bv(16, this.JNR);
    }
    if (!Arrays.equals(this.JNS, g.bGH)) {
      paramb.b(17, this.JNS);
    }
    if (this.EsY != -1) {
      paramb.bv(18, this.EsY);
    }
    if ((this.JNT != null) && (this.JNT.length > 0))
    {
      i = j;
      while (i < this.JNT.length)
      {
        paramb.bw(19, this.JNT[i]);
        i += 1;
      }
    }
    if (this.JMX != 0) {
      paramb.bw(20, this.JMX);
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
    int k = i;
    if (this.JMV != null) {
      k = i + b.b(6, this.JMV);
    }
    j = k;
    if (this.JNJ != 0) {
      j = k + b.bx(7, this.JNJ);
    }
    i = j;
    if (this.JNK != null)
    {
      i = j;
      if (this.JNK.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.JNK.length)
        {
          k += b.fI(this.JNK[i]);
          i += 1;
        }
        i = j + k + this.JNK.length * 1;
      }
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
            k = i + b.b(9, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.JMo != null) {
      i = j + b.b(10, this.JMo);
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
            k = i + b.b(11, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.JNb != null)
    {
      i = j;
      if (this.JNb.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.JNb.length)
        {
          localObject = this.JNb[j];
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
    if (this.JNO != null)
    {
      j = i;
      if (this.JNO.length > 0)
      {
        j = 0;
        while (j < this.JNO.length)
        {
          localObject = this.JNO[j];
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
    if (this.JNP != 0) {
      i = j + b.bx(14, this.JNP);
    }
    j = i;
    if (this.JNQ != 0) {
      j = i + b.bx(15, this.JNQ);
    }
    i = j;
    if (this.JNR != 0) {
      i = j + b.bx(16, this.JNR);
    }
    j = i;
    if (!Arrays.equals(this.JNS, g.bGH)) {
      j = i + b.c(17, this.JNS);
    }
    i = j;
    if (this.EsY != -1) {
      i = j + b.bx(18, this.EsY);
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
      i = j + b.by(20, this.JMX);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.al
 * JD-Core Version:    0.7.0.1
 */