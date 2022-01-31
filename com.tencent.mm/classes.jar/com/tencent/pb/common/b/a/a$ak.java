package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ak
  extends e
{
  public String groupId = "";
  public int twP = 0;
  public long twQ = 0L;
  
  public a$ak()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ak
 * JD-Core Version:    0.7.0.1
 */