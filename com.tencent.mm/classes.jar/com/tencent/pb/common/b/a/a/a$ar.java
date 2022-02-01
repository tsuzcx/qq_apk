package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] JOh;
  public int EFp = 0;
  public int JOi = 0;
  public int fps = 0;
  public int osF = 0;
  
  public a$ar()
  {
    this.bGA = -1;
  }
  
  public static ar[] fBN()
  {
    if (JOh == null) {}
    synchronized (c.bGz)
    {
      if (JOh == null) {
        JOh = new ar[0];
      }
      return JOh;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.osF != 0) {
      paramb.bv(1, this.osF);
    }
    if (this.JOi != 0) {
      paramb.bv(2, this.JOi);
    }
    if (this.fps != 0) {
      paramb.bv(3, this.fps);
    }
    if (this.EFp != 0) {
      paramb.bv(4, this.EFp);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.osF != 0) {
      i = j + b.bx(1, this.osF);
    }
    j = i;
    if (this.JOi != 0) {
      j = i + b.bx(2, this.JOi);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bx(3, this.fps);
    }
    j = i;
    if (this.EFp != 0) {
      j = i + b.bx(4, this.EFp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */