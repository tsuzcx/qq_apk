package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$k
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public a.bd LFZ = null;
  public int LGb = 0;
  public byte[] LGl = g.bQV;
  public String groupId = "";
  
  public a$k()
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
    if (this.LFZ != null) {
      paramb.a(4, this.LFZ);
    }
    if (this.LGb != 0) {
      paramb.by(5, this.LGb);
    }
    if (!Arrays.equals(this.LGl, g.bQV)) {
      paramb.b(200, this.LGl);
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
    if (this.LFZ != null) {
      j = i + b.b(4, this.LFZ);
    }
    i = j;
    if (this.LGb != 0) {
      i = j + b.bA(5, this.LGb);
    }
    j = i;
    if (!Arrays.equals(this.LGl, g.bQV)) {
      j = i + b.c(200, this.LGl);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */