package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$c
  extends e
{
  public a.x[] JMn = a.x.fBK();
  
  public a$c()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if ((this.JMn != null) && (this.JMn.length > 0))
    {
      int i = 0;
      while (i < this.JMn.length)
      {
        a.x localx = this.JMn[i];
        if (localx != null) {
          paramb.a(1, localx);
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
    if (this.JMn != null)
    {
      k = i;
      if (this.JMn.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.JMn.length) {
            break;
          }
          a.x localx = this.JMn[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */