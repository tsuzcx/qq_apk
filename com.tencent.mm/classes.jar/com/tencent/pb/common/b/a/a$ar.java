package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ar
  extends e
{
  private static volatile ar[] wIf;
  public int wIg = 0;
  public int wIh = 0;
  public byte[] wIi = g.aUP;
  
  public a$ar()
  {
    this.aUI = -1;
  }
  
  public static ar[] cOd()
  {
    if (wIf == null) {}
    synchronized (c.aUH)
    {
      if (wIf == null) {
        wIf = new ar[0];
      }
      return wIf;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wIg != 0) {
      paramb.aL(1, this.wIg);
    }
    if (this.wIh != 0) {
      paramb.aL(2, this.wIh);
    }
    if (!Arrays.equals(this.wIi, g.aUP)) {
      paramb.b(3, this.wIi);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.wIg != 0) {
      i = j + b.aN(1, this.wIg);
    }
    j = i;
    if (this.wIh != 0) {
      j = i + b.aN(2, this.wIh);
    }
    i = j;
    if (!Arrays.equals(this.wIi, g.aUP)) {
      i = j + b.c(3, this.wIi);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ar
 * JD-Core Version:    0.7.0.1
 */