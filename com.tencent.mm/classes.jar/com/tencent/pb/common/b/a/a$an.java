package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$an
  extends e
{
  public int BfA = 0;
  public long fNv = 0L;
  public int fQD = 0;
  
  public a$an()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.fNv != 0L) {
      paramb.m(1, this.fNv);
    }
    if (this.fQD != 0) {
      paramb.bk(2, this.fQD);
    }
    if (this.BfA != 0) {
      paramb.bk(3, this.BfA);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.fNv != 0L) {
      i = j + b.o(1, this.fNv);
    }
    j = i;
    if (this.fQD != 0) {
      j = i + b.bm(2, this.fQD);
    }
    i = j;
    if (this.BfA != 0) {
      i = j + b.bm(3, this.BfA);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.an
 * JD-Core Version:    0.7.0.1
 */