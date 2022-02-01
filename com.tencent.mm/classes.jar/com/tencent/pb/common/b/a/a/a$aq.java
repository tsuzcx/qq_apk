package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aq
  extends e
{
  public int Imw = 0;
  public long hqr = 0L;
  public int htk = 0;
  
  public a$aq()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.hqr != 0L) {
      paramb.n(1, this.hqr);
    }
    if (this.htk != 0) {
      paramb.bz(2, this.htk);
    }
    if (this.Imw != 0) {
      paramb.bz(3, this.Imw);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.hqr != 0L) {
      i = j + b.p(1, this.hqr);
    }
    j = i;
    if (this.htk != 0) {
      j = i + b.bB(2, this.htk);
    }
    i = j;
    if (this.Imw != 0) {
      i = j + b.bB(3, this.Imw);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aq
 * JD-Core Version:    0.7.0.1
 */