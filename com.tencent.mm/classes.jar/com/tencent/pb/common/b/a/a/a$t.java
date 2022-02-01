package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$t
  extends e
{
  public a.as[] REg = a.as.hjh();
  
  public a$t()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int i = super.Ig();
    int k = i;
    if (this.REg != null)
    {
      k = i;
      if (this.REg.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.REg.length) {
            break;
          }
          a.as localas = this.REg[j];
          k = i;
          if (localas != null) {
            k = i + b.b(1, localas);
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
    if ((this.REg != null) && (this.REg.length > 0))
    {
      int i = 0;
      while (i < this.REg.length)
      {
        a.as localas = this.REg[i];
        if (localas != null) {
          paramb.a(1, localas);
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