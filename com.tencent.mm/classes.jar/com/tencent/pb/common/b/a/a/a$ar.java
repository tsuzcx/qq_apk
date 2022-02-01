package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ar
  extends e
{
  private static volatile ar[] ZgQ;
  public int RCR = 0;
  public int ZgR = 0;
  public int ZgS = 0;
  public String fEC = "";
  public int tQm = 0;
  public int videoStatus = 0;
  
  public a$ar()
  {
    this.ccR = -1;
  }
  
  public static ar[] ikR()
  {
    if (ZgQ == null) {}
    synchronized (c.ccQ)
    {
      if (ZgQ == null) {
        ZgQ = new ar[0];
      }
      return ZgQ;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.tQm != 0) {
      i = j + b.bN(1, this.tQm);
    }
    j = i;
    if (!this.fEC.equals("")) {
      j = i + b.g(2, this.fEC);
    }
    i = j;
    if (this.RCR != 0) {
      i = j + b.bN(3, this.RCR);
    }
    j = i;
    if (this.videoStatus != 0) {
      j = i + b.bN(4, this.videoStatus);
    }
    i = j;
    if (this.ZgR != 0) {
      i = j + b.bN(5, this.ZgR);
    }
    j = i;
    if (this.ZgS != 0) {
      j = i + b.bN(6, this.ZgS);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.tQm != 0) {
      paramb.bK(1, this.tQm);
    }
    if (!this.fEC.equals("")) {
      paramb.f(2, this.fEC);
    }
    if (this.RCR != 0) {
      paramb.bK(3, this.RCR);
    }
    if (this.videoStatus != 0) {
      paramb.bK(4, this.videoStatus);
    }
    if (this.ZgR != 0) {
      paramb.bK(5, this.ZgR);
    }
    if (this.ZgS != 0) {
      paramb.bK(6, this.ZgS);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ar
 * JD-Core Version:    0.7.0.1
 */