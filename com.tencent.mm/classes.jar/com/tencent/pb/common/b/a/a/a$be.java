package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$be
  extends e
{
  private static volatile be[] Zil;
  public int Zim = 0;
  public int Zin = 0;
  public int Zio = 0;
  public int dXr = 0;
  public int rtt = 0;
  
  public a$be()
  {
    this.ccR = -1;
  }
  
  public static be[] ikX()
  {
    if (Zil == null) {}
    synchronized (c.ccQ)
    {
      if (Zil == null) {
        Zil = new be[0];
      }
      return Zil;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.dXr != 0) {
      i = j + b.bM(1, this.dXr);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.bM(2, this.rtt);
    }
    i = j;
    if (this.Zim != 0) {
      i = j + b.bM(3, this.Zim);
    }
    j = i;
    if (this.Zin != 0) {
      j = i + b.bM(4, this.Zin);
    }
    i = j;
    if (this.Zio != 0) {
      i = j + b.bM(5, this.Zio);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.dXr != 0) {
      paramb.bJ(1, this.dXr);
    }
    if (this.rtt != 0) {
      paramb.bJ(2, this.rtt);
    }
    if (this.Zim != 0) {
      paramb.bJ(3, this.Zim);
    }
    if (this.Zin != 0) {
      paramb.bJ(4, this.Zin);
    }
    if (this.Zio != 0) {
      paramb.bJ(5, this.Zio);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */