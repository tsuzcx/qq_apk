package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$w
  extends e
{
  public a.v LHl = null;
  public byte[] body = g.bQV;
  
  public a$w()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.LHl != null) {
      paramb.a(1, this.LHl);
    }
    if (!Arrays.equals(this.body, g.bQV)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.LHl != null) {
      i = j + b.b(1, this.LHl);
    }
    j = i;
    if (!Arrays.equals(this.body, g.bQV)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.w
 * JD-Core Version:    0.7.0.1
 */