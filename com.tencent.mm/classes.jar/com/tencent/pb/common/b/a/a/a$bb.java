package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bb
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int LJi = 0;
  
  public a$bb()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.CcE != 0) {
      paramb.bx(1, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(2, this.CcF);
    }
    if (this.LJi != 0) {
      paramb.by(3, this.LJi);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.CcE != 0) {
      i = j + b.bz(1, this.CcE);
    }
    j = i;
    if (this.CcF != 0L) {
      j = i + b.p(2, this.CcF);
    }
    i = j;
    if (this.LJi != 0) {
      i = j + b.bA(3, this.LJi);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */