package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$an
  extends e
{
  public int eAK = 0;
  public long exG = 0L;
  public int wIa = 0;
  
  public a$an()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.exG != 0L) {
      paramb.h(1, this.exG);
    }
    if (this.eAK != 0) {
      paramb.aM(2, this.eAK);
    }
    if (this.wIa != 0) {
      paramb.aM(3, this.wIa);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.exG != 0L) {
      i = j + b.j(1, this.exG);
    }
    j = i;
    if (this.eAK != 0) {
      j = i + b.aO(2, this.eAK);
    }
    i = j;
    if (this.wIa != 0) {
      i = j + b.aO(3, this.wIa);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.an
 * JD-Core Version:    0.7.0.1
 */