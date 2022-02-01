package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$b
  extends e
{
  public String JMm = "";
  public int reason = 0;
  
  public a$b()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.JMm.equals("")) {
      paramb.d(1, this.JMm);
    }
    if (this.reason != 0) {
      paramb.bv(2, this.reason);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.JMm.equals("")) {
      i = j + b.e(1, this.JMm);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.bx(2, this.reason);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */