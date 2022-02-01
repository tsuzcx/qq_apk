package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$o
  extends e
{
  private static volatile o[] Mdz;
  public int MdA = 0;
  public int MdB = 0;
  public byte[] dyt = g.bQV;
  
  public a$o()
  {
    this.bQO = -1;
  }
  
  public static o[] fXx()
  {
    if (Mdz == null) {}
    synchronized (c.bQN)
    {
      if (Mdz == null) {
        Mdz = new o[0];
      }
      return Mdz;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.MdA != 0) {
      paramb.bx(1, this.MdA);
    }
    if (!Arrays.equals(this.dyt, g.bQV)) {
      paramb.b(2, this.dyt);
    }
    if (this.MdB != 0) {
      paramb.by(3, this.MdB);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.MdA != 0) {
      i = j + b.bz(1, this.MdA);
    }
    j = i;
    if (!Arrays.equals(this.dyt, g.bQV)) {
      j = i + b.c(2, this.dyt);
    }
    i = j;
    if (this.MdB != 0) {
      i = j + b.bA(3, this.MdB);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */