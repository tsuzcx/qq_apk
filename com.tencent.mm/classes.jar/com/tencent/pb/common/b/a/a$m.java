package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$m
  extends e
{
  private static volatile m[] Bed;
  public String Bee = "";
  public String nickname = "";
  public int wjE = 0;
  
  public a$m()
  {
    this.bgY = -1;
  }
  
  public static m[] dTJ()
  {
    if (Bed == null) {}
    synchronized (c.bgX)
    {
      if (Bed == null) {
        Bed = new m[0];
      }
      return Bed;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wjE != 0) {
      paramb.bk(1, this.wjE);
    }
    if (!this.nickname.equals("")) {
      paramb.e(2, this.nickname);
    }
    if (!this.Bee.equals("")) {
      paramb.e(3, this.Bee);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.wjE != 0) {
      i = j + b.bm(1, this.wjE);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.f(2, this.nickname);
    }
    i = j;
    if (!this.Bee.equals("")) {
      i = j + b.f(3, this.Bee);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.m
 * JD-Core Version:    0.7.0.1
 */