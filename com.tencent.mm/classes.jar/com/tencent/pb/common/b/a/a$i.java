package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$i
  extends e
{
  public int action = 0;
  public String groupId = "";
  public int nMZ = 0;
  public long nNa = 0L;
  public long timestamp = 0L;
  
  public a$i()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.bk(1, this.action);
    paramb.bj(2, this.nMZ);
    paramb.n(3, this.nNa);
    if (!this.groupId.equals("")) {
      paramb.e(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.m(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz() + b.bm(1, this.action) + b.bl(2, this.nMZ) + b.p(3, this.nNa);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.o(5, this.timestamp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */