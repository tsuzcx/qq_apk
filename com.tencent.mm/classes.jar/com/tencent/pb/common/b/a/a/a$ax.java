package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ax
  extends e
{
  private static volatile ax[] MfJ;
  public int Cuf = 0;
  public long Cug = 0L;
  public int Mde = 0;
  public a.ay[] Met = a.ay.fXF();
  public String MfK = "";
  public String groupId = "";
  
  public a$ax()
  {
    this.bQO = -1;
  }
  
  public static ax[] fXE()
  {
    if (MfJ == null) {}
    synchronized (c.bQN)
    {
      if (MfJ == null) {
        MfJ = new ax[0];
      }
      return MfJ;
    }
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(2, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(3, this.Cug);
    }
    if ((this.Met != null) && (this.Met.length > 0))
    {
      int i = 0;
      while (i < this.Met.length)
      {
        a.ay localay = this.Met[i];
        if (localay != null) {
          paramb.a(4, localay);
        }
        i += 1;
      }
    }
    if (this.Mde != 0) {
      paramb.by(5, this.Mde);
    }
    if (!this.MfK.equals("")) {
      paramb.d(6, this.MfK);
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
    if (this.Cuf != 0) {
      j = i + b.bz(2, this.Cuf);
    }
    i = j;
    if (this.Cug != 0L) {
      i = j + b.p(3, this.Cug);
    }
    j = i;
    if (this.Met != null)
    {
      j = i;
      if (this.Met.length > 0)
      {
        j = 0;
        while (j < this.Met.length)
        {
          a.ay localay = this.Met[j];
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
    if (this.Mde != 0) {
      i = j + b.bA(5, this.Mde);
    }
    j = i;
    if (!this.MfK.equals("")) {
      j = i + b.e(6, this.MfK);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ax
 * JD-Core Version:    0.7.0.1
 */