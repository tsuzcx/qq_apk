package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$p
  extends e
{
  private static volatile p[] LGy;
  public String LGA = "";
  public int LGz = 0;
  public int port = 0;
  
  public a$p()
  {
    this.bQO = -1;
  }
  
  public static p[] fSY()
  {
    if (LGy == null) {}
    synchronized (c.bQN)
    {
      if (LGy == null) {
        LGy = new p[0];
      }
      return LGy;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.LGz != 0) {
      paramb.by(1, this.LGz);
    }
    if (this.port != 0) {
      paramb.bx(2, this.port);
    }
    if (!this.LGA.equals("")) {
      paramb.d(3, this.LGA);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.LGz != 0) {
      i = j + b.bA(1, this.LGz);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.bz(2, this.port);
    }
    i = j;
    if (!this.LGA.equals("")) {
      i = j + b.e(3, this.LGA);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */