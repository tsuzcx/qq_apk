package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$s
  extends e
{
  public a.ap[] JNd = a.ap.fBM();
  
  public a$s()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.JNd != null) && (this.JNd.length > 0))
    {
      int i = 0;
      while (i < this.JNd.length)
      {
        a.ap localap = this.JNd[i];
        if (localap != null) {
          paramb.a(1, localap);
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
    if (this.JNd != null)
    {
      k = i;
      if (this.JNd.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.JNd.length) {
            break;
          }
          a.ap localap = this.JNd[j];
          k = i;
          if (localap != null) {
            k = i + b.b(1, localap);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.s
 * JD-Core Version:    0.7.0.1
 */