package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$h
  extends e
{
  public String gAb = "";
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  public long ypH = 0L;
  
  public a$h()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig() + b.bu(1, this.roomId) + b.r(2, this.ypH) + b.f(3, this.gAb);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.p(5, this.timestamp);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    paramb.bs(1, this.roomId);
    paramb.q(2, this.ypH);
    paramb.e(3, this.gAb);
    if (!this.groupId.equals("")) {
      paramb.e(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */