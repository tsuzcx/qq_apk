package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$b
  extends e
{
  public String McZ = "";
  public int reason = 0;
  
  public a$b()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.McZ.equals("")) {
      paramb.d(1, this.McZ);
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
    if (!this.McZ.equals("")) {
      i = j + b.e(1, this.McZ);
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