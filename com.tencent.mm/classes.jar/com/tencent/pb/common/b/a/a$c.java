package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$c
  extends e
{
  public a.w[] wGg = a.w.cOa();
  
  public a$c()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.wGg != null) && (this.wGg.length > 0))
    {
      int i = 0;
      while (i < this.wGg.length)
      {
        a.w localw = this.wGg[i];
        if (localw != null) {
          paramb.a(1, localw);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int i = super.oQ();
    int k = i;
    if (this.wGg != null)
    {
      k = i;
      if (this.wGg.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.wGg.length) {
            break;
          }
          a.w localw = this.wGg[j];
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