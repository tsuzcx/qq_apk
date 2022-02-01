package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$o
  extends e
{
  private static volatile o[] LGv;
  public int LGw = 0;
  public int LGx = 0;
  public byte[] dxo = g.bQV;
  
  public a$o()
  {
    this.bQO = -1;
  }
  
  public static o[] fSX()
  {
    if (LGv == null) {}
    synchronized (c.bQN)
    {
      if (LGv == null) {
        LGv = new o[0];
      }
      return LGv;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.LGw != 0) {
      paramb.bx(1, this.LGw);
    }
    if (!Arrays.equals(this.dxo, g.bQV)) {
      paramb.b(2, this.dxo);
    }
    if (this.LGx != 0) {
      paramb.by(3, this.LGx);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.LGw != 0) {
      i = j + b.bz(1, this.LGw);
    }
    j = i;
    if (!Arrays.equals(this.dxo, g.bQV)) {
      j = i + b.c(2, this.dxo);
    }
    i = j;
    if (this.LGx != 0) {
      i = j + b.bA(3, this.LGx);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */