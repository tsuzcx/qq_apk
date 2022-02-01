package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$t
  extends e
{
  public a.ar[] ZfN = a.ar.ikR();
  
  public a$t()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int i = super.JG();
    int k = i;
    if (this.ZfN != null)
    {
      k = i;
      if (this.ZfN.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.ZfN.length) {
            break;
          }
          a.ar localar = this.ZfN[j];
          k = i;
          if (localar != null) {
            k = i + b.b(1, localar);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(b paramb)
  {
    if ((this.ZfN != null) && (this.ZfN.length > 0))
    {
      int i = 0;
      while (i < this.ZfN.length)
      {
        a.ar localar = this.ZfN[i];
        if (localar != null) {
          paramb.a(1, localar);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.t
 * JD-Core Version:    0.7.0.1
 */