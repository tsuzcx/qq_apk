package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$s
  extends e
{
  public a.ap[] MdQ = a.ap.fXB();
  
  public a$s()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.MdQ != null) && (this.MdQ.length > 0))
    {
      int i = 0;
      while (i < this.MdQ.length)
      {
        a.ap localap = this.MdQ[i];
        if (localap != null) {
          paramb.a(1, localap);
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
    if (this.MdQ != null)
    {
      k = i;
      if (this.MdQ.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.MdQ.length) {
            break;
          }
          a.ap localap = this.MdQ[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.s
 * JD-Core Version:    0.7.0.1
 */