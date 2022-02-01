package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$al
  extends e
{
  public a.az[] ahfo = a.az.jRl();
  
  public a$al()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.ahfo != null) && (this.ahfo.length > 0))
    {
      int i = 0;
      while (i < this.ahfo.length)
      {
        a.az localaz = this.ahfo[i];
        if (localaz != null) {
          paramb.a(1, localaz);
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
    if (this.ahfo != null)
    {
      k = i;
      if (this.ahfo.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.ahfo.length) {
            break;
          }
          a.az localaz = this.ahfo[j];
          k = i;
          if (localaz != null) {
            k = i + b.b(1, localaz);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.al
 * JD-Core Version:    0.7.0.1
 */