package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$w
  extends e
{
  public a.v JNC = null;
  public byte[] body = g.bGH;
  
  public a$w()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.JNC != null) {
      paramb.a(1, this.JNC);
    }
    if (!Arrays.equals(this.body, g.bGH)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.JNC != null) {
      i = j + b.b(1, this.JNC);
    }
    j = i;
    if (!Arrays.equals(this.body, g.bGH)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.w
 * JD-Core Version:    0.7.0.1
 */