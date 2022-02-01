package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$ao
  extends e
{
  public int abwJ = 0;
  public byte[] buffer = g.dXB;
  
  public a$ao()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.cG(1, this.abwJ);
    if (!Arrays.equals(this.buffer, g.dXB)) {
      paramb.b(2, this.buffer);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc() + b.cK(1, this.abwJ);
    int i = j;
    if (!Arrays.equals(this.buffer, g.dXB)) {
      i = j + b.c(2, this.buffer);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ao
 * JD-Core Version:    0.7.0.1
 */