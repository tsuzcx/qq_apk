package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$x
  extends e
{
  public a.w aheO = null;
  public byte[] body = g.dXB;
  
  public a$x()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.aheO != null) {
      paramb.a(1, this.aheO);
    }
    if (!Arrays.equals(this.body, g.dXB)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.aheO != null) {
      i = j + b.b(1, this.aheO);
    }
    j = i;
    if (!Arrays.equals(this.body, g.dXB)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */