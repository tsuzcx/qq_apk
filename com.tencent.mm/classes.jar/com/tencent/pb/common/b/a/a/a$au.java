package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$au
  extends e
{
  private static volatile au[] RFp;
  public int LGa = 0;
  public int RFq = 0;
  public int fps = 0;
  public int qrD = 0;
  
  public a$au()
  {
    this.cbo = -1;
  }
  
  public static au[] hji()
  {
    if (RFp == null) {}
    synchronized (c.cbn)
    {
      if (RFp == null) {
        RFp = new au[0];
      }
      return RFp;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.qrD != 0) {
      i = j + b.bu(1, this.qrD);
    }
    j = i;
    if (this.RFq != 0) {
      j = i + b.bu(2, this.RFq);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bu(3, this.fps);
    }
    j = i;
    if (this.LGa != 0) {
      j = i + b.bu(4, this.LGa);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.qrD != 0) {
      paramb.bs(1, this.qrD);
    }
    if (this.RFq != 0) {
      paramb.bs(2, this.RFq);
    }
    if (this.fps != 0) {
      paramb.bs(3, this.fps);
    }
    if (this.LGa != 0) {
      paramb.bs(4, this.LGa);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */