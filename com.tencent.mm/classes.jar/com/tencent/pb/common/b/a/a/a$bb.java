package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$bb
  extends e
{
  private static volatile bb[] Zif;
  public int RCR = 0;
  public long Zig = 0L;
  public String Zih = "";
  public String Zii = "";
  public String headUrl = "";
  public String username = "";
  
  public a$bb()
  {
    this.ccR = -1;
  }
  
  public static bb[] ikW()
  {
    if (Zif == null) {}
    synchronized (c.ccQ)
    {
      if (Zif == null) {
        Zif = new bb[0];
      }
      return Zif;
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
    if (!this.username.equals("")) {
      j = i + b.g(2, this.username);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + b.g(3, this.headUrl);
    }
    j = i;
    if (this.Zig != 0L) {
      j = i + b.q(4, this.Zig);
    }
    i = j;
    if (!this.Zih.equals("")) {
      i = j + b.g(5, this.Zih);
    }
    j = i;
    if (!this.Zii.equals("")) {
      j = i + b.g(6, this.Zii);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.RCR != 0) {
      paramb.bK(1, this.RCR);
    }
    if (!this.username.equals("")) {
      paramb.f(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.f(3, this.headUrl);
    }
    if (this.Zig != 0L) {
      paramb.n(4, this.Zig);
    }
    if (!this.Zih.equals("")) {
      paramb.f(5, this.Zih);
    }
    if (!this.Zii.equals("")) {
      paramb.f(6, this.Zii);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */