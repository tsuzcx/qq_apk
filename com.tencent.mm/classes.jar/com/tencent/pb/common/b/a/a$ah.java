package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ah
  extends e
{
  public a.au[] wHW = a.au.cOe();
  
  public a$ah()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.wHW != null) && (this.wHW.length > 0))
    {
      int i = 0;
      while (i < this.wHW.length)
      {
        a.au localau = this.wHW[i];
        if (localau != null) {
          paramb.a(1, localau);
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
    if (this.wHW != null)
    {
      k = i;
      if (this.wHW.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.wHW.length) {
            break;
          }
          a.au localau = this.wHW[j];
          k = i;
          if (localau != null) {
            k = i + b.b(1, localau);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.ah
 * JD-Core Version:    0.7.0.1
 */