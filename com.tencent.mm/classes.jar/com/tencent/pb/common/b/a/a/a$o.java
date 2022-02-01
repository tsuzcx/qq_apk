package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$o
  extends e
{
  private static volatile o[] Ilb;
  public int Ilc = 0;
  public int Ild = 0;
  public byte[] dnS = g.bIZ;
  
  public a$o()
  {
    this.bIS = -1;
  }
  
  public static o[] flr()
  {
    if (Ilb == null) {}
    synchronized (c.bIR)
    {
      if (Ilb == null) {
        Ilb = new o[0];
      }
      return Ilb;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Ilc != 0) {
      paramb.by(1, this.Ilc);
    }
    if (!Arrays.equals(this.dnS, g.bIZ)) {
      paramb.b(2, this.dnS);
    }
    if (this.Ild != 0) {
      paramb.bz(3, this.Ild);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.Ilc != 0) {
      i = j + b.bA(1, this.Ilc);
    }
    j = i;
    if (!Arrays.equals(this.dnS, g.bIZ)) {
      j = i + b.c(2, this.dnS);
    }
    i = j;
    if (this.Ild != 0) {
      i = j + b.bB(3, this.Ild);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */