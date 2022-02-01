package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$f
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Mdn = 0;
  public String groupId = "";
  public int reason = 0;
  
  public a$f()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(2, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(3, this.Cug);
    }
    if (this.reason != 0) {
      paramb.bx(4, this.reason);
    }
    if (this.Mdn != 0) {
      paramb.bx(5, this.Mdn);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.Cuf != 0) {
      j = i + b.bz(2, this.Cuf);
    }
    i = j;
    if (this.Cug != 0L) {
      i = j + b.p(3, this.Cug);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.bz(4, this.reason);
    }
    i = j;
    if (this.Mdn != 0) {
      i = j + b.bz(5, this.Mdn);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */