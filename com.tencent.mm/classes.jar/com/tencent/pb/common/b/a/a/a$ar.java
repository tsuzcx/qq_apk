package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] MeX;
  public int GGJ = 0;
  public int MeY = 0;
  public int fps = 0;
  public int pcE = 0;
  
  public a$ar()
  {
    this.bQO = -1;
  }
  
  public static ar[] fXC()
  {
    if (MeX == null) {}
    synchronized (c.bQN)
    {
      if (MeX == null) {
        MeX = new ar[0];
      }
      return MeX;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.pcE != 0) {
      paramb.bx(1, this.pcE);
    }
    if (this.MeY != 0) {
      paramb.bx(2, this.MeY);
    }
    if (this.fps != 0) {
      paramb.bx(3, this.fps);
    }
    if (this.GGJ != 0) {
      paramb.bx(4, this.GGJ);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.pcE != 0) {
      i = j + b.bz(1, this.pcE);
    }
    j = i;
    if (this.MeY != 0) {
      j = i + b.bz(2, this.MeY);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bz(3, this.fps);
    }
    j = i;
    if (this.GGJ != 0) {
      j = i + b.bz(4, this.GGJ);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */