package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$p
  extends e
{
  private static volatile p[] MdC;
  public int MdD = 0;
  public String MdE = "";
  public int port = 0;
  
  public a$p()
  {
    this.bQO = -1;
  }
  
  public static p[] fXy()
  {
    if (MdC == null) {}
    synchronized (c.bQN)
    {
      if (MdC == null) {
        MdC = new p[0];
      }
      return MdC;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.MdD != 0) {
      paramb.by(1, this.MdD);
    }
    if (this.port != 0) {
      paramb.bx(2, this.port);
    }
    if (!this.MdE.equals("")) {
      paramb.d(3, this.MdE);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.MdD != 0) {
      i = j + b.bA(1, this.MdD);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.bz(2, this.port);
    }
    i = j;
    if (!this.MdE.equals("")) {
      i = j + b.e(3, this.MdE);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */