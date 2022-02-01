package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$p
  extends e
{
  private static volatile p[] RDP;
  public int RDQ = 0;
  public int RDR = 0;
  public byte[] dQa = g.cbu;
  
  public a$p()
  {
    this.cbo = -1;
  }
  
  public static p[] hjc()
  {
    if (RDP == null) {}
    synchronized (c.cbn)
    {
      if (RDP == null) {
        RDP = new p[0];
      }
      return RDP;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.RDQ != 0) {
      i = j + b.bu(1, this.RDQ);
    }
    j = i;
    if (!Arrays.equals(this.dQa, g.cbu)) {
      j = i + b.c(2, this.dQa);
    }
    i = j;
    if (this.RDR != 0) {
      i = j + b.bC(3, this.RDR);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.RDQ != 0) {
      paramb.bs(1, this.RDQ);
    }
    if (!Arrays.equals(this.dQa, g.cbu)) {
      paramb.b(2, this.dQa);
    }
    if (this.RDR != 0) {
      paramb.bB(3, this.RDR);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */