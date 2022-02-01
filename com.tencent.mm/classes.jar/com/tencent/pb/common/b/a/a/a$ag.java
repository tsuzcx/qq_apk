package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ag
  extends e
{
  public int roomId = 0;
  public long uXg = 0L;
  
  public a$ag()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.roomId != 0) {
      paramb.bx(1, this.roomId);
    }
    if (this.uXg != 0L) {
      paramb.n(2, this.uXg);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.roomId != 0) {
      i = j + b.bz(1, this.roomId);
    }
    j = i;
    if (this.uXg != 0L) {
      j = i + b.p(2, this.uXg);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ag
 * JD-Core Version:    0.7.0.1
 */