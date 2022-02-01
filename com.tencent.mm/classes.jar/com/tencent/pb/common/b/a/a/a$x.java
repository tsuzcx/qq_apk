package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$x
  extends e
{
  public a.w REH = null;
  public byte[] body = g.cbu;
  
  public a$x()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.REH != null) {
      i = j + b.b(1, this.REH);
    }
    j = i;
    if (!Arrays.equals(this.body, g.cbu)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.REH != null) {
      paramb.a(1, this.REH);
    }
    if (!Arrays.equals(this.body, g.cbu)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */