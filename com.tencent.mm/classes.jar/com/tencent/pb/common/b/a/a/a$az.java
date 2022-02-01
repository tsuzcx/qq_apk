package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$az
  extends e
{
  private static volatile az[] InH;
  public int CrQ = 0;
  public long InI = 0L;
  public String InJ = "";
  public String InK = "";
  public String headUrl = "";
  public String username = "";
  
  public a$az()
  {
    this.bIS = -1;
  }
  
  public static az[] flA()
  {
    if (InH == null) {}
    synchronized (c.bIR)
    {
      if (InH == null) {
        InH = new az[0];
      }
      return InH;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.CrQ != 0) {
      paramb.bz(1, this.CrQ);
    }
    if (!this.username.equals("")) {
      paramb.d(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.d(3, this.headUrl);
    }
    if (this.InI != 0L) {
      paramb.n(4, this.InI);
    }
    if (!this.InJ.equals("")) {
      paramb.d(5, this.InJ);
    }
    if (!this.InK.equals("")) {
      paramb.d(6, this.InK);
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
    if (!this.username.equals("")) {
      j = i + b.e(2, this.username);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + b.e(3, this.headUrl);
    }
    j = i;
    if (this.InI != 0L) {
      j = i + b.p(4, this.InI);
    }
    i = j;
    if (!this.InJ.equals("")) {
      i = j + b.e(5, this.InJ);
    }
    j = i;
    if (!this.InK.equals("")) {
      j = i + b.e(6, this.InK);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.az
 * JD-Core Version:    0.7.0.1
 */