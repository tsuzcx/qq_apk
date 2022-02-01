package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$h
  extends e
{
  public long Hnt = 0L;
  public String groupId = "";
  public String lMI = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$h()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.cF(1, this.roomId);
    paramb.t(2, this.Hnt);
    paramb.g(3, this.lMI);
    if (!this.groupId.equals("")) {
      paramb.g(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc() + b.cJ(1, this.roomId) + b.q(2, this.Hnt) + b.h(3, this.lMI);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.h(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.r(5, this.timestamp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */