package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ay
  extends e
{
  public int pRI = 0;
  public long pRJ = 0L;
  public int wJq = 0;
  
  public a$ay()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.pRI != 0) {
      paramb.aL(1, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(2, this.pRJ);
    }
    if (this.wJq != 0) {
      paramb.aM(3, this.wJq);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.pRI != 0) {
      i = j + b.aN(1, this.pRI);
    }
    j = i;
    if (this.pRJ != 0L) {
      j = i + b.k(2, this.pRJ);
    }
    i = j;
    if (this.wJq != 0) {
      i = j + b.aO(3, this.wJq);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ay
 * JD-Core Version:    0.7.0.1
 */