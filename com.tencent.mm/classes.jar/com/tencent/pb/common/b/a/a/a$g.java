package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$g
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public String ZeQ = "";
  public int bnA = 0;
  public String groupId = "";
  
  public a$g()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(1, this.groupId);
    }
    j = i;
    if (this.NOc != 0) {
      j = i + b.bM(2, this.NOc);
    }
    i = j;
    if (this.NOd != 0L) {
      i = j + b.p(3, this.NOd);
    }
    j = i;
    if (this.bnA != 0) {
      j = i + b.bM(4, this.bnA);
    }
    i = j;
    if (!this.ZeQ.equals("")) {
      i = j + b.g(5, this.ZeQ);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    if (this.bnA != 0) {
      paramb.bJ(4, this.bnA);
    }
    if (!this.ZeQ.equals("")) {
      paramb.f(5, this.ZeQ);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */