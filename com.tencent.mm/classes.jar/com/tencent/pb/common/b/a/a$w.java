package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$w
  extends e
{
  private static volatile w[] wHw;
  public String wHx = "";
  public String wHy = "";
  
  public a$w()
  {
    this.aUI = -1;
  }
  
  public static w[] cOa()
  {
    if (wHw == null) {}
    synchronized (c.aUH)
    {
      if (wHw == null) {
        wHw = new w[0];
      }
      return wHw;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.wHx.equals("")) {
      paramb.d(1, this.wHx);
    }
    if (!this.wHy.equals("")) {
      paramb.d(2, this.wHy);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.wHx.equals("")) {
      i = j + b.e(1, this.wHx);
    }
    j = i;
    if (!this.wHy.equals("")) {
      j = i + b.e(2, this.wHy);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.w
 * JD-Core Version:    0.7.0.1
 */