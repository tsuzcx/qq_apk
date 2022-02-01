package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$f
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int LGj = 0;
  public String groupId = "";
  public int reason = 0;
  
  public a$f()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.CcE != 0) {
      paramb.bx(2, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(3, this.CcF);
    }
    if (this.reason != 0) {
      paramb.bx(4, this.reason);
    }
    if (this.LGj != 0) {
      paramb.bx(5, this.LGj);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.CcE != 0) {
      j = i + b.bz(2, this.CcE);
    }
    i = j;
    if (this.CcF != 0L) {
      i = j + b.p(3, this.CcF);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.bz(4, this.reason);
    }
    i = j;
    if (this.LGj != 0) {
      i = j + b.bz(5, this.LGj);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */