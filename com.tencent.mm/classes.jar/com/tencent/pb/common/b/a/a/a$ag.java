package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ag
  extends e
{
  public int roomId = 0;
  public long tIG = 0L;
  
  public a$ag()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.roomId != 0) {
      paramb.bv(1, this.roomId);
    }
    if (this.tIG != 0L) {
      paramb.n(2, this.tIG);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.roomId != 0) {
      i = j + b.bx(1, this.roomId);
    }
    j = i;
    if (this.tIG != 0L) {
      j = i + b.p(2, this.tIG);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ag
 * JD-Core Version:    0.7.0.1
 */