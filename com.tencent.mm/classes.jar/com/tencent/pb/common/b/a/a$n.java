package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$n
  extends e
{
  private static volatile n[] wGE;
  public byte[] bQK = g.aUP;
  public int wGF = 0;
  public int wGG = 0;
  
  public a$n()
  {
    this.aUI = -1;
  }
  
  public static n[] cNY()
  {
    if (wGE == null) {}
    synchronized (c.aUH)
    {
      if (wGE == null) {
        wGE = new n[0];
      }
      return wGE;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.wGF != 0) {
      paramb.aL(1, this.wGF);
    }
    if (!Arrays.equals(this.bQK, g.aUP)) {
      paramb.b(2, this.bQK);
    }
    if (this.wGG != 0) {
      paramb.aM(3, this.wGG);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.wGF != 0) {
      i = j + b.aN(1, this.wGF);
    }
    j = i;
    if (!Arrays.equals(this.bQK, g.aUP)) {
      j = i + b.c(2, this.bQK);
    }
    i = j;
    if (this.wGG != 0) {
      i = j + b.aO(3, this.wGG);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */