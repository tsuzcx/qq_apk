package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$at
  extends e
{
  private static volatile at[] ahfv;
  public int ZPI = 0;
  public int ahfw = 0;
  public int fps = 0;
  public int wTC = 0;
  
  public a$at()
  {
    this.dXv = -1;
  }
  
  public static at[] jRj()
  {
    if (ahfv == null) {}
    synchronized (c.dXu)
    {
      if (ahfv == null) {
        ahfv = new at[0];
      }
      return ahfv;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wTC != 0) {
      paramb.cF(1, this.wTC);
    }
    if (this.ahfw != 0) {
      paramb.cF(2, this.ahfw);
    }
    if (this.fps != 0) {
      paramb.cF(3, this.fps);
    }
    if (this.ZPI != 0) {
      paramb.cF(4, this.ZPI);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.wTC != 0) {
      i = j + b.cJ(1, this.wTC);
    }
    j = i;
    if (this.ahfw != 0) {
      j = i + b.cJ(2, this.ahfw);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.cJ(3, this.fps);
    }
    j = i;
    if (this.ZPI != 0) {
      j = i + b.cJ(4, this.ZPI);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.at
 * JD-Core Version:    0.7.0.1
 */