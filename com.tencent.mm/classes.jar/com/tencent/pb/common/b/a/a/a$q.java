package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$q
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JMS = 0;
  public a.az[] JMT = a.az.fBR();
  public a.ay[] JMU = a.ay.fBQ();
  public a.av JMV = null;
  public int JMW = 0;
  public int JMX = 0;
  public int JMY = 0;
  public byte[] JMZ = g.bGH;
  public a.aw JMo = null;
  public int JMr = 0;
  public a.bb JMt = null;
  public byte[] JNa = g.bGH;
  public a.ay[] JNb = a.ay.fBQ();
  public int audioStreamType = 0;
  public String groupId = "";
  public int hTM = 0;
  public long msgId = 0L;
  
  public a$q()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.JMS != 0) {
      paramb.bv(1, this.JMS);
    }
    if (!this.groupId.equals("")) {
      paramb.d(2, this.groupId);
    }
    if (this.ADE != 0) {
      paramb.bv(3, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(4, this.ADF);
    }
    if (this.JMr != 0) {
      paramb.bw(5, this.JMr);
    }
    if (this.JMo != null) {
      paramb.a(6, this.JMo);
    }
    int i;
    Object localObject;
    if ((this.JMT != null) && (this.JMT.length > 0))
    {
      i = 0;
      while (i < this.JMT.length)
      {
        localObject = this.JMT[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.JMU != null) && (this.JMU.length > 0))
    {
      i = 0;
      while (i < this.JMU.length)
      {
        localObject = this.JMU[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMV != null) {
      paramb.a(9, this.JMV);
    }
    if (this.JMt != null) {
      paramb.a(10, this.JMt);
    }
    if (this.JMW != 0) {
      paramb.bw(11, this.JMW);
    }
    if (this.JMX != 0) {
      paramb.bw(12, this.JMX);
    }
    if (this.hTM != 0) {
      paramb.bw(13, this.hTM);
    }
    if (this.msgId != 0L) {
      paramb.m(101, this.msgId);
    }
    if (this.JMY != 0) {
      paramb.bw(102, this.JMY);
    }
    if (!Arrays.equals(this.JMZ, g.bGH)) {
      paramb.b(103, this.JMZ);
    }
    if (!Arrays.equals(this.JNa, g.bGH)) {
      paramb.b(200, this.JNa);
    }
    if ((this.JNb != null) && (this.JNb.length > 0))
    {
      i = j;
      while (i < this.JNb.length)
      {
        localObject = this.JNb[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.audioStreamType != 0) {
      paramb.bv(202, this.audioStreamType);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int m = 0;
    int j = super.xT();
    int i = j;
    if (this.JMS != 0) {
      i = j + b.bx(1, this.JMS);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.e(2, this.groupId);
    }
    i = j;
    if (this.ADE != 0) {
      i = j + b.bx(3, this.ADE);
    }
    j = i;
    if (this.ADF != 0L) {
      j = i + b.p(4, this.ADF);
    }
    int k = j;
    if (this.JMr != 0) {
      k = j + b.by(5, this.JMr);
    }
    i = k;
    if (this.JMo != null) {
      i = k + b.b(6, this.JMo);
    }
    j = i;
    Object localObject;
    if (this.JMT != null)
    {
      j = i;
      if (this.JMT.length > 0)
      {
        j = 0;
        while (j < this.JMT.length)
        {
          localObject = this.JMT[j];
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
    if (this.JMU != null)
    {
      i = j;
      if (this.JMU.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.JMU.length)
        {
          localObject = this.JMU[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(8, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.JMV != null) {
      j = i + b.b(9, this.JMV);
    }
    i = j;
    if (this.JMt != null) {
      i = j + b.b(10, this.JMt);
    }
    j = i;
    if (this.JMW != 0) {
      j = i + b.by(11, this.JMW);
    }
    i = j;
    if (this.JMX != 0) {
      i = j + b.by(12, this.JMX);
    }
    j = i;
    if (this.hTM != 0) {
      j = i + b.by(13, this.hTM);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.o(101, this.msgId);
    }
    j = i;
    if (this.JMY != 0) {
      j = i + b.by(102, this.JMY);
    }
    k = j;
    if (!Arrays.equals(this.JMZ, g.bGH)) {
      k = j + b.c(103, this.JMZ);
    }
    i = k;
    if (!Arrays.equals(this.JNa, g.bGH)) {
      i = k + b.c(200, this.JNa);
    }
    j = i;
    if (this.JNb != null)
    {
      j = i;
      if (this.JNb.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.JNb.length) {
            break;
          }
          localObject = this.JNb[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(201, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.audioStreamType != 0) {
      i = j + b.bx(202, this.audioStreamType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */