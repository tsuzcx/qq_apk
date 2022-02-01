package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$af
  extends e
{
  public int roomId = 0;
  public long sAY = 0L;
  
  public a$af()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.roomId != 0) {
      paramb.by(1, this.roomId);
    }
    if (this.sAY != 0L) {
      paramb.o(2, this.sAY);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.roomId != 0) {
      i = j + b.bA(1, this.roomId);
    }
    j = i;
    if (this.sAY != 0L) {
      j = i + b.q(2, this.sAY);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.af
 * JD-Core Version:    0.7.0.1
 */