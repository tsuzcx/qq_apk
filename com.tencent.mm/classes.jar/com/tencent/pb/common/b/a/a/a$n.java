package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$n
  extends e
{
  private static volatile n[] JMK;
  public int DKi = 0;
  public String JML = "";
  public String nickname = "";
  
  public a$n()
  {
    this.bGA = -1;
  }
  
  public static n[] fBH()
  {
    if (JMK == null) {}
    synchronized (c.bGz)
    {
      if (JMK == null) {
        JMK = new n[0];
      }
      return JMK;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.DKi != 0) {
      paramb.bw(1, this.DKi);
    }
    if (!this.nickname.equals("")) {
      paramb.d(2, this.nickname);
    }
    if (!this.JML.equals("")) {
      paramb.d(3, this.JML);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.DKi != 0) {
      i = j + b.by(1, this.DKi);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.e(2, this.nickname);
    }
    i = j;
    if (!this.JML.equals("")) {
      i = j + b.e(3, this.JML);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */