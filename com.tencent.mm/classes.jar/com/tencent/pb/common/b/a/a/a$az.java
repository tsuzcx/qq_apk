package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$az
  extends e
{
  private static volatile az[] JPr;
  public int DKi = 0;
  public long JPs = 0L;
  public String JPt = "";
  public String JPu = "";
  public String headUrl = "";
  public String username = "";
  
  public a$az()
  {
    this.bGA = -1;
  }
  
  public static az[] fBR()
  {
    if (JPr == null) {}
    synchronized (c.bGz)
    {
      if (JPr == null) {
        JPr = new az[0];
      }
      return JPr;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.DKi != 0) {
      paramb.bw(1, this.DKi);
    }
    if (!this.username.equals("")) {
      paramb.d(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.d(3, this.headUrl);
    }
    if (this.JPs != 0L) {
      paramb.m(4, this.JPs);
    }
    if (!this.JPt.equals("")) {
      paramb.d(5, this.JPt);
    }
    if (!this.JPu.equals("")) {
      paramb.d(6, this.JPu);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.DKi != 0) {
      i = j + b.by(1, this.DKi);
    }
    j = i;
    if (!this.username.equals("")) {
      j = i + b.e(2, this.username);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + b.e(3, this.headUrl);
    }
    j = i;
    if (this.JPs != 0L) {
      j = i + b.o(4, this.JPs);
    }
    i = j;
    if (!this.JPt.equals("")) {
      i = j + b.e(5, this.JPt);
    }
    j = i;
    if (!this.JPu.equals("")) {
      j = i + b.e(6, this.JPu);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.az
 * JD-Core Version:    0.7.0.1
 */