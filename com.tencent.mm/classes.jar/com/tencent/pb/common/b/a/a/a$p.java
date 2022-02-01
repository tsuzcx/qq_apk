package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$p
  extends e
{
  private static volatile p[] JMP;
  public int JMQ = 0;
  public String JMR = "";
  public int port = 0;
  
  public a$p()
  {
    this.bGA = -1;
  }
  
  public static p[] fBJ()
  {
    if (JMP == null) {}
    synchronized (c.bGz)
    {
      if (JMP == null) {
        JMP = new p[0];
      }
      return JMP;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.JMQ != 0) {
      paramb.bw(1, this.JMQ);
    }
    if (this.port != 0) {
      paramb.bv(2, this.port);
    }
    if (!this.JMR.equals("")) {
      paramb.d(3, this.JMR);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.JMQ != 0) {
      i = j + b.by(1, this.JMQ);
    }
    j = i;
    if (this.port != 0) {
      j = i + b.bx(2, this.port);
    }
    i = j;
    if (!this.JMR.equals("")) {
      i = j + b.e(3, this.JMR);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.p
 * JD-Core Version:    0.7.0.1
 */