package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$au
  extends e
{
  private static volatile au[] JOl;
  public int JOm = 0;
  public int JOn = 0;
  public byte[] JOo = g.bGH;
  
  public a$au()
  {
    this.bGA = -1;
  }
  
  public static au[] fBO()
  {
    if (JOl == null) {}
    synchronized (c.bGz)
    {
      if (JOl == null) {
        JOl = new au[0];
      }
      return JOl;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.JOm != 0) {
      paramb.bv(1, this.JOm);
    }
    if (this.JOn != 0) {
      paramb.bv(2, this.JOn);
    }
    if (!Arrays.equals(this.JOo, g.bGH)) {
      paramb.b(3, this.JOo);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.JOm != 0) {
      i = j + b.bx(1, this.JOm);
    }
    j = i;
    if (this.JOn != 0) {
      j = i + b.bx(2, this.JOn);
    }
    i = j;
    if (!Arrays.equals(this.JOo, g.bGH)) {
      i = j + b.c(3, this.JOo);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */