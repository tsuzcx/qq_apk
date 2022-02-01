package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$an
  extends e
{
  public byte[] buffer = g.bQV;
  public int iLen = 0;
  
  public a$an()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.by(1, this.iLen);
    if (!Arrays.equals(this.buffer, g.bQV)) {
      paramb.b(2, this.buffer);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq() + b.bA(1, this.iLen);
    int i = j;
    if (!Arrays.equals(this.buffer, g.bQV)) {
      i = j + b.c(2, this.buffer);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.an
 * JD-Core Version:    0.7.0.1
 */