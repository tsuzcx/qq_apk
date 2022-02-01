package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$m
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int ahdP = 0;
  public int ahdz = 0;
  public String groupId = "";
  public int netType = 0;
  public int wTC = -1;
  
  public a$m()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.g(1, this.groupId);
    }
    if (this.UAZ != 0) {
      paramb.cF(2, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(3, this.UBa);
    }
    if (this.wTC != -1) {
      paramb.cF(4, this.wTC);
    }
    if (this.ahdz != 0) {
      paramb.cG(5, this.ahdz);
    }
    if (this.netType != 0) {
      paramb.cG(6, this.netType);
    }
    if (this.ahdP != 0) {
      paramb.cF(7, this.ahdP);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.h(1, this.groupId);
    }
    j = i;
    if (this.UAZ != 0) {
      j = i + b.cJ(2, this.UAZ);
    }
    i = j;
    if (this.UBa != 0L) {
      i = j + b.q(3, this.UBa);
    }
    j = i;
    if (this.wTC != -1) {
      j = i + b.cJ(4, this.wTC);
    }
    i = j;
    if (this.ahdz != 0) {
      i = j + b.cK(5, this.ahdz);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.cK(6, this.netType);
    }
    i = j;
    if (this.ahdP != 0) {
      i = j + b.cJ(7, this.ahdP);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */