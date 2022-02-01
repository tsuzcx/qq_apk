package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$x
  extends e
{
  private static volatile x[] LHm;
  public String LHn = "";
  public String LHo = "";
  
  public a$x()
  {
    this.bQO = -1;
  }
  
  public static x[] fSZ()
  {
    if (LHm == null) {}
    synchronized (c.bQN)
    {
      if (LHm == null) {
        LHm = new x[0];
      }
      return LHm;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.LHn.equals("")) {
      paramb.d(1, this.LHn);
    }
    if (!this.LHo.equals("")) {
      paramb.d(2, this.LHo);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.LHn.equals("")) {
      i = j + b.e(1, this.LHn);
    }
    j = i;
    if (!this.LHo.equals("")) {
      j = i + b.e(2, this.LHo);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */