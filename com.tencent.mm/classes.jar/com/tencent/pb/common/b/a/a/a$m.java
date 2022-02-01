package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$m
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int ZeW = 0;
  public int Zfm = 0;
  public String groupId = "";
  public int netType = 0;
  public int tQm = -1;
  
  public a$m()
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
    if (this.tQm != -1) {
      j = i + b.bM(4, this.tQm);
    }
    i = j;
    if (this.ZeW != 0) {
      i = j + b.bN(5, this.ZeW);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.bN(6, this.netType);
    }
    i = j;
    if (this.Zfm != 0) {
      i = j + b.bM(7, this.Zfm);
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
    if (this.tQm != -1) {
      paramb.bJ(4, this.tQm);
    }
    if (this.ZeW != 0) {
      paramb.bK(5, this.ZeW);
    }
    if (this.netType != 0) {
      paramb.bK(6, this.netType);
    }
    if (this.Zfm != 0) {
      paramb.bJ(7, this.Zfm);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */