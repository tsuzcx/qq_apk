package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;

public final class a$az
  extends e
{
  private static volatile az[] wJr;
  public int timestamp = 0;
  public int wJs = 0;
  public int wJt = 0;
  public int wJu = 0;
  public int wJv = 0;
  
  public a$az()
  {
    this.aUI = -1;
  }
  
  public static az[] cOh()
  {
    if (wJr == null) {}
    synchronized (c.aUH)
    {
      if (wJr == null) {
        wJr = new az[0];
      }
      return wJr;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.timestamp != 0) {
      paramb.aL(1, this.timestamp);
    }
    if (this.wJs != 0) {
      paramb.aL(2, this.wJs);
    }
    if (this.wJt != 0) {
      paramb.aL(3, this.wJt);
    }
    if (this.wJu != 0) {
      paramb.aL(4, this.wJu);
    }
    if (this.wJv != 0) {
      paramb.aL(5, this.wJv);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.timestamp != 0) {
      i = j + b.aN(1, this.timestamp);
    }
    j = i;
    if (this.wJs != 0) {
      j = i + b.aN(2, this.wJs);
    }
    i = j;
    if (this.wJt != 0) {
      i = j + b.aN(3, this.wJt);
    }
    j = i;
    if (this.wJu != 0) {
      j = i + b.aN(4, this.wJu);
    }
    i = j;
    if (this.wJv != 0) {
      i = j + b.aN(5, this.wJv);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.az
 * JD-Core Version:    0.7.0.1
 */