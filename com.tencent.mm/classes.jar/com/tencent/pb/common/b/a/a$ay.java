package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ay
  extends e
{
  public int BgQ = 0;
  public int twP = 0;
  public long twQ = 0L;
  
  public a$ay()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.twP != 0) {
      paramb.bj(1, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(2, this.twQ);
    }
    if (this.BgQ != 0) {
      paramb.bk(3, this.BgQ);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.twP != 0) {
      i = j + b.bl(1, this.twP);
    }
    j = i;
    if (this.twQ != 0L) {
      j = i + b.p(2, this.twQ);
    }
    i = j;
    if (this.BgQ != 0) {
      i = j + b.bm(3, this.BgQ);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ay
 * JD-Core Version:    0.7.0.1
 */