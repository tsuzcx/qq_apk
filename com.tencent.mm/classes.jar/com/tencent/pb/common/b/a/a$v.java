package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$v
  extends e
{
  public byte[] body = g.aUP;
  public a.u wHv = null;
  
  public a$v()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.wHv != null) {
      paramb.a(1, this.wHv);
    }
    if (!Arrays.equals(this.body, g.aUP)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.wHv != null) {
      i = j + b.b(1, this.wHv);
    }
    j = i;
    if (!Arrays.equals(this.body, g.aUP)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.v
 * JD-Core Version:    0.7.0.1
 */