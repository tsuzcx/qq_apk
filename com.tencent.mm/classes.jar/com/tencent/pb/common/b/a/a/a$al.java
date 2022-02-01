package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$al
  extends e
{
  public a.ba[] RFi = a.ba.hjk();
  
  public a$al()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int i = super.Ig();
    int k = i;
    if (this.RFi != null)
    {
      k = i;
      if (this.RFi.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.RFi.length) {
            break;
          }
          a.ba localba = this.RFi[j];
          k = i;
          if (localba != null) {
            k = i + b.b(1, localba);
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
    if ((this.RFi != null) && (this.RFi.length > 0))
    {
      int i = 0;
      while (i < this.RFi.length)
      {
        a.ba localba = this.RFi[i];
        if (localba != null) {
          paramb.a(1, localba);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.al
 * JD-Core Version:    0.7.0.1
 */