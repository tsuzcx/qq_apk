package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$at
  extends e
{
  private static volatile at[] ZgU;
  public int SKL = 0;
  public int ZgV = 0;
  public int fps = 0;
  public int tQm = 0;
  
  public a$at()
  {
    this.ccR = -1;
  }
  
  public static at[] ikS()
  {
    if (ZgU == null) {}
    synchronized (c.ccQ)
    {
      if (ZgU == null) {
        ZgU = new at[0];
      }
      return ZgU;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.tQm != 0) {
      i = j + b.bM(1, this.tQm);
    }
    j = i;
    if (this.ZgV != 0) {
      j = i + b.bM(2, this.ZgV);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bM(3, this.fps);
    }
    j = i;
    if (this.SKL != 0) {
      j = i + b.bM(4, this.SKL);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.tQm != 0) {
      paramb.bJ(1, this.tQm);
    }
    if (this.ZgV != 0) {
      paramb.bJ(2, this.ZgV);
    }
    if (this.fps != 0) {
      paramb.bJ(3, this.fps);
    }
    if (this.SKL != 0) {
      paramb.bJ(4, this.SKL);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.at
 * JD-Core Version:    0.7.0.1
 */