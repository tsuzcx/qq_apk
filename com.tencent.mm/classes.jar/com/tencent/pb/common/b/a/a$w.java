package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$w
  extends e
{
  private static volatile w[] BeW;
  public String BeX = "";
  public String BeY = "";
  
  public a$w()
  {
    this.bgY = -1;
  }
  
  public static w[] dTM()
  {
    if (BeW == null) {}
    synchronized (c.bgX)
    {
      if (BeW == null) {
        BeW = new w[0];
      }
      return BeW;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.BeX.equals("")) {
      paramb.e(1, this.BeX);
    }
    if (!this.BeY.equals("")) {
      paramb.e(2, this.BeY);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.BeX.equals("")) {
      i = j + b.f(1, this.BeX);
    }
    j = i;
    if (!this.BeY.equals("")) {
      j = i + b.f(2, this.BeY);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.w
 * JD-Core Version:    0.7.0.1
 */