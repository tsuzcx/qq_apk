package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$as
  extends e
{
  public int ZgT = 0;
  public int mbp = 0;
  public long status = 0L;
  
  public a$as()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.status != 0L) {
      i = j + b.q(1, this.status);
    }
    j = i;
    if (this.mbp != 0) {
      j = i + b.bN(2, this.mbp);
    }
    i = j;
    if (this.ZgT != 0) {
      i = j + b.bN(3, this.ZgT);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.status != 0L) {
      paramb.n(1, this.status);
    }
    if (this.mbp != 0) {
      paramb.bK(2, this.mbp);
    }
    if (this.ZgT != 0) {
      paramb.bK(3, this.ZgT);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.as
 * JD-Core Version:    0.7.0.1
 */