package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$bd
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int ahgL = 0;
  
  public a$bd()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.UAZ != 0) {
      paramb.cF(1, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(2, this.UBa);
    }
    if (this.ahgL != 0) {
      paramb.cG(3, this.ahgL);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.UAZ != 0) {
      i = j + b.cJ(1, this.UAZ);
    }
    j = i;
    if (this.UBa != 0L) {
      j = i + b.q(2, this.UBa);
    }
    i = j;
    if (this.ahgL != 0) {
      i = j + b.cK(3, this.ahgL);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bd
 * JD-Core Version:    0.7.0.1
 */