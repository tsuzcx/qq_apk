package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$at
  extends e
{
  public int RFo = 0;
  public long jii = 0L;
  public int jlm = 0;
  
  public a$at()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.jii != 0L) {
      i = j + b.p(1, this.jii);
    }
    j = i;
    if (this.jlm != 0) {
      j = i + b.bC(2, this.jlm);
    }
    i = j;
    if (this.RFo != 0) {
      i = j + b.bC(3, this.RFo);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.jii != 0L) {
      paramb.n(1, this.jii);
    }
    if (this.jlm != 0) {
      paramb.bB(2, this.jlm);
    }
    if (this.RFo != 0) {
      paramb.bB(3, this.RFo);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.at
 * JD-Core Version:    0.7.0.1
 */