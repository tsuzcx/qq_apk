package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$m
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int RDG = 0;
  public int RDu = 0;
  public String groupId = "";
  public int netType = 0;
  public int qrD = -1;
  
  public a$m()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
    }
    j = i;
    if (this.qrD != -1) {
      j = i + b.bu(4, this.qrD);
    }
    i = j;
    if (this.RDu != 0) {
      i = j + b.bC(5, this.RDu);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.bC(6, this.netType);
    }
    i = j;
    if (this.RDG != 0) {
      i = j + b.bu(7, this.RDG);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    if (this.qrD != -1) {
      paramb.bs(4, this.qrD);
    }
    if (this.RDu != 0) {
      paramb.bB(5, this.RDu);
    }
    if (this.netType != 0) {
      paramb.bB(6, this.netType);
    }
    if (this.RDG != 0) {
      paramb.bs(7, this.RDG);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */