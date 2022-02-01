package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] Imx;
  public int DlI = 0;
  public int Imy = 0;
  public int fps = 0;
  public int nPB = 0;
  
  public a$ar()
  {
    this.bIS = -1;
  }
  
  public static ar[] flw()
  {
    if (Imx == null) {}
    synchronized (c.bIR)
    {
      if (Imx == null) {
        Imx = new ar[0];
      }
      return Imx;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.nPB != 0) {
      paramb.by(1, this.nPB);
    }
    if (this.Imy != 0) {
      paramb.by(2, this.Imy);
    }
    if (this.fps != 0) {
      paramb.by(3, this.fps);
    }
    if (this.DlI != 0) {
      paramb.by(4, this.DlI);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.nPB != 0) {
      i = j + b.bA(1, this.nPB);
    }
    j = i;
    if (this.Imy != 0) {
      j = i + b.bA(2, this.Imy);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bA(3, this.fps);
    }
    j = i;
    if (this.DlI != 0) {
      j = i + b.bA(4, this.DlI);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */