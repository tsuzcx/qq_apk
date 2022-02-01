package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$q
  extends e
{
  private static volatile q[] Zfy;
  public String ZfA = "";
  public int Zfz = 0;
  public int port = 0;
  
  public a$q()
  {
    this.ccR = -1;
  }
  
  public static q[] ikN()
  {
    if (Zfy == null) {}
    synchronized (c.ccQ)
    {
      if (Zfy == null) {
        Zfy = new q[0];
      }
      return Zfy;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.Zfz != 0) {
      i = j + b.bN(1, this.Zfz);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.bM(2, this.port);
    }
    i = j;
    if (!this.ZfA.equals("")) {
      i = j + b.g(3, this.ZfA);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.Zfz != 0) {
      paramb.bK(1, this.Zfz);
    }
    if (this.port != 0) {
      paramb.bJ(2, this.port);
    }
    if (!this.ZfA.equals("")) {
      paramb.f(3, this.ZfA);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */