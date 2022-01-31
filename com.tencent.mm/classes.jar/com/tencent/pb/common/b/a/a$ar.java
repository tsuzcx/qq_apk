package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ar
  extends e
{
  private static volatile ar[] BfF;
  public int BfG = 0;
  public int BfH = 0;
  public byte[] BfI = g.bhf;
  
  public a$ar()
  {
    this.bgY = -1;
  }
  
  public static ar[] dTP()
  {
    if (BfF == null) {}
    synchronized (c.bgX)
    {
      if (BfF == null) {
        BfF = new ar[0];
      }
      return BfF;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.BfG != 0) {
      paramb.bj(1, this.BfG);
    }
    if (this.BfH != 0) {
      paramb.bj(2, this.BfH);
    }
    if (!Arrays.equals(this.BfI, g.bhf)) {
      paramb.b(3, this.BfI);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (this.BfG != 0) {
      i = j + b.bl(1, this.BfG);
    }
    j = i;
    if (this.BfH != 0) {
      j = i + b.bl(2, this.BfH);
    }
    i = j;
    if (!Arrays.equals(this.BfI, g.bhf)) {
      i = j + b.c(3, this.BfI);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ar
 * JD-Core Version:    0.7.0.1
 */