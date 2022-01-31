package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$n
  extends e
{
  private static volatile n[] Bef;
  public int Beg = 0;
  public int Beh = 0;
  public byte[] cyk = g.bhf;
  
  public a$n()
  {
    this.bgY = -1;
  }
  
  public static n[] dTK()
  {
    if (Bef == null) {}
    synchronized (c.bgX)
    {
      if (Bef == null) {
        Bef = new n[0];
      }
      return Bef;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.Beg != 0) {
      paramb.bj(1, this.Beg);
    }
    if (!Arrays.equals(this.cyk, g.bhf)) {
      paramb.b(2, this.cyk);
    }
    if (this.Beh != 0) {
      paramb.bk(3, this.Beh);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.Beg != 0) {
      i = j + b.bl(1, this.Beg);
    }
    j = i;
    if (!Arrays.equals(this.cyk, g.bhf)) {
      j = i + b.c(2, this.cyk);
    }
    i = j;
    if (this.Beh != 0) {
      i = j + b.bm(3, this.Beh);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */