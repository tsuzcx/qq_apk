package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$o
  extends e
{
  private static volatile o[] Zft;
  public int RCR = 0;
  public String Zfu = "";
  public String nickname = "";
  
  public a$o()
  {
    this.ccR = -1;
  }
  
  public static o[] ikL()
  {
    if (Zft == null) {}
    synchronized (c.ccQ)
    {
      if (Zft == null) {
        Zft = new o[0];
      }
      return Zft;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.RCR != 0) {
      i = j + b.bN(1, this.RCR);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.g(2, this.nickname);
    }
    i = j;
    if (!this.Zfu.equals("")) {
      i = j + b.g(3, this.Zfu);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.RCR != 0) {
      paramb.bK(1, this.RCR);
    }
    if (!this.nickname.equals("")) {
      paramb.f(2, this.nickname);
    }
    if (!this.Zfu.equals("")) {
      paramb.f(3, this.Zfu);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */