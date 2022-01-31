package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$c
  extends e
{
  public a.w[] BdH = a.w.dTM();
  
  public a$c()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.BdH != null) && (this.BdH.length > 0))
    {
      int i = 0;
      while (i < this.BdH.length)
      {
        a.w localw = this.BdH[i];
        if (localw != null) {
          paramb.a(1, localw);
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
    if (this.BdH != null)
    {
      k = i;
      if (this.BdH.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.BdH.length) {
            break;
          }
          a.w localw = this.BdH[j];
          k = i;
          if (localw != null) {
            k = i + b.b(1, localw);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */