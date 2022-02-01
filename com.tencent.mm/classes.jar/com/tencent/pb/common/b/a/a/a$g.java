package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$g
  extends e
{
  public String IkB = "";
  public int bvJ = 0;
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$g()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.zkT != 0) {
      paramb.by(2, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(3, this.zkU);
    }
    if (this.bvJ != 0) {
      paramb.by(4, this.bvJ);
    }
    if (!this.IkB.equals("")) {
      paramb.d(5, this.IkB);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.zkT != 0) {
      j = i + b.bA(2, this.zkT);
    }
    i = j;
    if (this.zkU != 0L) {
      i = j + b.q(3, this.zkU);
    }
    j = i;
    if (this.bvJ != 0) {
      j = i + b.bA(4, this.bvJ);
    }
    i = j;
    if (!this.IkB.equals("")) {
      i = j + b.e(5, this.IkB);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */