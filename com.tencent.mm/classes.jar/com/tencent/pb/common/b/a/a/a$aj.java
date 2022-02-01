package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aj
  extends e
{
  public a.ax[] MeQ = a.ax.fXE();
  
  public a$aj()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.MeQ != null) && (this.MeQ.length > 0))
    {
      int i = 0;
      while (i < this.MeQ.length)
      {
        a.ax localax = this.MeQ[i];
        if (localax != null) {
          paramb.a(1, localax);
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
    if (this.MeQ != null)
    {
      k = i;
      if (this.MeQ.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.MeQ.length) {
            break;
          }
          a.ax localax = this.MeQ[j];
          k = i;
          if (localax != null) {
            k = i + b.b(1, localax);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aj
 * JD-Core Version:    0.7.0.1
 */