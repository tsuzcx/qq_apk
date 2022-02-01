package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$au
  extends e
{
  public int ZgW = 0;
  public int ZgX = 0;
  
  public a$au()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.ZgW != 0) {
      i = j + b.bM(1, this.ZgW);
    }
    j = i;
    if (this.ZgX != 0) {
      j = i + b.bM(2, this.ZgX);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.ZgW != 0) {
      paramb.bJ(1, this.ZgW);
    }
    if (this.ZgX != 0) {
      paramb.bJ(2, this.ZgX);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */