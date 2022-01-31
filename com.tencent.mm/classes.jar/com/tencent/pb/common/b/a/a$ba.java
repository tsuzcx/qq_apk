package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ba
  extends e
{
  public a.al BgW = null;
  public int type = 0;
  
  public a$ba()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.bj(1, this.type);
    }
    if (this.BgW != null) {
      paramb.a(2, this.BgW);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.type != 0) {
      i = j + b.bl(1, this.type);
    }
    j = i;
    if (this.BgW != null) {
      j = i + b.b(2, this.BgW);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ba
 * JD-Core Version:    0.7.0.1
 */