package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$l
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Mdf = 0;
  public int Mdq = 0;
  public String groupId = "";
  public int netType = 0;
  public int pcE = -1;
  
  public a$l()
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
    if (this.pcE != -1) {
      paramb.bx(4, this.pcE);
    }
    if (this.Mdf != 0) {
      paramb.by(5, this.Mdf);
    }
    if (this.netType != 0) {
      paramb.by(6, this.netType);
    }
    if (this.Mdq != 0) {
      paramb.bx(7, this.Mdq);
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
    if (this.pcE != -1) {
      j = i + b.bz(4, this.pcE);
    }
    i = j;
    if (this.Mdf != 0) {
      i = j + b.bA(5, this.Mdf);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.bA(6, this.netType);
    }
    i = j;
    if (this.Mdq != 0) {
      i = j + b.bz(7, this.Mdq);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */