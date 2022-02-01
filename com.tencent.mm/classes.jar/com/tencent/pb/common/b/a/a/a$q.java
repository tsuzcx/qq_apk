package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$q
  extends e
{
  private static volatile q[] aheb;
  public int ahec = 0;
  public String ahed = "";
  public int port = 0;
  
  public a$q()
  {
    this.dXv = -1;
  }
  
  public static q[] jRe()
  {
    if (aheb == null) {}
    synchronized (c.dXu)
    {
      if (aheb == null) {
        aheb = new q[0];
      }
      return aheb;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.ahec != 0) {
      paramb.cG(1, this.ahec);
    }
    if (this.port != 0) {
      paramb.cF(2, this.port);
    }
    if (!this.ahed.equals("")) {
      paramb.g(3, this.ahed);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.ahec != 0) {
      i = j + b.cK(1, this.ahec);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.cJ(2, this.port);
    }
    i = j;
    if (!this.ahed.equals("")) {
      i = j + b.h(3, this.ahed);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */