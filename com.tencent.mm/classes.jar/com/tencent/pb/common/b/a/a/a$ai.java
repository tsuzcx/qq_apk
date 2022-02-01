package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$ai
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public a.av JMV = null;
  public a.aw JMo = null;
  public a.ay[] JNG = a.ay.fBQ();
  public a.p[] JNH = a.p.fBJ();
  public a.az[] JNI = a.az.fBR();
  public int JNJ = 0;
  public int[] JNK = g.bGB;
  public a.ay[] JNb = a.ay.fBQ();
  public String groupId = "";
  
  public a$ai()
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
    if (this.JMV != null) {
      paramb.a(5, this.JMV);
    }
    if (this.JNJ != 0) {
      paramb.bv(6, this.JNJ);
    }
    if ((this.JNK != null) && (this.JNK.length > 0))
    {
      i = 0;
      while (i < this.JNK.length)
      {
        paramb.bv(7, this.JNK[i]);
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
          paramb.a(200, (e)localObject);
        }
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
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMo != null) {
      paramb.a(202, this.JMo);
    }
    if ((this.JNb != null) && (this.JNb.length > 0))
    {
      i = j;
      while (i < this.JNb.length)
      {
        localObject = this.JNb[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
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
    if (this.JMV != null) {
      i = j + b.b(5, this.JMV);
    }
    j = i;
    if (this.JNJ != 0) {
      j = i + b.bx(6, this.JNJ);
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
    if (this.JNG != null)
    {
      j = i;
      if (this.JNG.length > 0)
      {
        j = 0;
        while (j < this.JNG.length)
        {
          localObject = this.JNG[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(200, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.JNI != null)
    {
      k = j;
      if (this.JNI.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.JNI.length)
        {
          localObject = this.JNI[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(201, (e)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (this.JMo != null) {
      i = k + b.b(202, this.JMo);
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
            k = i + b.b(203, (e)localObject);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ai
 * JD-Core Version:    0.7.0.1
 */