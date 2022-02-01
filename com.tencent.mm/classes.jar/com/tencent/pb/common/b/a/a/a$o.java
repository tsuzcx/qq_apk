package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$o
  extends e
{
  private static volatile o[] RDN;
  public int KBb = 0;
  public String RDO = "";
  public String nickname = "";
  
  public a$o()
  {
    this.cbo = -1;
  }
  
  public static o[] hjb()
  {
    if (RDN == null) {}
    synchronized (c.cbn)
    {
      if (RDN == null) {
        RDN = new o[0];
      }
      return RDN;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.KBb != 0) {
      i = j + b.bC(1, this.KBb);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.f(2, this.nickname);
    }
    i = j;
    if (!this.RDO.equals("")) {
      i = j + b.f(3, this.RDO);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.KBb != 0) {
      paramb.bB(1, this.KBb);
    }
    if (!this.nickname.equals("")) {
      paramb.e(2, this.nickname);
    }
    if (!this.RDO.equals("")) {
      paramb.e(3, this.RDO);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */