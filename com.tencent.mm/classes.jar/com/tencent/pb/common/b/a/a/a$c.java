package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$c
  extends e
{
  public a.y[] ahdu = a.y.jRf();
  
  public a$c()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.ahdu != null) && (this.ahdu.length > 0))
    {
      int i = 0;
      while (i < this.ahdu.length)
      {
        a.y localy = this.ahdu[i];
        if (localy != null) {
          paramb.a(1, localy);
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
    if (this.ahdu != null)
    {
      k = i;
      if (this.ahdu.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.ahdu.length) {
            break;
          }
          a.y localy = this.ahdu[j];
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */