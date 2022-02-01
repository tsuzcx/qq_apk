package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$c
  extends e
{
  public a.y[] RDp = a.y.hje();
  
  public a$c()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int i = super.Ig();
    int k = i;
    if (this.RDp != null)
    {
      k = i;
      if (this.RDp.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.RDp.length) {
            break;
          }
          a.y localy = this.RDp[j];
          k = i;
          if (localy != null) {
            k = i + b.b(1, localy);
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
    if ((this.RDp != null) && (this.RDp.length > 0))
    {
      int i = 0;
      while (i < this.RDp.length)
      {
        a.y localy = this.RDp[i];
        if (localy != null) {
          paramb.a(1, localy);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */