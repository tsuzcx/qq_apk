package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ap
  extends e
{
  public int wId = 0;
  public int wIe = 0;
  
  public a$ap()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.wId != 0) {
      paramb.aL(1, this.wId);
    }
    if (this.wIe != 0) {
      paramb.aL(2, this.wIe);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.wId != 0) {
      i = j + b.aN(1, this.wId);
    }
    j = i;
    if (this.wIe != 0) {
      j = i + b.aN(2, this.wIe);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ap
 * JD-Core Version:    0.7.0.1
 */