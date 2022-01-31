package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$al
  extends e
{
  public byte[] buffer = g.bhf;
  public int iLen = 0;
  
  public a$al()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.bk(1, this.iLen);
    if (!Arrays.equals(this.buffer, g.bhf)) {
      paramb.b(2, this.buffer);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz() + b.bm(1, this.iLen);
    int i = j;
    if (!Arrays.equals(this.buffer, g.bhf)) {
      i = j + b.c(2, this.buffer);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.al
 * JD-Core Version:    0.7.0.1
 */