package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ax
  extends e
{
  private static volatile ax[] JOT;
  public int ADE = 0;
  public long ADF = 0L;
  public int JMr = 0;
  public a.ay[] JNG = a.ay.fBQ();
  public String JOU = "";
  public String groupId = "";
  
  public a$ax()
  {
    this.bGA = -1;
  }
  
  public static ax[] fBP()
  {
    if (JOT == null) {}
    synchronized (c.bGz)
    {
      if (JOT == null) {
        JOT = new ax[0];
      }
      return JOT;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.ADE != 0) {
      paramb.bv(2, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(3, this.ADF);
    }
    if ((this.JNG != null) && (this.JNG.length > 0))
    {
      int i = 0;
      while (i < this.JNG.length)
      {
        a.ay localay = this.JNG[i];
        if (localay != null) {
          paramb.a(4, localay);
        }
        i += 1;
      }
    }
    if (this.JMr != 0) {
      paramb.bw(5, this.JMr);
    }
    if (!this.JOU.equals("")) {
      paramb.d(6, this.JOU);
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
    if (this.JNG != null)
    {
      j = i;
      if (this.JNG.length > 0)
      {
        j = 0;
        while (j < this.JNG.length)
        {
          a.ay localay = this.JNG[j];
          int k = i;
          if (localay != null) {
            k = i + b.b(4, localay);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.JMr != 0) {
      i = j + b.by(5, this.JMr);
    }
    j = i;
    if (!this.JOU.equals("")) {
      j = i + b.e(6, this.JOU);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ax
 * JD-Core Version:    0.7.0.1
 */