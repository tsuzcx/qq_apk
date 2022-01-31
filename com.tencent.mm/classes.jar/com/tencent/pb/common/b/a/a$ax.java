package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ax
  extends e
{
  public int BgP = 0;
  
  public a$ax()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.BgP != 0) {
      paramb.bk(1, this.BgP);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.BgP != 0) {
      i = j + b.bm(1, this.BgP);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ax
 * JD-Core Version:    0.7.0.1
 */