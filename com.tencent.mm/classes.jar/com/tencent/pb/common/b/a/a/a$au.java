package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$au
  extends e
{
  private static volatile au[] Mfb;
  public int Mfc = 0;
  public int Mfd = 0;
  public byte[] Mfe = g.bQV;
  
  public a$au()
  {
    this.bQO = -1;
  }
  
  public static au[] fXD()
  {
    if (Mfb == null) {}
    synchronized (c.bQN)
    {
      if (Mfb == null) {
        Mfb = new au[0];
      }
      return Mfb;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Mfc != 0) {
      paramb.bx(1, this.Mfc);
    }
    if (this.Mfd != 0) {
      paramb.bx(2, this.Mfd);
    }
    if (!Arrays.equals(this.Mfe, g.bQV)) {
      paramb.b(3, this.Mfe);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.Mfc != 0) {
      i = j + b.bz(1, this.Mfc);
    }
    j = i;
    if (this.Mfd != 0) {
      j = i + b.bz(2, this.Mfd);
    }
    i = j;
    if (!Arrays.equals(this.Mfe, g.bQV)) {
      i = j + b.c(3, this.Mfe);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */