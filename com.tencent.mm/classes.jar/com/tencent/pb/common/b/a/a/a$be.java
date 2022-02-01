package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$be
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JMr = 0;
  public a.ay[] JNG = a.ay.fBQ();
  public String JOU = "";
  public int JPC = 0;
  public String JPD = "";
  public String[] JPE = g.EMPTY_STRING_ARRAY;
  public long JPF = 0L;
  public String groupId = "";
  
  public a$be()
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
    if (this.JMr != 0) {
      paramb.bw(4, this.JMr);
    }
    if (this.JPC != 0) {
      paramb.bv(5, this.JPC);
    }
    if (!this.JOU.equals("")) {
      paramb.d(6, this.JOU);
    }
    int i;
    Object localObject;
    if ((this.JNG != null) && (this.JNG.length > 0))
    {
      i = 0;
      while (i < this.JNG.length)
      {
        localObject = this.JNG[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.JPD.equals("")) {
      paramb.d(8, this.JPD);
    }
    if ((this.JPE != null) && (this.JPE.length > 0))
    {
      i = j;
      while (i < this.JPE.length)
      {
        localObject = this.JPE[i];
        if (localObject != null) {
          paramb.d(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.JPF != 0L) {
      paramb.m(10, this.JPF);
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
    if (this.JMr != 0) {
      j = i + b.by(4, this.JMr);
    }
    int k = j;
    if (this.JPC != 0) {
      k = j + b.bx(5, this.JPC);
    }
    i = k;
    if (!this.JOU.equals("")) {
      i = k + b.e(6, this.JOU);
    }
    j = i;
    Object localObject;
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
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!this.JPD.equals("")) {
      i = j + b.e(8, this.JPD);
    }
    j = i;
    if (this.JPE != null)
    {
      j = i;
      if (this.JPE.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.JPE.length; m = n)
        {
          localObject = this.JPE[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.bj((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.JPF != 0L) {
      i = j + b.o(10, this.JPF);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */