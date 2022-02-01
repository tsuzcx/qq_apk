package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ag
  extends e
{
  public long DPJ = 0L;
  public int roomId = 0;
  
  public a$ag()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.roomId != 0) {
      i = j + b.bM(1, this.roomId);
    }
    j = i;
    if (this.DPJ != 0L) {
      j = i + b.p(2, this.DPJ);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.roomId != 0) {
      paramb.bJ(1, this.roomId);
    }
    if (this.DPJ != 0L) {
      paramb.r(2, this.DPJ);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ag
 * JD-Core Version:    0.7.0.1
 */