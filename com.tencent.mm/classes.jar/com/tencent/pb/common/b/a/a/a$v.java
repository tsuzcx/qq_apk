package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$v
  extends e
{
  public int BX = 0;
  public int CrQ = 0;
  public int IkG = 0;
  public int IlP = 0;
  public int IlQ = 0;
  public int ret = 0;
  public String userName = "";
  
  public a$v()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.d(2, this.userName);
    }
    if (this.BX != 0) {
      paramb.by(3, this.BX);
    }
    if (this.IlP != 0) {
      paramb.bz(4, this.IlP);
    }
    if (this.ret != 0) {
      paramb.by(5, this.ret);
    }
    if (this.IlQ != 0) {
      paramb.by(6, this.IlQ);
    }
    if (this.IkG != 0) {
      paramb.bz(7, this.IkG);
    }
    if (this.CrQ != 0) {
      paramb.bz(8, this.CrQ);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.e(2, this.userName);
    }
    j = i;
    if (this.BX != 0) {
      j = i + b.bA(3, this.BX);
    }
    i = j;
    if (this.IlP != 0) {
      i = j + b.bB(4, this.IlP);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.bA(5, this.ret);
    }
    i = j;
    if (this.IlQ != 0) {
      i = j + b.bA(6, this.IlQ);
    }
    j = i;
    if (this.IkG != 0) {
      j = i + b.bB(7, this.IkG);
    }
    i = j;
    if (this.CrQ != 0) {
      i = j + b.bB(8, this.CrQ);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.v
 * JD-Core Version:    0.7.0.1
 */