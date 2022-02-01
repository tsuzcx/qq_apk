package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$j
  extends e
{
  public int action = 0;
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  public long uLt = 0L;
  
  public a$j()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.by(1, this.action);
    paramb.bx(2, this.roomId);
    paramb.n(3, this.uLt);
    if (!this.groupId.equals("")) {
      paramb.d(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.m(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq() + b.bA(1, this.action) + b.bz(2, this.roomId) + b.p(3, this.uLt);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.o(5, this.timestamp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */