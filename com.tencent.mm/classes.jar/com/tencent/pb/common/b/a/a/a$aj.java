package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$aj
  extends e
{
  public a.ax[] LHM = a.ax.fTe();
  
  public a$aj()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.LHM != null) && (this.LHM.length > 0))
    {
      int i = 0;
      while (i < this.LHM.length)
      {
        a.ax localax = this.LHM[i];
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
    if (this.LHM != null)
    {
      k = i;
      if (this.LHM.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.LHM.length) {
            break;
          }
          a.ax localax = this.LHM[j];
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