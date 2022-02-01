package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$f
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int RDC = 0;
  public int bDZ = 0;
  public String groupId = "";
  
  public a$f()
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
    if (this.RDC != 0) {
      i = j + b.bu(5, this.RDC);
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
    if (this.RDC != 0) {
      paramb.bs(5, this.RDC);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */