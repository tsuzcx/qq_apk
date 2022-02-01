package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$o
  extends e
{
  private static volatile o[] JMM;
  public int JMN = 0;
  public int JMO = 0;
  public byte[] dlB = g.bGH;
  
  public a$o()
  {
    this.bGA = -1;
  }
  
  public static o[] fBI()
  {
    if (JMM == null) {}
    synchronized (c.bGz)
    {
      if (JMM == null) {
        JMM = new o[0];
      }
      return JMM;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.JMN != 0) {
      paramb.bv(1, this.JMN);
    }
    if (!Arrays.equals(this.dlB, g.bGH)) {
      paramb.b(2, this.dlB);
    }
    if (this.JMO != 0) {
      paramb.bw(3, this.JMO);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.JMN != 0) {
      i = j + b.bx(1, this.JMN);
    }
    j = i;
    if (!Arrays.equals(this.dlB, g.bGH)) {
      j = i + b.c(2, this.dlB);
    }
    i = j;
    if (this.JMO != 0) {
      i = j + b.by(3, this.JMO);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.o
 * JD-Core Version:    0.7.0.1
 */