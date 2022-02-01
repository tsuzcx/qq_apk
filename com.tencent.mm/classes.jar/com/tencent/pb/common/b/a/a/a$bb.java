package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bb
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Mgm = 0;
  
  public a$bb()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.Cuf != 0) {
      paramb.bx(1, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(2, this.Cug);
    }
    if (this.Mgm != 0) {
      paramb.by(3, this.Mgm);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.Cuf != 0) {
      i = j + b.bz(1, this.Cuf);
    }
    j = i;
    if (this.Cug != 0L) {
      j = i + b.p(2, this.Cug);
    }
    i = j;
    if (this.Mgm != 0) {
      i = j + b.bA(3, this.Mgm);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */