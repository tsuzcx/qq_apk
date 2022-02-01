package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$h
  extends e
{
  public String fvS = "";
  public String groupId = "";
  public int roomId = 0;
  public long sAY = 0L;
  public long timestamp = 0L;
  
  public a$h()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.by(1, this.roomId);
    paramb.o(2, this.sAY);
    paramb.d(3, this.fvS);
    if (!this.groupId.equals("")) {
      paramb.d(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg() + b.bA(1, this.roomId) + b.q(2, this.sAY) + b.e(3, this.fvS);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.p(5, this.timestamp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */