package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ap
  extends e
{
  public byte[] buffer = g.cbu;
  public int iLen = 0;
  
  public a$ap()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig() + b.bC(1, this.iLen);
    int i = j;
    if (!Arrays.equals(this.buffer, g.cbu)) {
      i = j + b.c(2, this.buffer);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    paramb.bB(1, this.iLen);
    if (!Arrays.equals(this.buffer, g.cbu)) {
      paramb.b(2, this.buffer);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ap
 * JD-Core Version:    0.7.0.1
 */