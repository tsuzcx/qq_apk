package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$w
  extends e
{
  public int EX = 0;
  public int KBb = 0;
  public int RDt = 0;
  public int REE = 0;
  public int REG = 0;
  public int ret = 0;
  public String userName = "";
  
  public a$w()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.f(2, this.userName);
    }
    j = i;
    if (this.EX != 0) {
      j = i + b.bu(3, this.EX);
    }
    i = j;
    if (this.REE != 0) {
      i = j + b.bC(4, this.REE);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.bu(5, this.ret);
    }
    i = j;
    if (this.REG != 0) {
      i = j + b.bu(6, this.REG);
    }
    j = i;
    if (this.RDt != 0) {
      j = i + b.bC(7, this.RDt);
    }
    i = j;
    if (this.KBb != 0) {
      i = j + b.bC(8, this.KBb);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.e(2, this.userName);
    }
    if (this.EX != 0) {
      paramb.bs(3, this.EX);
    }
    if (this.REE != 0) {
      paramb.bB(4, this.REE);
    }
    if (this.ret != 0) {
      paramb.bs(5, this.ret);
    }
    if (this.REG != 0) {
      paramb.bs(6, this.REG);
    }
    if (this.RDt != 0) {
      paramb.bB(7, this.RDt);
    }
    if (this.KBb != 0) {
      paramb.bB(8, this.KBb);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.w
 * JD-Core Version:    0.7.0.1
 */