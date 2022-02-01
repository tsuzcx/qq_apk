package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$o
  extends e
{
  private static volatile o[] ahdW;
  public int Yzt = 0;
  public String ahdX = "";
  public String nickname = "";
  
  public a$o()
  {
    this.dXv = -1;
  }
  
  public static o[] jRc()
  {
    if (ahdW == null) {}
    synchronized (c.dXu)
    {
      if (ahdW == null) {
        ahdW = new o[0];
      }
      return ahdW;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Yzt != 0) {
      paramb.cG(1, this.Yzt);
    }
    if (!this.nickname.equals("")) {
      paramb.g(2, this.nickname);
    }
    if (!this.ahdX.equals("")) {
      paramb.g(3, this.ahdX);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.Yzt != 0) {
      i = j + b.cK(1, this.Yzt);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.h(2, this.nickname);
    }
    i = j;
    if (!this.ahdX.equals("")) {
      i = j + b.h(3, this.ahdX);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */