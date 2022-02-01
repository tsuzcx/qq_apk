package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$l
  extends e
{
  public int IkH = 0;
  public int IkS = 0;
  public String groupId = "";
  public int nPB = -1;
  public int netType = 0;
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$l()
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
    if (this.nPB != -1) {
      paramb.by(4, this.nPB);
    }
    if (this.IkH != 0) {
      paramb.bz(5, this.IkH);
    }
    if (this.netType != 0) {
      paramb.bz(6, this.netType);
    }
    if (this.IkS != 0) {
      paramb.by(7, this.IkS);
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
    if (this.nPB != -1) {
      j = i + b.bA(4, this.nPB);
    }
    i = j;
    if (this.IkH != 0) {
      i = j + b.bB(5, this.IkH);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.bB(6, this.netType);
    }
    i = j;
    if (this.IkS != 0) {
      i = j + b.bA(7, this.IkS);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */