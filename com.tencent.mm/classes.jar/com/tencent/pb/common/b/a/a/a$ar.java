package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] RFk;
  public int qrD = 0;
  
  public a$ar()
  {
    this.cbo = -1;
  }
  
  public static ar[] hjg()
  {
    if (RFk == null) {}
    synchronized (c.cbn)
    {
      if (RFk == null) {
        RFk = new ar[0];
      }
      return RFk;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.qrD != 0) {
      i = j + b.bC(1, this.qrD);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.qrD != 0) {
      paramb.bB(1, this.qrD);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */