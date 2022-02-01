package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ao
  extends e
{
  public int Ufv = 0;
  public byte[] buffer = g.ccX;
  
  public a$ao()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG() + b.bN(1, this.Ufv);
    int i = j;
    if (!Arrays.equals(this.buffer, g.ccX)) {
      i = j + b.c(2, this.buffer);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    paramb.bK(1, this.Ufv);
    if (!Arrays.equals(this.buffer, g.ccX)) {
      paramb.b(2, this.buffer);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ao
 * JD-Core Version:    0.7.0.1
 */