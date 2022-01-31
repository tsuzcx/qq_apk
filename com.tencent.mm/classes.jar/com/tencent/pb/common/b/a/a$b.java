package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$b
  extends e
{
  public String BdG = "";
  public int aXG = 0;
  
  public a$b()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.BdG.equals("")) {
      paramb.e(1, this.BdG);
    }
    if (this.aXG != 0) {
      paramb.bj(2, this.aXG);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.BdG.equals("")) {
      i = j + b.f(1, this.BdG);
    }
    j = i;
    if (this.aXG != 0) {
      j = i + b.bl(2, this.aXG);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */