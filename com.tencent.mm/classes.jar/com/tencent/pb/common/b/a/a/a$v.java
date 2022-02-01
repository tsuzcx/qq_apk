package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$v
  extends e
{
  public int EN = 0;
  public int FHN = 0;
  public int Mde = 0;
  public int Men = 0;
  public int Meo = 0;
  public int ret = 0;
  public String userName = "";
  
  public a$v()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.d(2, this.userName);
    }
    if (this.EN != 0) {
      paramb.bx(3, this.EN);
    }
    if (this.Men != 0) {
      paramb.by(4, this.Men);
    }
    if (this.ret != 0) {
      paramb.bx(5, this.ret);
    }
    if (this.Meo != 0) {
      paramb.bx(6, this.Meo);
    }
    if (this.Mde != 0) {
      paramb.by(7, this.Mde);
    }
    if (this.FHN != 0) {
      paramb.by(8, this.FHN);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.e(2, this.userName);
    }
    j = i;
    if (this.EN != 0) {
      j = i + b.bz(3, this.EN);
    }
    i = j;
    if (this.Men != 0) {
      i = j + b.bA(4, this.Men);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.bz(5, this.ret);
    }
    i = j;
    if (this.Meo != 0) {
      i = j + b.bz(6, this.Meo);
    }
    j = i;
    if (this.Mde != 0) {
      j = i + b.bA(7, this.Mde);
    }
    i = j;
    if (this.FHN != 0) {
      i = j + b.bA(8, this.FHN);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.v
 * JD-Core Version:    0.7.0.1
 */