package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$f
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JMA = 0;
  public String groupId = "";
  public int reason = 0;
  
  public a$f()
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
    if (this.reason != 0) {
      paramb.bv(4, this.reason);
    }
    if (this.JMA != 0) {
      paramb.bv(5, this.JMA);
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
    if (this.reason != 0) {
      j = i + b.bx(4, this.reason);
    }
    i = j;
    if (this.JMA != 0) {
      i = j + b.bx(5, this.JMA);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */