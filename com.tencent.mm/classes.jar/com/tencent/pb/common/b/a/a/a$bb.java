package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bb
  extends e
{
  public int InM = 0;
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$bb()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.zkT != 0) {
      paramb.by(1, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(2, this.zkU);
    }
    if (this.InM != 0) {
      paramb.bz(3, this.InM);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.zkT != 0) {
      i = j + b.bA(1, this.zkT);
    }
    j = i;
    if (this.zkU != 0L) {
      j = i + b.q(2, this.zkU);
    }
    i = j;
    if (this.InM != 0) {
      i = j + b.bB(3, this.InM);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bb
 * JD-Core Version:    0.7.0.1
 */