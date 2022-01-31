package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$r
  extends e
{
  public a.am[] Bev = a.am.dTN();
  
  public a$r()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.Bev != null) && (this.Bev.length > 0))
    {
      int i = 0;
      while (i < this.Bev.length)
      {
        a.am localam = this.Bev[i];
        if (localam != null) {
          paramb.a(1, localam);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int i = super.sz();
    int k = i;
    if (this.Bev != null)
    {
      k = i;
      if (this.Bev.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.Bev.length) {
            break;
          }
          a.am localam = this.Bev[j];
          k = i;
          if (localam != null) {
            k = i + b.b(1, localam);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.r
 * JD-Core Version:    0.7.0.1
 */