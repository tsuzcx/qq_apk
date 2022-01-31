package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$m
  extends e
{
  private static volatile m[] wGC;
  public String nickname = "";
  public int sqW = 0;
  public String wGD = "";
  
  public a$m()
  {
    this.aUI = -1;
  }
  
  public static m[] cNX()
  {
    if (wGC == null) {}
    synchronized (c.aUH)
    {
      if (wGC == null) {
        wGC = new m[0];
      }
      return wGC;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.sqW != 0) {
      paramb.aM(1, this.sqW);
    }
    if (!this.nickname.equals("")) {
      paramb.d(2, this.nickname);
    }
    if (!this.wGD.equals("")) {
      paramb.d(3, this.wGD);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.sqW != 0) {
      i = j + b.aO(1, this.sqW);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.e(2, this.nickname);
    }
    i = j;
    if (!this.wGD.equals("")) {
      i = j + b.e(3, this.wGD);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.m
 * JD-Core Version:    0.7.0.1
 */