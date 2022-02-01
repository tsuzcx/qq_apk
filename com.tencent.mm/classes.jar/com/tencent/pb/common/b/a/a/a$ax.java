package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ax
  extends e
{
  private static volatile ax[] RFt;
  public int RFu = 0;
  public int RFv = 0;
  public byte[] RFw = g.cbu;
  
  public a$ax()
  {
    this.cbo = -1;
  }
  
  public static ax[] hjj()
  {
    if (RFt == null) {}
    synchronized (c.cbn)
    {
      if (RFt == null) {
        RFt = new ax[0];
      }
      return RFt;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.RFu != 0) {
      i = j + b.bu(1, this.RFu);
    }
    j = i;
    if (this.RFv != 0) {
      j = i + b.bu(2, this.RFv);
    }
    i = j;
    if (!Arrays.equals(this.RFw, g.cbu)) {
      i = j + b.c(3, this.RFw);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.RFu != 0) {
      paramb.bs(1, this.RFu);
    }
    if (this.RFv != 0) {
      paramb.bs(2, this.RFv);
    }
    if (!Arrays.equals(this.RFw, g.cbu)) {
      paramb.b(3, this.RFw);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ax
 * JD-Core Version:    0.7.0.1
 */