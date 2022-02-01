package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$c
  extends e
{
  public a.x[] LFW = a.x.fSZ();
  
  public a$c()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.LFW != null) && (this.LFW.length > 0))
    {
      int i = 0;
      while (i < this.LFW.length)
      {
        a.x localx = this.LFW[i];
        if (localx != null) {
          paramb.a(1, localx);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int i = super.zq();
    int k = i;
    if (this.LFW != null)
    {
      k = i;
      if (this.LFW.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.LFW.length) {
            break;
          }
          a.x localx = this.LFW[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */