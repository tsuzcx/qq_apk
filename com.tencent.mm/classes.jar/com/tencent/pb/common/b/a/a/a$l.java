package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$l
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int LGb = 0;
  public int LGm = 0;
  public String groupId = "";
  public int netType = 0;
  public int oWb = -1;
  
  public a$l()
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
    if (this.oWb != -1) {
      paramb.bx(4, this.oWb);
    }
    if (this.LGb != 0) {
      paramb.by(5, this.LGb);
    }
    if (this.netType != 0) {
      paramb.by(6, this.netType);
    }
    if (this.LGm != 0) {
      paramb.bx(7, this.LGm);
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
    if (this.oWb != -1) {
      j = i + b.bz(4, this.oWb);
    }
    i = j;
    if (this.LGb != 0) {
      i = j + b.bA(5, this.LGb);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.bA(6, this.netType);
    }
    i = j;
    if (this.LGm != 0) {
      i = j + b.bz(7, this.LGm);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */