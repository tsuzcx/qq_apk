package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$ah
  extends e
{
  public long Hnt = 0L;
  public int roomId = 0;
  
  public a$ah()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.roomId != 0) {
      paramb.cF(1, this.roomId);
    }
    if (this.Hnt != 0L) {
      paramb.t(2, this.Hnt);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.roomId != 0) {
      i = j + b.cJ(1, this.roomId);
    }
    j = i;
    if (this.Hnt != 0L) {
      j = i + b.q(2, this.Hnt);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ah
 * JD-Core Version:    0.7.0.1
 */