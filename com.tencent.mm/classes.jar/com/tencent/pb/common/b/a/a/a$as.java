package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$as
  extends e
{
  public int LHV = 0;
  public int LHW = 0;
  
  public a$as()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.LHV != 0) {
      paramb.bx(1, this.LHV);
    }
    if (this.LHW != 0) {
      paramb.bx(2, this.LHW);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.LHV != 0) {
      i = j + b.bz(1, this.LHV);
    }
    j = i;
    if (this.LHW != 0) {
      j = i + b.bz(2, this.LHW);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.as
 * JD-Core Version:    0.7.0.1
 */