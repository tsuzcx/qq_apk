package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$x
  extends e
{
  private static volatile x[] Meq;
  public String Mer = "";
  public String Mes = "";
  
  public a$x()
  {
    this.bQO = -1;
  }
  
  public static x[] fXz()
  {
    if (Meq == null) {}
    synchronized (c.bQN)
    {
      if (Meq == null) {
        Meq = new x[0];
      }
      return Meq;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.Mer.equals("")) {
      paramb.d(1, this.Mer);
    }
    if (!this.Mes.equals("")) {
      paramb.d(2, this.Mes);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.Mer.equals("")) {
      i = j + b.e(1, this.Mer);
    }
    j = i;
    if (!this.Mes.equals("")) {
      j = i + b.e(2, this.Mes);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */