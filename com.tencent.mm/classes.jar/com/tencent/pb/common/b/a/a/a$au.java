package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$au
  extends e
{
  private static volatile au[] ImB;
  public int ImC = 0;
  public int ImD = 0;
  public byte[] ImE = g.bIZ;
  
  public a$au()
  {
    this.bIS = -1;
  }
  
  public static au[] flx()
  {
    if (ImB == null) {}
    synchronized (c.bIR)
    {
      if (ImB == null) {
        ImB = new au[0];
      }
      return ImB;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.ImC != 0) {
      paramb.by(1, this.ImC);
    }
    if (this.ImD != 0) {
      paramb.by(2, this.ImD);
    }
    if (!Arrays.equals(this.ImE, g.bIZ)) {
      paramb.b(3, this.ImE);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.ImC != 0) {
      i = j + b.bA(1, this.ImC);
    }
    j = i;
    if (this.ImD != 0) {
      j = i + b.bA(2, this.ImD);
    }
    i = j;
    if (!Arrays.equals(this.ImE, g.bIZ)) {
      i = j + b.c(3, this.ImE);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */