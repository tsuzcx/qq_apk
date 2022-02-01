package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$n
  extends e
{
  private static volatile n[] IkZ;
  public int CrQ = 0;
  public String Ila = "";
  public String nickname = "";
  
  public a$n()
  {
    this.bIS = -1;
  }
  
  public static n[] flq()
  {
    if (IkZ == null) {}
    synchronized (c.bIR)
    {
      if (IkZ == null) {
        IkZ = new n[0];
      }
      return IkZ;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.CrQ != 0) {
      paramb.bz(1, this.CrQ);
    }
    if (!this.nickname.equals("")) {
      paramb.d(2, this.nickname);
    }
    if (!this.Ila.equals("")) {
      paramb.d(3, this.Ila);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.CrQ != 0) {
      i = j + b.bB(1, this.CrQ);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.e(2, this.nickname);
    }
    i = j;
    if (!this.Ila.equals("")) {
      i = j + b.e(3, this.Ila);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */