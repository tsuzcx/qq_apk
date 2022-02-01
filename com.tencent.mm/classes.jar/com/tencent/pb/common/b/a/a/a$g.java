package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$g
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public String RDo = "";
  public int bDZ = 0;
  public String groupId = "";
  
  public a$g()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
    }
    j = i;
    if (this.bDZ != 0) {
      j = i + b.bu(4, this.bDZ);
    }
    i = j;
    if (!this.RDo.equals("")) {
      i = j + b.f(5, this.RDo);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    if (this.bDZ != 0) {
      paramb.bs(4, this.bDZ);
    }
    if (!this.RDo.equals("")) {
      paramb.e(5, this.RDo);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */