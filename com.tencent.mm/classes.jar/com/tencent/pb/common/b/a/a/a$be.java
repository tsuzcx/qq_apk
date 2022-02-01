package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$be
  extends e
{
  private static volatile be[] ahgM;
  public int ahgN = 0;
  public int ahgO = 0;
  public int ahgP = 0;
  public int fZW = 0;
  public int rtt = 0;
  
  public a$be()
  {
    this.dXv = -1;
  }
  
  public static be[] jRo()
  {
    if (ahgM == null) {}
    synchronized (c.dXu)
    {
      if (ahgM == null) {
        ahgM = new be[0];
      }
      return ahgM;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.fZW != 0) {
      paramb.cF(1, this.fZW);
    }
    if (this.rtt != 0) {
      paramb.cF(2, this.rtt);
    }
    if (this.ahgN != 0) {
      paramb.cF(3, this.ahgN);
    }
    if (this.ahgO != 0) {
      paramb.cF(4, this.ahgO);
    }
    if (this.ahgP != 0) {
      paramb.cF(5, this.ahgP);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.fZW != 0) {
      i = j + b.cJ(1, this.fZW);
    }
    j = i;
    if (this.rtt != 0) {
      j = i + b.cJ(2, this.rtt);
    }
    i = j;
    if (this.ahgN != 0) {
      i = j + b.cJ(3, this.ahgN);
    }
    j = i;
    if (this.ahgO != 0) {
      j = i + b.cJ(4, this.ahgO);
    }
    i = j;
    if (this.ahgP != 0) {
      i = j + b.cJ(5, this.ahgP);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */