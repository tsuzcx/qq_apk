package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$al
  extends e
{
  public byte[] buffer = g.aUP;
  public int tFK = 0;
  
  public a$al()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.aM(1, this.tFK);
    if (!Arrays.equals(this.buffer, g.aUP)) {
      paramb.b(2, this.buffer);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ() + b.aO(1, this.tFK);
    int i = j;
    if (!Arrays.equals(this.buffer, g.aUP)) {
      i = j + b.c(2, this.buffer);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.al
 * JD-Core Version:    0.7.0.1
 */