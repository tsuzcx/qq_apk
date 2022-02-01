package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$al
  extends e
{
  public a.az[] ZgN = a.az.ikU();
  
  public a$al()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int i = super.JG();
    int k = i;
    if (this.ZgN != null)
    {
      k = i;
      if (this.ZgN.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.ZgN.length) {
            break;
          }
          a.az localaz = this.ZgN[j];
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
  
  public final void a(b paramb)
  {
    if ((this.ZgN != null) && (this.ZgN.length > 0))
    {
      int i = 0;
      while (i < this.ZgN.length)
      {
        a.az localaz = this.ZgN[i];
        if (localaz != null) {
          paramb.a(1, localaz);
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