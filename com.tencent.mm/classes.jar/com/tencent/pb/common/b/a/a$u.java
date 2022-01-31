package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$u
  extends e
{
  public int BdL = 0;
  public int BeT = 0;
  public int BeU = 0;
  public int ret = 0;
  public String userName = "";
  public int vA = 0;
  public int wjE = 0;
  
  public a$u()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.e(2, this.userName);
    }
    if (this.vA != 0) {
      paramb.bj(3, this.vA);
    }
    if (this.BeT != 0) {
      paramb.bk(4, this.BeT);
    }
    if (this.ret != 0) {
      paramb.bj(5, this.ret);
    }
    if (this.BeU != 0) {
      paramb.bj(6, this.BeU);
    }
    if (this.BdL != 0) {
      paramb.bk(7, this.BdL);
    }
    if (this.wjE != 0) {
      paramb.bk(8, this.wjE);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.f(2, this.userName);
    }
    j = i;
    if (this.vA != 0) {
      j = i + b.bl(3, this.vA);
    }
    i = j;
    if (this.BeT != 0) {
      i = j + b.bm(4, this.BeT);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.bl(5, this.ret);
    }
    i = j;
    if (this.BeU != 0) {
      i = j + b.bl(6, this.BeU);
    }
    j = i;
    if (this.BdL != 0) {
      j = i + b.bm(7, this.BdL);
    }
    i = j;
    if (this.wjE != 0) {
      i = j + b.bm(8, this.wjE);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.u
 * JD-Core Version:    0.7.0.1
 */