package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.c;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$aw
  extends e
{
  private static volatile aw[] ahfz;
  public int ahfA = 0;
  public int ahfB = 0;
  public byte[] ahfC = g.dXB;
  
  public a$aw()
  {
    this.dXv = -1;
  }
  
  public static aw[] jRk()
  {
    if (ahfz == null) {}
    synchronized (c.dXu)
    {
      if (ahfz == null) {
        ahfz = new aw[0];
      }
      return ahfz;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.ahfA != 0) {
      paramb.cF(1, this.ahfA);
    }
    if (this.ahfB != 0) {
      paramb.cF(2, this.ahfB);
    }
    if (!Arrays.equals(this.ahfC, g.dXB)) {
      paramb.b(3, this.ahfC);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.ahfA != 0) {
      i = j + b.cJ(1, this.ahfA);
    }
    j = i;
    if (this.ahfB != 0) {
      j = i + b.cJ(2, this.ahfB);
    }
    i = j;
    if (!Arrays.equals(this.ahfC, g.dXB)) {
      i = j + b.c(3, this.ahfC);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aw
 * JD-Core Version:    0.7.0.1
 */