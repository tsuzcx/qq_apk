package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ae
  extends e
{
  public int nMZ = 0;
  public long nNa = 0L;
  
  public a$ae()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.nMZ != 0) {
      paramb.bj(1, this.nMZ);
    }
    if (this.nNa != 0L) {
      paramb.n(2, this.nNa);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.nMZ != 0) {
      i = j + b.bl(1, this.nMZ);
    }
    j = i;
    if (this.nNa != 0L) {
      j = i + b.p(2, this.nNa);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ae
 * JD-Core Version:    0.7.0.1
 */