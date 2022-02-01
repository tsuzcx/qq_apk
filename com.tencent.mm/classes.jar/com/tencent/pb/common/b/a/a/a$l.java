package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$l
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JMD = 0;
  public int JMs = 0;
  public String groupId = "";
  public int netType = 0;
  public int osF = -1;
  
  public a$l()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.ADE != 0) {
      paramb.bv(2, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(3, this.ADF);
    }
    if (this.osF != -1) {
      paramb.bv(4, this.osF);
    }
    if (this.JMs != 0) {
      paramb.bw(5, this.JMs);
    }
    if (this.netType != 0) {
      paramb.bw(6, this.netType);
    }
    if (this.JMD != 0) {
      paramb.bv(7, this.JMD);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.ADE != 0) {
      j = i + b.bx(2, this.ADE);
    }
    i = j;
    if (this.ADF != 0L) {
      i = j + b.p(3, this.ADF);
    }
    j = i;
    if (this.osF != -1) {
      j = i + b.bx(4, this.osF);
    }
    i = j;
    if (this.JMs != 0) {
      i = j + b.by(5, this.JMs);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.by(6, this.netType);
    }
    i = j;
    if (this.JMD != 0) {
      i = j + b.bx(7, this.JMD);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */