package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$as
  extends e
{
  private static volatile as[] RFl;
  public int KBb = 0;
  public int RFm = 0;
  public int RFn = 0;
  public String dLN = "";
  public int qrD = 0;
  public int videoStatus = 0;
  
  public a$as()
  {
    this.cbo = -1;
  }
  
  public static as[] hjh()
  {
    if (RFl == null) {}
    synchronized (c.cbn)
    {
      if (RFl == null) {
        RFl = new as[0];
      }
      return RFl;
    }
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.qrD != 0) {
      i = j + b.bC(1, this.qrD);
    }
    j = i;
    if (!this.dLN.equals("")) {
      j = i + b.f(2, this.dLN);
    }
    i = j;
    if (this.KBb != 0) {
      i = j + b.bC(3, this.KBb);
    }
    j = i;
    if (this.videoStatus != 0) {
      j = i + b.bC(4, this.videoStatus);
    }
    i = j;
    if (this.RFm != 0) {
      i = j + b.bC(5, this.RFm);
    }
    j = i;
    if (this.RFn != 0) {
      j = i + b.bC(6, this.RFn);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.qrD != 0) {
      paramb.bB(1, this.qrD);
    }
    if (!this.dLN.equals("")) {
      paramb.e(2, this.dLN);
    }
    if (this.KBb != 0) {
      paramb.bB(3, this.KBb);
    }
    if (this.videoStatus != 0) {
      paramb.bB(4, this.videoStatus);
    }
    if (this.RFm != 0) {
      paramb.bB(5, this.RFm);
    }
    if (this.RFn != 0) {
      paramb.bB(6, this.RFn);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.as
 * JD-Core Version:    0.7.0.1
 */