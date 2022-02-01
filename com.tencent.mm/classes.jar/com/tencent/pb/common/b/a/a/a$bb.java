package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$bb
  extends e
{
  private static volatile bb[] ahgG;
  public int Yzt = 0;
  public long ahgH = 0L;
  public String ahgI = "";
  public String ahgJ = "";
  public String headUrl = "";
  public String username = "";
  
  public a$bb()
  {
    this.dXv = -1;
  }
  
  public static bb[] jRn()
  {
    if (ahgG == null) {}
    synchronized (c.dXu)
    {
      if (ahgG == null) {
        ahgG = new bb[0];
      }
      return ahgG;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Yzt != 0) {
      paramb.cG(1, this.Yzt);
    }
    if (!this.username.equals("")) {
      paramb.g(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.g(3, this.headUrl);
    }
    if (this.ahgH != 0L) {
      paramb.n(4, this.ahgH);
    }
    if (!this.ahgI.equals("")) {
      paramb.g(5, this.ahgI);
    }
    if (!this.ahgJ.equals("")) {
      paramb.g(6, this.ahgJ);
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
    if (!this.username.equals("")) {
      j = i + b.h(2, this.username);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + b.h(3, this.headUrl);
    }
    j = i;
    if (this.ahgH != 0L) {
      j = i + b.r(4, this.ahgH);
    }
    i = j;
    if (!this.ahgI.equals("")) {
      i = j + b.h(5, this.ahgI);
    }
    j = i;
    if (!this.ahgJ.equals("")) {
      j = i + b.h(6, this.ahgJ);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */