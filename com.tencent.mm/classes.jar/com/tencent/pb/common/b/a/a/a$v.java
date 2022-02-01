package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$v
  extends e
{
  public int CW = 0;
  public int DKi = 0;
  public int JMr = 0;
  public int JNA = 0;
  public int JNB = 0;
  public int ret = 0;
  public String userName = "";
  
  public a$v()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.d(2, this.userName);
    }
    if (this.CW != 0) {
      paramb.bv(3, this.CW);
    }
    if (this.JNA != 0) {
      paramb.bw(4, this.JNA);
    }
    if (this.ret != 0) {
      paramb.bv(5, this.ret);
    }
    if (this.JNB != 0) {
      paramb.bv(6, this.JNB);
    }
    if (this.JMr != 0) {
      paramb.bw(7, this.JMr);
    }
    if (this.DKi != 0) {
      paramb.bw(8, this.DKi);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.e(2, this.userName);
    }
    j = i;
    if (this.CW != 0) {
      j = i + b.bx(3, this.CW);
    }
    i = j;
    if (this.JNA != 0) {
      i = j + b.by(4, this.JNA);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.bx(5, this.ret);
    }
    i = j;
    if (this.JNB != 0) {
      i = j + b.bx(6, this.JNB);
    }
    j = i;
    if (this.JMr != 0) {
      j = i + b.by(7, this.JMr);
    }
    i = j;
    if (this.DKi != 0) {
      i = j + b.by(8, this.DKi);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.v
 * JD-Core Version:    0.7.0.1
 */