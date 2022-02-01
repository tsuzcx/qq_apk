package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$t
  extends e
{
  public a.ar[] ahep = a.ar.jRi();
  
  public a$t()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.ahep != null) && (this.ahep.length > 0))
    {
      int i = 0;
      while (i < this.ahep.length)
      {
        a.ar localar = this.ahep[i];
        if (localar != null) {
          paramb.a(1, localar);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int i = super.akc();
    int k = i;
    if (this.ahep != null)
    {
      k = i;
      if (this.ahep.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.ahep.length) {
            break;
          }
          a.ar localar = this.ahep[j];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.t
 * JD-Core Version:    0.7.0.1
 */