package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$e
  extends e
{
  public String groupId = "";
  public int netType = 0;
  public int pRI = 0;
  public long pRJ = 0L;
  public int wGd = 0;
  public a.at wGh = null;
  public a.ba wGj = null;
  public int wGl = 0;
  public String[] wGo = g.EMPTY_STRING_ARRAY;
  public a.m[] wGp = a.m.cNX();
  public int wGq = 0;
  public int wGr = 0;
  public a.s wGs = null;
  public int wGt = 0;
  
  public a$e()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.pRI != 0) {
      paramb.aL(2, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(3, this.pRJ);
    }
    if (this.wGj != null) {
      paramb.a(4, this.wGj);
    }
    if (this.wGr != 0) {
      paramb.aL(5, this.wGr);
    }
    if (this.wGl != 0) {
      paramb.aM(6, this.wGl);
    }
    if (this.wGd != 0) {
      paramb.aL(7, this.wGd);
    }
    if (this.netType != 0) {
      paramb.aM(8, this.netType);
    }
    if (this.wGh != null) {
      paramb.a(200, this.wGh);
    }
    int i;
    Object localObject;
    if ((this.wGo != null) && (this.wGo.length > 0))
    {
      i = 0;
      while (i < this.wGo.length)
      {
        localObject = this.wGo[i];
        if (localObject != null) {
          paramb.d(201, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.wGp != null) && (this.wGp.length > 0))
    {
      i = j;
      while (i < this.wGp.length)
      {
        localObject = this.wGp[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wGs != null) {
      paramb.a(203, this.wGs);
    }
    if (this.wGt != 0) {
      paramb.aM(204, this.wGt);
    }
    if (this.wGq != 0) {
      paramb.aM(240, this.wGq);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int i2 = 0;
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
    if (this.wGj != null) {
      j = i + b.b(4, this.wGj);
    }
    i = j;
    if (this.wGr != 0) {
      i = j + b.aN(5, this.wGr);
    }
    j = i;
    if (this.wGl != 0) {
      j = i + b.aO(6, this.wGl);
    }
    i = j;
    if (this.wGd != 0) {
      i = j + b.aN(7, this.wGd);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.aO(8, this.netType);
    }
    j = k;
    if (this.wGh != null) {
      j = k + b.b(200, this.wGh);
    }
    i = j;
    Object localObject;
    if (this.wGo != null)
    {
      i = j;
      if (this.wGo.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.wGo.length; m = n)
        {
          localObject = this.wGo[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.aI((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.wGp != null)
    {
      j = i;
      if (this.wGp.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.wGp.length) {
            break;
          }
          localObject = this.wGp[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(202, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.wGs != null) {
      i = j + b.b(203, this.wGs);
    }
    j = i;
    if (this.wGt != 0) {
      j = i + b.aO(204, this.wGt);
    }
    i = j;
    if (this.wGq != 0) {
      i = j + b.aO(240, this.wGq);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */