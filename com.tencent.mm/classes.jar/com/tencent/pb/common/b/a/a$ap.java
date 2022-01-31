package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ap
  extends e
{
  public int BfD = 0;
  public int BfE = 0;
  
  public a$ap()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.BfD != 0) {
      paramb.bj(1, this.BfD);
    }
    if (this.BfE != 0) {
      paramb.bj(2, this.BfE);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.BfD != 0) {
      i = j + b.bl(1, this.BfD);
    }
    j = i;
    if (this.BfE != 0) {
      j = i + b.bl(2, this.BfE);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ap
 * JD-Core Version:    0.7.0.1
 */