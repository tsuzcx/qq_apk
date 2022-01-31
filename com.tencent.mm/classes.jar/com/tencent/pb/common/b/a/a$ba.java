package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ba
  extends e
{
  public int type = 0;
  public a.al wJw = null;
  
  public a$ba()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.aL(1, this.type);
    }
    if (this.wJw != null) {
      paramb.a(2, this.wJw);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.type != 0) {
      i = j + b.aN(1, this.type);
    }
    j = i;
    if (this.wJw != null) {
      j = i + b.b(2, this.wJw);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ba
 * JD-Core Version:    0.7.0.1
 */