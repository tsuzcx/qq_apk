package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$bc
  extends e
{
  private static volatile bc[] RGz;
  public int KBb = 0;
  public long RGA = 0L;
  public String RGB = "";
  public String RGC = "";
  public String headUrl = "";
  public String username = "";
  
  public a$bc()
  {
    this.cbo = -1;
  }
  
  public static bc[] hjm()
  {
    if (RGz == null) {}
    synchronized (c.cbn)
    {
      if (RGz == null) {
        RGz = new bc[0];
      }
      return RGz;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.KBb != 0) {
      i = j + b.bC(1, this.KBb);
    }
    j = i;
    if (!this.username.equals("")) {
      j = i + b.f(2, this.username);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + b.f(3, this.headUrl);
    }
    j = i;
    if (this.RGA != 0L) {
      j = i + b.p(4, this.RGA);
    }
    i = j;
    if (!this.RGB.equals("")) {
      i = j + b.f(5, this.RGB);
    }
    j = i;
    if (!this.RGC.equals("")) {
      j = i + b.f(6, this.RGC);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.KBb != 0) {
      paramb.bB(1, this.KBb);
    }
    if (!this.username.equals("")) {
      paramb.e(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.e(3, this.headUrl);
    }
    if (this.RGA != 0L) {
      paramb.n(4, this.RGA);
    }
    if (!this.RGB.equals("")) {
      paramb.e(5, this.RGB);
    }
    if (!this.RGC.equals("")) {
      paramb.e(6, this.RGC);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bc
 * JD-Core Version:    0.7.0.1
 */