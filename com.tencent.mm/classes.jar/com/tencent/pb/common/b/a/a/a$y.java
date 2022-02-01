package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$y
  extends e
{
  private static volatile y[] aheP;
  public String eqS = "";
  public String zZY = "";
  
  public a$y()
  {
    this.dXv = -1;
  }
  
  public static y[] jRf()
  {
    if (aheP == null) {}
    synchronized (c.dXu)
    {
      if (aheP == null) {
        aheP = new y[0];
      }
      return aheP;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.zZY.equals("")) {
      paramb.g(1, this.zZY);
    }
    if (!this.eqS.equals("")) {
      paramb.g(2, this.eqS);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.zZY.equals("")) {
      i = j + b.h(1, this.zZY);
    }
    j = i;
    if (!this.eqS.equals("")) {
      j = i + b.h(2, this.eqS);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.y
 * JD-Core Version:    0.7.0.1
 */