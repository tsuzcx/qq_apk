package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$ao
  extends e
{
  private static volatile ao[] wIb;
  public int fps = 0;
  public int iEo = 0;
  public int wHO = 0;
  public int wIc = 0;
  
  public a$ao()
  {
    this.aUI = -1;
  }
  
  public static ao[] cOc()
  {
    if (wIb == null) {}
    synchronized (c.aUH)
    {
      if (wIb == null) {
        wIb = new ao[0];
      }
      return wIb;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.iEo != 0) {
      paramb.aL(1, this.iEo);
    }
    if (this.wIc != 0) {
      paramb.aL(2, this.wIc);
    }
    if (this.fps != 0) {
      paramb.aL(3, this.fps);
    }
    if (this.wHO != 0) {
      paramb.aL(4, this.wHO);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.iEo != 0) {
      i = j + b.aN(1, this.iEo);
    }
    j = i;
    if (this.wIc != 0) {
      j = i + b.aN(2, this.wIc);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.aN(3, this.fps);
    }
    j = i;
    if (this.wHO != 0) {
      j = i + b.aN(4, this.wHO);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ao
 * JD-Core Version:    0.7.0.1
 */