package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ax
  extends e
{
  private static volatile ax[] Inj;
  public int IkG = 0;
  public a.ay[] IlV = a.ay.flz();
  public String Ink = "";
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$ax()
  {
    this.bIS = -1;
  }
  
  public static ax[] fly()
  {
    if (Inj == null) {}
    synchronized (c.bIR)
    {
      if (Inj == null) {
        Inj = new ax[0];
      }
      return Inj;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.zkT != 0) {
      paramb.by(2, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(3, this.zkU);
    }
    if ((this.IlV != null) && (this.IlV.length > 0))
    {
      int i = 0;
      while (i < this.IlV.length)
      {
        a.ay localay = this.IlV[i];
        if (localay != null) {
          paramb.a(4, localay);
        }
        i += 1;
      }
    }
    if (this.IkG != 0) {
      paramb.bz(5, this.IkG);
    }
    if (!this.Ink.equals("")) {
      paramb.d(6, this.Ink);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.zkT != 0) {
      j = i + b.bA(2, this.zkT);
    }
    i = j;
    if (this.zkU != 0L) {
      i = j + b.q(3, this.zkU);
    }
    j = i;
    if (this.IlV != null)
    {
      j = i;
      if (this.IlV.length > 0)
      {
        j = 0;
        while (j < this.IlV.length)
        {
          a.ay localay = this.IlV[j];
          int k = i;
          if (localay != null) {
            k = i + b.b(4, localay);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.IkG != 0) {
      i = j + b.bB(5, this.IkG);
    }
    j = i;
    if (!this.Ink.equals("")) {
      j = i + b.e(6, this.Ink);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ax
 * JD-Core Version:    0.7.0.1
 */