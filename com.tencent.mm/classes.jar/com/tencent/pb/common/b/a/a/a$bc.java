package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$bc
  extends e
{
  private static volatile bc[] InN;
  public int InO = 0;
  public int InP = 0;
  public int InQ = 0;
  public int nUh = 0;
  public int rtt = 0;
  
  public a$bc()
  {
    this.bIS = -1;
  }
  
  public static bc[] flB()
  {
    if (InN == null) {}
    synchronized (c.bIR)
    {
      if (InN == null) {
        InN = new bc[0];
      }
      return InN;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.nUh != 0) {
      paramb.by(1, this.nUh);
    }
    if (this.rtt != 0) {
      paramb.by(2, this.rtt);
    }
    if (this.InO != 0) {
      paramb.by(3, this.InO);
    }
    if (this.InP != 0) {
      paramb.by(4, this.InP);
    }
    if (this.InQ != 0) {
      paramb.by(5, this.InQ);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.nUh != 0) {
      i = j + b.bA(1, this.nUh);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.bA(2, this.rtt);
    }
    i = j;
    if (this.InO != 0) {
      i = j + b.bA(3, this.InO);
    }
    j = i;
    if (this.InP != 0) {
      j = i + b.bA(4, this.InP);
    }
    i = j;
    if (this.InQ != 0) {
      i = j + b.bA(5, this.InQ);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bc
 * JD-Core Version:    0.7.0.1
 */