package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$az
  extends e
{
  private static volatile az[] BgR;
  public int BgS = 0;
  public int BgT = 0;
  public int BgU = 0;
  public int BgV = 0;
  public int timestamp = 0;
  
  public a$az()
  {
    this.bgY = -1;
  }
  
  public static az[] dTT()
  {
    if (BgR == null) {}
    synchronized (c.bgX)
    {
      if (BgR == null) {
        BgR = new az[0];
      }
      return BgR;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.timestamp != 0) {
      paramb.bj(1, this.timestamp);
    }
    if (this.BgS != 0) {
      paramb.bj(2, this.BgS);
    }
    if (this.BgT != 0) {
      paramb.bj(3, this.BgT);
    }
    if (this.BgU != 0) {
      paramb.bj(4, this.BgU);
    }
    if (this.BgV != 0) {
      paramb.bj(5, this.BgV);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.timestamp != 0) {
      i = j + b.bl(1, this.timestamp);
    }
    j = i;
    if (this.BgS != 0) {
      j = i + b.bl(2, this.BgS);
    }
    i = j;
    if (this.BgT != 0) {
      i = j + b.bl(3, this.BgT);
    }
    j = i;
    if (this.BgU != 0) {
      j = i + b.bl(4, this.BgU);
    }
    i = j;
    if (this.BgV != 0) {
      i = j + b.bl(5, this.BgV);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.az
 * JD-Core Version:    0.7.0.1
 */