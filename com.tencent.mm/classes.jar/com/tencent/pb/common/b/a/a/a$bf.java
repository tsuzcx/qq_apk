package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$bf
  extends e
{
  private static volatile bf[] RGF;
  public int RGG = 0;
  public int RGH = 0;
  public int RGI = 0;
  public int qwL = 0;
  public int rtt = 0;
  
  public a$bf()
  {
    this.cbo = -1;
  }
  
  public static bf[] hjn()
  {
    if (RGF == null) {}
    synchronized (c.cbn)
    {
      if (RGF == null) {
        RGF = new bf[0];
      }
      return RGF;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.qwL != 0) {
      i = j + b.bu(1, this.qwL);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.bu(2, this.rtt);
    }
    i = j;
    if (this.RGG != 0) {
      i = j + b.bu(3, this.RGG);
    }
    j = i;
    if (this.RGH != 0) {
      j = i + b.bu(4, this.RGH);
    }
    i = j;
    if (this.RGI != 0) {
      i = j + b.bu(5, this.RGI);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.qwL != 0) {
      paramb.bs(1, this.qwL);
    }
    if (this.rtt != 0) {
      paramb.bs(2, this.rtt);
    }
    if (this.RGG != 0) {
      paramb.bs(3, this.RGG);
    }
    if (this.RGH != 0) {
      paramb.bs(4, this.RGH);
    }
    if (this.RGI != 0) {
      paramb.bs(5, this.RGI);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bf
 * JD-Core Version:    0.7.0.1
 */