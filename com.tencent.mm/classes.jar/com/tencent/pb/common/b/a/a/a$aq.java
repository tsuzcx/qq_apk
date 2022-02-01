package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aq
  extends e
{
  public int MeW = 0;
  public long ina = 0L;
  public int iqb = 0;
  
  public a$aq()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.ina != 0L) {
      paramb.m(1, this.ina);
    }
    if (this.iqb != 0) {
      paramb.by(2, this.iqb);
    }
    if (this.MeW != 0) {
      paramb.by(3, this.MeW);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.ina != 0L) {
      i = j + b.o(1, this.ina);
    }
    j = i;
    if (this.iqb != 0) {
      j = i + b.bA(2, this.iqb);
    }
    i = j;
    if (this.MeW != 0) {
      i = j + b.bA(3, this.MeW);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aq
 * JD-Core Version:    0.7.0.1
 */