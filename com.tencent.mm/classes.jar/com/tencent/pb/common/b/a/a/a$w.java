package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$w
  extends e
{
  public int Yzt = 0;
  public int ahdy = 0;
  public int aheM = 0;
  public int aheN = 0;
  public int bUl = 0;
  public int ret = 0;
  public String userName = "";
  
  public a$w()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.g(2, this.userName);
    }
    if (this.bUl != 0) {
      paramb.cF(3, this.bUl);
    }
    if (this.aheM != 0) {
      paramb.cG(4, this.aheM);
    }
    if (this.ret != 0) {
      paramb.cF(5, this.ret);
    }
    if (this.aheN != 0) {
      paramb.cF(6, this.aheN);
    }
    if (this.ahdy != 0) {
      paramb.cG(7, this.ahdy);
    }
    if (this.Yzt != 0) {
      paramb.cG(8, this.Yzt);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.h(2, this.userName);
    }
    j = i;
    if (this.bUl != 0) {
      j = i + b.cJ(3, this.bUl);
    }
    i = j;
    if (this.aheM != 0) {
      i = j + b.cK(4, this.aheM);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.cJ(5, this.ret);
    }
    i = j;
    if (this.aheN != 0) {
      i = j + b.cJ(6, this.aheN);
    }
    j = i;
    if (this.ahdy != 0) {
      j = i + b.cK(7, this.ahdy);
    }
    i = j;
    if (this.Yzt != 0) {
      i = j + b.cK(8, this.Yzt);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.w
 * JD-Core Version:    0.7.0.1
 */