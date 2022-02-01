package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$aw
  extends e
{
  private static volatile aw[] ZgY;
  public int ZgZ = 0;
  public int Zha = 0;
  public byte[] Zhb = g.ccX;
  
  public a$aw()
  {
    this.ccR = -1;
  }
  
  public static aw[] ikT()
  {
    if (ZgY == null) {}
    synchronized (c.ccQ)
    {
      if (ZgY == null) {
        ZgY = new aw[0];
      }
      return ZgY;
    }
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.ZgZ != 0) {
      i = j + b.bM(1, this.ZgZ);
    }
    j = i;
    if (this.Zha != 0) {
      j = i + b.bM(2, this.Zha);
    }
    i = j;
    if (!Arrays.equals(this.Zhb, g.ccX)) {
      i = j + b.c(3, this.Zhb);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.ZgZ != 0) {
      paramb.bJ(1, this.ZgZ);
    }
    if (this.Zha != 0) {
      paramb.bJ(2, this.Zha);
    }
    if (!Arrays.equals(this.Zhb, g.ccX)) {
      paramb.b(3, this.Zhb);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aw
 * JD-Core Version:    0.7.0.1
 */