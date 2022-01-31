package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ai
  extends e
{
  public int ret = 0;
  
  public a$ai()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.ret != 0) {
      paramb.bj(1, this.ret);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.ret != 0) {
      i = j + b.bl(1, this.ret);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ai
 * JD-Core Version:    0.7.0.1
 */