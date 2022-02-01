package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$bf
  extends e
{
  public a.ao ahgQ = null;
  public int type = 0;
  
  public a$bf()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.cF(1, this.type);
    }
    if (this.ahgQ != null) {
      paramb.a(2, this.ahgQ);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.type != 0) {
      i = j + b.cJ(1, this.type);
    }
    j = i;
    if (this.ahgQ != null) {
      j = i + b.b(2, this.ahgQ);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bf
 * JD-Core Version:    0.7.0.1
 */