package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$p
  extends e
{
  private static volatile p[] Ile;
  public int Ilf = 0;
  public String Ilg = "";
  public int port = 0;
  
  public a$p()
  {
    this.bIS = -1;
  }
  
  public static p[] fls()
  {
    if (Ile == null) {}
    synchronized (c.bIR)
    {
      if (Ile == null) {
        Ile = new p[0];
      }
      return Ile;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Ilf != 0) {
      paramb.bz(1, this.Ilf);
    }
    if (this.port != 0) {
      paramb.by(2, this.port);
    }
    if (!this.Ilg.equals("")) {
      paramb.d(3, this.Ilg);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.Ilf != 0) {
      i = j + b.bB(1, this.Ilf);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.bA(2, this.port);
    }
    i = j;
    if (!this.Ilg.equals("")) {
      i = j + b.e(3, this.Ilg);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */