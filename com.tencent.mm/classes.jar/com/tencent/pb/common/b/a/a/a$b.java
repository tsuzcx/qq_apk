package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$b
  extends e
{
  public String ahdt = "";
  public int reason = 0;
  
  public a$b()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.ahdt.equals("")) {
      paramb.g(1, this.ahdt);
    }
    if (this.reason != 0) {
      paramb.cF(2, this.reason);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.ahdt.equals("")) {
      i = j + b.h(1, this.ahdt);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.cJ(2, this.reason);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */