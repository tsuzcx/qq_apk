package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aq
  extends e
{
  public int JOg = 0;
  public long hQT = 0L;
  public int hTM = 0;
  
  public a$aq()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.hQT != 0L) {
      paramb.m(1, this.hQT);
    }
    if (this.hTM != 0) {
      paramb.bw(2, this.hTM);
    }
    if (this.JOg != 0) {
      paramb.bw(3, this.JOg);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.hQT != 0L) {
      i = j + b.o(1, this.hQT);
    }
    j = i;
    if (this.hTM != 0) {
      j = i + b.by(2, this.hTM);
    }
    i = j;
    if (this.JOg != 0) {
      i = j + b.by(3, this.JOg);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aq
 * JD-Core Version:    0.7.0.1
 */