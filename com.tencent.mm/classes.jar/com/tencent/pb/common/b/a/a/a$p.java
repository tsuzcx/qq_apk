package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$p
  extends e
{
  private static volatile p[] Zfv;
  public int Zfw = 0;
  public int Zfx = 0;
  public byte[] fJr = g.ccX;
  
  public a$p()
  {
    this.ccR = -1;
  }
  
  public static p[] ikM()
  {
    if (Zfv == null) {}
    synchronized (c.ccQ)
    {
      if (Zfv == null) {
        Zfv = new p[0];
      }
      return Zfv;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.Zfw != 0) {
      i = j + b.bM(1, this.Zfw);
    }
    j = i;
    if (!Arrays.equals(this.fJr, g.ccX)) {
      j = i + b.c(2, this.fJr);
    }
    i = j;
    if (this.Zfx != 0) {
      i = j + b.bN(3, this.Zfx);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.Zfw != 0) {
      paramb.bJ(1, this.Zfw);
    }
    if (!Arrays.equals(this.fJr, g.ccX)) {
      paramb.b(2, this.fJr);
    }
    if (this.Zfx != 0) {
      paramb.bK(3, this.Zfx);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */