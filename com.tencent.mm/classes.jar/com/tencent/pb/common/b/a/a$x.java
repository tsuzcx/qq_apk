package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$x
  extends e
{
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public a.at wGh = null;
  public a.av[] wHz = a.av.cOf();
  
  public a$x()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.pRI != 0) {
      paramb.aL(2, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(3, this.pRJ);
    }
    if ((this.wHz != null) && (this.wHz.length > 0))
    {
      int i = 0;
      while (i < this.wHz.length)
      {
        a.av localav = this.wHz[i];
        if (localav != null) {
          paramb.a(4, localav);
        }
        i += 1;
      }
    }
    if (this.wGh != null) {
      paramb.a(5, this.wGh);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.pRI != 0) {
      j = i + b.aN(2, this.pRI);
    }
    i = j;
    if (this.pRJ != 0L) {
      i = j + b.k(3, this.pRJ);
    }
    j = i;
    if (this.wHz != null)
    {
      j = i;
      if (this.wHz.length > 0)
      {
        j = 0;
        while (j < this.wHz.length)
        {
          a.av localav = this.wHz[j];
          int k = i;
          if (localav != null) {
            k = i + b.b(4, localav);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.wGh != null) {
      i = j + b.b(5, this.wGh);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.x
 * JD-Core Version:    0.7.0.1
 */