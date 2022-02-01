package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$h
  extends e
{
  public long DPJ = 0L;
  public String groupId = "";
  public String jke = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$h()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG() + b.bM(1, this.roomId) + b.p(2, this.DPJ) + b.g(3, this.jke);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.q(5, this.timestamp);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    paramb.bJ(1, this.roomId);
    paramb.r(2, this.DPJ);
    paramb.f(3, this.jke);
    if (!this.groupId.equals("")) {
      paramb.f(4, this.groupId);
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