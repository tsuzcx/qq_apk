package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$aq
  extends e
{
  private static volatile aq[] ahfq;
  public int wTC = 0;
  
  public a$aq()
  {
    this.dXv = -1;
  }
  
  public static aq[] jRh()
  {
    if (ahfq == null) {}
    synchronized (c.dXu)
    {
      if (ahfq == null) {
        ahfq = new aq[0];
      }
      return ahfq;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wTC != 0) {
      paramb.cG(1, this.wTC);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.wTC != 0) {
      i = j + b.cK(1, this.wTC);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aq
 * JD-Core Version:    0.7.0.1
 */