package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$z
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public a.ay ZeS = null;
  public a.ba[] Zgp = a.ba.ikV();
  public String groupId = "";
  
  public a$z()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(1, this.groupId);
    }
    j = i;
    if (this.NOc != 0) {
      j = i + b.bM(2, this.NOc);
    }
    i = j;
    if (this.NOd != 0L) {
      i = j + b.p(3, this.NOd);
    }
    j = i;
    if (this.Zgp != null)
    {
      j = i;
      if (this.Zgp.length > 0)
      {
        j = 0;
        while (j < this.Zgp.length)
        {
          a.ba localba = this.Zgp[j];
          int k = i;
          if (localba != null) {
            k = i + b.b(4, localba);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ZeS != null) {
      i = j + b.b(5, this.ZeS);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    if ((this.Zgp != null) && (this.Zgp.length > 0))
    {
      int i = 0;
      while (i < this.Zgp.length)
      {
        a.ba localba = this.Zgp[i];
        if (localba != null) {
          paramb.a(4, localba);
        }
        i += 1;
      }
    }
    if (this.ZeS != null) {
      paramb.a(5, this.ZeS);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.z
 * JD-Core Version:    0.7.0.1
 */