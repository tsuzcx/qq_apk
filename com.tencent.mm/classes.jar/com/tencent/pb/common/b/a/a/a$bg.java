package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$bg
  extends e
{
  public a.ap RGJ = null;
  public int type = 0;
  
  public a$bg()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.type != 0) {
      i = j + b.bu(1, this.type);
    }
    j = i;
    if (this.RGJ != null) {
      j = i + b.b(2, this.RGJ);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.bs(1, this.type);
    }
    if (this.RGJ != null) {
      paramb.a(2, this.RGJ);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bg
 * JD-Core Version:    0.7.0.1
 */