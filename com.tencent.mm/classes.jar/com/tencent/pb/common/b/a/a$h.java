package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$h
  extends e
{
  public String ejf = "";
  public String groupId = "";
  public int nMZ = 0;
  public long nNa = 0L;
  public long timestamp = 0L;
  
  public a$h()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.bj(1, this.nMZ);
    paramb.n(2, this.nNa);
    paramb.e(3, this.ejf);
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
    int j = super.sz() + b.bl(1, this.nMZ) + b.p(2, this.nNa) + b.f(3, this.ejf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */