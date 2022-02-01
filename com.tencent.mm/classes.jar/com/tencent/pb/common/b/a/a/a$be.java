package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$be
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int RGE = 0;
  
  public a$be()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.GXO != 0) {
      i = j + b.bu(1, this.GXO);
    }
    j = i;
    if (this.GXP != 0L) {
      j = i + b.r(2, this.GXP);
    }
    i = j;
    if (this.RGE != 0) {
      i = j + b.bC(3, this.RGE);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.GXO != 0) {
      paramb.bs(1, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(2, this.GXP);
    }
    if (this.RGE != 0) {
      paramb.bB(3, this.RGE);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */