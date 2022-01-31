package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ae
  extends e
{
  public int lpD = 0;
  public long lpE = 0L;
  
  public a$ae()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.lpD != 0) {
      paramb.aL(1, this.lpD);
    }
    if (this.lpE != 0L) {
      paramb.i(2, this.lpE);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.lpD != 0) {
      i = j + b.aN(1, this.lpD);
    }
    j = i;
    if (this.lpE != 0L) {
      j = i + b.k(2, this.lpE);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ae
 * JD-Core Version:    0.7.0.1
 */