package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$p
  extends e
{
  private static volatile p[] ahdY;
  public int ahdZ = 0;
  public int ahea = 0;
  public byte[] hOU = g.dXB;
  
  public a$p()
  {
    this.dXv = -1;
  }
  
  public static p[] jRd()
  {
    if (ahdY == null) {}
    synchronized (c.dXu)
    {
      if (ahdY == null) {
        ahdY = new p[0];
      }
      return ahdY;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.ahdZ != 0) {
      paramb.cF(1, this.ahdZ);
    }
    if (!Arrays.equals(this.hOU, g.dXB)) {
      paramb.b(2, this.hOU);
    }
    if (this.ahea != 0) {
      paramb.cG(3, this.ahea);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.ahdZ != 0) {
      i = j + b.cJ(1, this.ahdZ);
    }
    j = i;
    if (!Arrays.equals(this.hOU, g.dXB)) {
      j = i + b.c(2, this.hOU);
    }
    i = j;
    if (this.ahea != 0) {
      i = j + b.cK(3, this.ahea);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */