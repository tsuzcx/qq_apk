package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$o
  extends e
{
  private static volatile o[] wGH;
  public int port = 0;
  public int wGI = 0;
  
  public a$o()
  {
    this.aUI = -1;
  }
  
  public static o[] cNZ()
  {
    if (wGH == null) {}
    synchronized (c.aUH)
    {
      if (wGH == null) {
        wGH = new o[0];
      }
      return wGH;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wGI != 0) {
      paramb.aM(1, this.wGI);
    }
    if (this.port != 0) {
      paramb.aL(2, this.port);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.wGI != 0) {
      i = j + b.aO(1, this.wGI);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.aN(2, this.port);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.o
 * JD-Core Version:    0.7.0.1
 */