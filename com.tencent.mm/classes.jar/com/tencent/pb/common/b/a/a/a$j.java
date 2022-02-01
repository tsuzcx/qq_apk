package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$j
  extends e
{
  public int action = 0;
  public String groupId = "";
  public int roomId = 0;
  public long sAY = 0L;
  public long timestamp = 0L;
  
  public a$j()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.bz(1, this.action);
    paramb.by(2, this.roomId);
    paramb.o(3, this.sAY);
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
    int j = super.yg() + b.bB(1, this.action) + b.bA(2, this.roomId) + b.q(3, this.sAY);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */