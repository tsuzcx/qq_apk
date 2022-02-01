package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$b
  extends e
{
  public String RDo = "";
  public int bDZ = 0;
  
  public a$b()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.RDo.equals("")) {
      i = j + b.f(1, this.RDo);
    }
    j = i;
    if (this.bDZ != 0) {
      j = i + b.bu(2, this.bDZ);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (!this.RDo.equals("")) {
      paramb.e(1, this.RDo);
    }
    if (this.bDZ != 0) {
      paramb.bs(2, this.bDZ);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */