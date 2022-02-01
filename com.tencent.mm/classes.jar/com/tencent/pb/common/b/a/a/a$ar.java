package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] ahfr;
  public int Yzt = 0;
  public int ahfs = 0;
  public int ahft = 0;
  public String hJs = "";
  public int videoStatus = 0;
  public int wTC = 0;
  
  public a$ar()
  {
    this.dXv = -1;
  }
  
  public static ar[] jRi()
  {
    if (ahfr == null) {}
    synchronized (c.dXu)
    {
      if (ahfr == null) {
        ahfr = new ar[0];
      }
      return ahfr;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wTC != 0) {
      paramb.cG(1, this.wTC);
    }
    if (!this.hJs.equals("")) {
      paramb.g(2, this.hJs);
    }
    if (this.Yzt != 0) {
      paramb.cG(3, this.Yzt);
    }
    if (this.videoStatus != 0) {
      paramb.cG(4, this.videoStatus);
    }
    if (this.ahfs != 0) {
      paramb.cG(5, this.ahfs);
    }
    if (this.ahft != 0) {
      paramb.cG(6, this.ahft);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.wTC != 0) {
      i = j + b.cK(1, this.wTC);
    }
    j = i;
    if (!this.hJs.equals("")) {
      j = i + b.h(2, this.hJs);
    }
    i = j;
    if (this.Yzt != 0) {
      i = j + b.cK(3, this.Yzt);
    }
    j = i;
    if (this.videoStatus != 0) {
      j = i + b.cK(4, this.videoStatus);
    }
    i = j;
    if (this.ahfs != 0) {
      i = j + b.cK(5, this.ahfs);
    }
    j = i;
    if (this.ahft != 0) {
      j = i + b.cK(6, this.ahft);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */