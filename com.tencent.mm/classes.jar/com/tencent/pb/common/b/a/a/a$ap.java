package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ap
  extends e
{
  private static volatile ap[] ZgO;
  public int tQm = 0;
  
  public a$ap()
  {
    this.ccR = -1;
  }
  
  public static ap[] ikP()
  {
    if (ZgO == null) {}
    synchronized (c.ccQ)
    {
      if (ZgO == null) {
        ZgO = new ap[0];
      }
      return ZgO;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.tQm != 0) {
      i = j + b.bN(1, this.tQm);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.tQm != 0) {
      paramb.bK(1, this.tQm);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */