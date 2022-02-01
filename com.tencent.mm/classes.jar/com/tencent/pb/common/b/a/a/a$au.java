package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$au
  extends e
{
  private static volatile au[] LHX;
  public int LHY = 0;
  public int LHZ = 0;
  public byte[] LIa = g.bQV;
  
  public a$au()
  {
    this.bQO = -1;
  }
  
  public static au[] fTd()
  {
    if (LHX == null) {}
    synchronized (c.bQN)
    {
      if (LHX == null) {
        LHX = new au[0];
      }
      return LHX;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.LHY != 0) {
      paramb.bx(1, this.LHY);
    }
    if (this.LHZ != 0) {
      paramb.bx(2, this.LHZ);
    }
    if (!Arrays.equals(this.LIa, g.bQV)) {
      paramb.b(3, this.LIa);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.LHY != 0) {
      i = j + b.bz(1, this.LHY);
    }
    j = i;
    if (this.LHZ != 0) {
      j = i + b.bz(2, this.LHZ);
    }
    i = j;
    if (!Arrays.equals(this.LIa, g.bQV)) {
      i = j + b.c(3, this.LIa);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */