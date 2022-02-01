package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$w
  extends e
{
  public a.v IlR = null;
  public byte[] body = g.bIZ;
  
  public a$w()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.IlR != null) {
      paramb.a(1, this.IlR);
    }
    if (!Arrays.equals(this.body, g.bIZ)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.IlR != null) {
      i = j + b.b(1, this.IlR);
    }
    j = i;
    if (!Arrays.equals(this.body, g.bIZ)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.w
 * JD-Core Version:    0.7.0.1
 */