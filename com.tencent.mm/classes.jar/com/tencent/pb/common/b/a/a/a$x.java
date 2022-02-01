package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$x
  extends e
{
  private static volatile x[] JND;
  public String JNE = "";
  public String JNF = "";
  
  public a$x()
  {
    this.bGA = -1;
  }
  
  public static x[] fBK()
  {
    if (JND == null) {}
    synchronized (c.bGz)
    {
      if (JND == null) {
        JND = new x[0];
      }
      return JND;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.JNE.equals("")) {
      paramb.d(1, this.JNE);
    }
    if (!this.JNF.equals("")) {
      paramb.d(2, this.JNF);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.JNE.equals("")) {
      i = j + b.e(1, this.JNE);
    }
    j = i;
    if (!this.JNF.equals("")) {
      j = i + b.e(2, this.JNF);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */