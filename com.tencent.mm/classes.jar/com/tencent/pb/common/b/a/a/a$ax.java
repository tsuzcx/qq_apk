package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ax
  extends e
{
  private static volatile ax[] LIF;
  public int CcE = 0;
  public long CcF = 0L;
  public int LGa = 0;
  public a.ay[] LHp = a.ay.fTf();
  public String LIG = "";
  public String groupId = "";
  
  public a$ax()
  {
    this.bQO = -1;
  }
  
  public static ax[] fTe()
  {
    if (LIF == null) {}
    synchronized (c.bQN)
    {
      if (LIF == null) {
        LIF = new ax[0];
      }
      return LIF;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.CcE != 0) {
      paramb.bx(2, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(3, this.CcF);
    }
    if ((this.LHp != null) && (this.LHp.length > 0))
    {
      int i = 0;
      while (i < this.LHp.length)
      {
        a.ay localay = this.LHp[i];
        if (localay != null) {
          paramb.a(4, localay);
        }
        i += 1;
      }
    }
    if (this.LGa != 0) {
      paramb.by(5, this.LGa);
    }
    if (!this.LIG.equals("")) {
      paramb.d(6, this.LIG);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.CcE != 0) {
      j = i + b.bz(2, this.CcE);
    }
    i = j;
    if (this.CcF != 0L) {
      i = j + b.p(3, this.CcF);
    }
    j = i;
    if (this.LHp != null)
    {
      j = i;
      if (this.LHp.length > 0)
      {
        j = 0;
        while (j < this.LHp.length)
        {
          a.ay localay = this.LHp[j];
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
    if (this.LGa != 0) {
      i = j + b.bA(5, this.LGa);
    }
    j = i;
    if (!this.LIG.equals("")) {
      j = i + b.e(6, this.LIG);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ax
 * JD-Core Version:    0.7.0.1
 */