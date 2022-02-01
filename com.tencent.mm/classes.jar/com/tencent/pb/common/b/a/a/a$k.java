package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$k
  extends e
{
  public a.bd IkF = null;
  public int IkH = 0;
  public byte[] IkR = g.bIZ;
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$k()
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
    if (this.IkF != null) {
      paramb.a(4, this.IkF);
    }
    if (this.IkH != 0) {
      paramb.bz(5, this.IkH);
    }
    if (!Arrays.equals(this.IkR, g.bIZ)) {
      paramb.b(200, this.IkR);
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
    if (this.IkF != null) {
      j = i + b.b(4, this.IkF);
    }
    i = j;
    if (this.IkH != 0) {
      i = j + b.bB(5, this.IkH);
    }
    j = i;
    if (!Arrays.equals(this.IkR, g.bIZ)) {
      j = i + b.c(200, this.IkR);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */