package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$ao
  extends e
{
  private static volatile ao[] BfB;
  public int BfC = 0;
  public int Bfo = 0;
  public int fps = 0;
  public int kJx = 0;
  
  public a$ao()
  {
    this.bgY = -1;
  }
  
  public static ao[] dTO()
  {
    if (BfB == null) {}
    synchronized (c.bgX)
    {
      if (BfB == null) {
        BfB = new ao[0];
      }
      return BfB;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.kJx != 0) {
      paramb.bj(1, this.kJx);
    }
    if (this.BfC != 0) {
      paramb.bj(2, this.BfC);
    }
    if (this.fps != 0) {
      paramb.bj(3, this.fps);
    }
    if (this.Bfo != 0) {
      paramb.bj(4, this.Bfo);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.kJx != 0) {
      i = j + b.bl(1, this.kJx);
    }
    j = i;
    if (this.BfC != 0) {
      j = i + b.bl(2, this.BfC);
    }
    i = j;
    if (this.fps != 0) {
      i = j + b.bl(3, this.fps);
    }
    j = i;
    if (this.Bfo != 0) {
      j = i + b.bl(4, this.Bfo);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ao
 * JD-Core Version:    0.7.0.1
 */