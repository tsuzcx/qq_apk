package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$q
  extends e
{
  private static volatile q[] RDS;
  public int RDT = 0;
  public String RDU = "";
  public int port = 0;
  
  public a$q()
  {
    this.cbo = -1;
  }
  
  public static q[] hjd()
  {
    if (RDS == null) {}
    synchronized (c.cbn)
    {
      if (RDS == null) {
        RDS = new q[0];
      }
      return RDS;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.RDT != 0) {
      i = j + b.bC(1, this.RDT);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.bu(2, this.port);
    }
    i = j;
    if (!this.RDU.equals("")) {
      i = j + b.f(3, this.RDU);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.RDT != 0) {
      paramb.bB(1, this.RDT);
    }
    if (this.port != 0) {
      paramb.bs(2, this.port);
    }
    if (!this.RDU.equals("")) {
      paramb.e(3, this.RDU);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */