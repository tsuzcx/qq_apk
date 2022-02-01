package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bb
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JPw = 0;
  
  public a$bb()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.ADE != 0) {
      paramb.bv(1, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(2, this.ADF);
    }
    if (this.JPw != 0) {
      paramb.bw(3, this.JPw);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.ADE != 0) {
      i = j + b.bx(1, this.ADE);
    }
    j = i;
    if (this.ADF != 0L) {
      j = i + b.p(2, this.ADF);
    }
    i = j;
    if (this.JPw != 0) {
      i = j + b.by(3, this.JPw);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */