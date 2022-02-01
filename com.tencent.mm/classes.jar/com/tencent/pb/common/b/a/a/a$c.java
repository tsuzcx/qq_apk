package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$c
  extends e
{
  public a.x[] IkC = a.x.flt();
  
  public a$c()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.IkC != null) && (this.IkC.length > 0))
    {
      int i = 0;
      while (i < this.IkC.length)
      {
        a.x localx = this.IkC[i];
        if (localx != null) {
          paramb.a(1, localx);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int i = super.yg();
    int k = i;
    if (this.IkC != null)
    {
      k = i;
      if (this.IkC.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.IkC.length) {
            break;
          }
          a.x localx = this.IkC[j];
          k = i;
          if (localx != null) {
            k = i + b.b(1, localx);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */