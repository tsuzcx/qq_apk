package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$b
  extends e
{
  public String LFV = "";
  public int reason = 0;
  
  public a$b()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.LFV.equals("")) {
      paramb.d(1, this.LFV);
    }
    if (this.reason != 0) {
      paramb.bx(2, this.reason);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.LFV.equals("")) {
      i = j + b.e(1, this.LFV);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.bz(2, this.reason);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */