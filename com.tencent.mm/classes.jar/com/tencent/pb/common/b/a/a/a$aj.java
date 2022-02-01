package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aj
  extends e
{
  public a.ax[] JOc = a.ax.fBP();
  
  public a$aj()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.JOc != null) && (this.JOc.length > 0))
    {
      int i = 0;
      while (i < this.JOc.length)
      {
        a.ax localax = this.JOc[i];
        if (localax != null) {
          paramb.a(1, localax);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int i = super.xT();
    int k = i;
    if (this.JOc != null)
    {
      k = i;
      if (this.JOc.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.JOc.length) {
            break;
          }
          a.ax localax = this.JOc[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aj
 * JD-Core Version:    0.7.0.1
 */