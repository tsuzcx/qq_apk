package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$y
  extends e
{
  public String BdG = "";
  
  public a$y()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.BdG.equals("")) {
      paramb.e(1, this.BdG);
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
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.y
 * JD-Core Version:    0.7.0.1
 */