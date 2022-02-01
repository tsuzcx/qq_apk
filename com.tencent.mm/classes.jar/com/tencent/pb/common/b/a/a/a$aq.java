package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aq
  extends e
{
  public int LHS = 0;
  public long ikh = 0L;
  public int inh = 0;
  
  public a$aq()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.ikh != 0L) {
      paramb.m(1, this.ikh);
    }
    if (this.inh != 0) {
      paramb.by(2, this.inh);
    }
    if (this.LHS != 0) {
      paramb.by(3, this.LHS);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.ikh != 0L) {
      i = j + b.o(1, this.ikh);
    }
    j = i;
    if (this.inh != 0) {
      j = i + b.bA(2, this.inh);
    }
    i = j;
    if (this.LHS != 0) {
      i = j + b.bA(3, this.LHS);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aq
 * JD-Core Version:    0.7.0.1
 */