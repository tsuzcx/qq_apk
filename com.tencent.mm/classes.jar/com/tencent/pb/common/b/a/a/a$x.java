package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$x
  extends e
{
  private static volatile x[] IlS;
  public String IlT = "";
  public String IlU = "";
  
  public a$x()
  {
    this.bIS = -1;
  }
  
  public static x[] flt()
  {
    if (IlS == null) {}
    synchronized (c.bIR)
    {
      if (IlS == null) {
        IlS = new x[0];
      }
      return IlS;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.IlT.equals("")) {
      paramb.d(1, this.IlT);
    }
    if (!this.IlU.equals("")) {
      paramb.d(2, this.IlU);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.IlT.equals("")) {
      i = j + b.e(1, this.IlT);
    }
    j = i;
    if (!this.IlU.equals("")) {
      j = i + b.e(2, this.IlU);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */