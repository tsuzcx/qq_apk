package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$y
  extends e
{
  private static volatile y[] Zgn;
  public String Zgo = "";
  public String wDN = "";
  
  public a$y()
  {
    this.ccR = -1;
  }
  
  public static y[] ikO()
  {
    if (Zgn == null) {}
    synchronized (c.ccQ)
    {
      if (Zgn == null) {
        Zgn = new y[0];
      }
      return Zgn;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.wDN.equals("")) {
      i = j + b.g(1, this.wDN);
    }
    j = i;
    if (!this.Zgo.equals("")) {
      j = i + b.g(2, this.Zgo);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (!this.wDN.equals("")) {
      paramb.f(1, this.wDN);
    }
    if (!this.Zgo.equals("")) {
      paramb.f(2, this.Zgo);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.y
 * JD-Core Version:    0.7.0.1
 */