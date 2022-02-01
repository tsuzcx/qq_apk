package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$c
  extends e
{
  public a.y[] ZeR = a.y.ikO();
  
  public a$c()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int i = super.JG();
    int k = i;
    if (this.ZeR != null)
    {
      k = i;
      if (this.ZeR.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.ZeR.length) {
            break;
          }
          a.y localy = this.ZeR[j];
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
    if ((this.ZeR != null) && (this.ZeR.length > 0))
    {
      int i = 0;
      while (i < this.ZeR.length)
      {
        a.y localy = this.ZeR[i];
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