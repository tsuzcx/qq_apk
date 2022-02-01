package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$bc
  extends e
{
  private static volatile bc[] LJj;
  public int LJk = 0;
  public int LJl = 0;
  public int LJm = 0;
  public int paX = 0;
  public int rtt = 0;
  
  public a$bc()
  {
    this.bQO = -1;
  }
  
  public static bc[] fTh()
  {
    if (LJj == null) {}
    synchronized (c.bQN)
    {
      if (LJj == null) {
        LJj = new bc[0];
      }
      return LJj;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.paX != 0) {
      paramb.bx(1, this.paX);
    }
    if (this.rtt != 0) {
      paramb.bx(2, this.rtt);
    }
    if (this.LJk != 0) {
      paramb.bx(3, this.LJk);
    }
    if (this.LJl != 0) {
      paramb.bx(4, this.LJl);
    }
    if (this.LJm != 0) {
      paramb.bx(5, this.LJm);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.paX != 0) {
      i = j + b.bz(1, this.paX);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.bz(2, this.rtt);
    }
    i = j;
    if (this.LJk != 0) {
      i = j + b.bz(3, this.LJk);
    }
    j = i;
    if (this.LJl != 0) {
      j = i + b.bz(4, this.LJl);
    }
    i = j;
    if (this.LJm != 0) {
      i = j + b.bz(5, this.LJm);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bc
 * JD-Core Version:    0.7.0.1
 */