package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$ap
  extends e
{
  private static volatile ap[] ahfp;
  public int wTC = 0;
  
  public a$ap()
  {
    this.dXv = -1;
  }
  
  public static ap[] jRg()
  {
    if (ahfp == null) {}
    synchronized (c.dXu)
    {
      if (ahfp == null) {
        ahfp = new ap[0];
      }
      return ahfp;
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */