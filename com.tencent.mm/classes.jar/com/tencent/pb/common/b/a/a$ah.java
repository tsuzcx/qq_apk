package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ah
  extends e
{
  public a.au[] Bfw = a.au.dTQ();
  
  public a$ah()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.Bfw != null) && (this.Bfw.length > 0))
    {
      int i = 0;
      while (i < this.Bfw.length)
      {
        a.au localau = this.Bfw[i];
        if (localau != null) {
          paramb.a(1, localau);
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
    if (this.Bfw != null)
    {
      k = i;
      if (this.Bfw.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.Bfw.length) {
            break;
          }
          a.au localau = this.Bfw[j];
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