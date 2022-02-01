package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$w
  extends e
{
  public int RCR = 0;
  public int Vh = 0;
  public int ZeV = 0;
  public int Zgk = 0;
  public int Zgl = 0;
  public int ret = 0;
  public String userName = "";
  
  public a$w()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.g(2, this.userName);
    }
    j = i;
    if (this.Vh != 0) {
      j = i + b.bM(3, this.Vh);
    }
    i = j;
    if (this.Zgk != 0) {
      i = j + b.bN(4, this.Zgk);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.bM(5, this.ret);
    }
    i = j;
    if (this.Zgl != 0) {
      i = j + b.bM(6, this.Zgl);
    }
    j = i;
    if (this.ZeV != 0) {
      j = i + b.bN(7, this.ZeV);
    }
    i = j;
    if (this.RCR != 0) {
      i = j + b.bN(8, this.RCR);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.f(2, this.userName);
    }
    if (this.Vh != 0) {
      paramb.bJ(3, this.Vh);
    }
    if (this.Zgk != 0) {
      paramb.bK(4, this.Zgk);
    }
    if (this.ret != 0) {
      paramb.bJ(5, this.ret);
    }
    if (this.Zgl != 0) {
      paramb.bJ(6, this.Zgl);
    }
    if (this.ZeV != 0) {
      paramb.bK(7, this.ZeV);
    }
    if (this.RCR != 0) {
      paramb.bK(8, this.RCR);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.w
 * JD-Core Version:    0.7.0.1
 */