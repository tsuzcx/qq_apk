package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ai
  extends e
{
  public int roomId = 0;
  public long ypH = 0L;
  
  public a$ai()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.roomId != 0) {
      i = j + b.bu(1, this.roomId);
    }
    j = i;
    if (this.ypH != 0L) {
      j = i + b.r(2, this.ypH);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.roomId != 0) {
      paramb.bs(1, this.roomId);
    }
    if (this.ypH != 0L) {
      paramb.q(2, this.ypH);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ai
 * JD-Core Version:    0.7.0.1
 */