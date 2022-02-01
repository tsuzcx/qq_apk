package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$az
  extends e
{
  private static volatile az[] LJd;
  public int Fpp = 0;
  public long LJe = 0L;
  public String LJf = "";
  public String LJg = "";
  public String headUrl = "";
  public String username = "";
  
  public a$az()
  {
    this.bQO = -1;
  }
  
  public static az[] fTg()
  {
    if (LJd == null) {}
    synchronized (c.bQN)
    {
      if (LJd == null) {
        LJd = new az[0];
      }
      return LJd;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Fpp != 0) {
      paramb.by(1, this.Fpp);
    }
    if (!this.username.equals("")) {
      paramb.d(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.d(3, this.headUrl);
    }
    if (this.LJe != 0L) {
      paramb.m(4, this.LJe);
    }
    if (!this.LJf.equals("")) {
      paramb.d(5, this.LJf);
    }
    if (!this.LJg.equals("")) {
      paramb.d(6, this.LJg);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.Fpp != 0) {
      i = j + b.bA(1, this.Fpp);
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
    if (this.LJe != 0L) {
      j = i + b.o(4, this.LJe);
    }
    i = j;
    if (!this.LJf.equals("")) {
      i = j + b.e(5, this.LJf);
    }
    j = i;
    if (!this.LJg.equals("")) {
      j = i + b.e(6, this.LJg);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.az
 * JD-Core Version:    0.7.0.1
 */