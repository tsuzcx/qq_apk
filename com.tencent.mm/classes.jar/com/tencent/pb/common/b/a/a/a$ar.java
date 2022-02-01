package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] LHT;
  public int GnD = 0;
  public int LHU = 0;
  public int fps = 0;
  public int oWb = 0;
  
  public a$ar()
  {
    this.bQO = -1;
  }
  
  public static ar[] fTc()
  {
    if (LHT == null) {}
    synchronized (c.bQN)
    {
      if (LHT == null) {
        LHT = new ar[0];
      }
      return LHT;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.oWb != 0) {
      paramb.bx(1, this.oWb);
    }
    if (this.LHU != 0) {
      paramb.bx(2, this.LHU);
    }
    if (this.fps != 0) {
      paramb.bx(3, this.fps);
    }
    if (this.GnD != 0) {
      paramb.bx(4, this.GnD);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.oWb != 0) {
      i = j + b.bz(1, this.oWb);
    }
    j = i;
    if (this.LHU != 0) {
      j = i + b.bz(2, this.LHU);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bz(3, this.fps);
    }
    j = i;
    if (this.GnD != 0) {
      j = i + b.bz(4, this.GnD);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */