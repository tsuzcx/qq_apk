package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$e
  extends e
{
  public int BdE = 0;
  public a.at BdI = null;
  public a.ba BdK = null;
  public int BdM = 0;
  public String[] BdP = g.EMPTY_STRING_ARRAY;
  public a.m[] BdQ = a.m.dTJ();
  public int BdR = 0;
  public int BdS = 0;
  public a.s BdT = null;
  public int BdU = 0;
  public String groupId = "";
  public int netType = 0;
  public int twP = 0;
  public long twQ = 0L;
  
  public a$e()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    if (this.BdK != null) {
      paramb.a(4, this.BdK);
    }
    if (this.BdS != 0) {
      paramb.bj(5, this.BdS);
    }
    if (this.BdM != 0) {
      paramb.bk(6, this.BdM);
    }
    if (this.BdE != 0) {
      paramb.bj(7, this.BdE);
    }
    if (this.netType != 0) {
      paramb.bk(8, this.netType);
    }
    if (this.BdI != null) {
      paramb.a(200, this.BdI);
    }
    int i;
    Object localObject;
    if ((this.BdP != null) && (this.BdP.length > 0))
    {
      i = 0;
      while (i < this.BdP.length)
      {
        localObject = this.BdP[i];
        if (localObject != null) {
          paramb.e(201, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.BdQ != null) && (this.BdQ.length > 0))
    {
      i = j;
      while (i < this.BdQ.length)
      {
        localObject = this.BdQ[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.BdT != null) {
      paramb.a(203, this.BdT);
    }
    if (this.BdU != 0) {
      paramb.bk(204, this.BdU);
    }
    if (this.BdR != 0) {
      paramb.bk(240, this.BdR);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int i2 = 0;
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    j = i;
    if (this.BdK != null) {
      j = i + b.b(4, this.BdK);
    }
    i = j;
    if (this.BdS != 0) {
      i = j + b.bl(5, this.BdS);
    }
    j = i;
    if (this.BdM != 0) {
      j = i + b.bm(6, this.BdM);
    }
    i = j;
    if (this.BdE != 0) {
      i = j + b.bl(7, this.BdE);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.bm(8, this.netType);
    }
    j = k;
    if (this.BdI != null) {
      j = k + b.b(200, this.BdI);
    }
    i = j;
    Object localObject;
    if (this.BdP != null)
    {
      i = j;
      if (this.BdP.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.BdP.length; m = n)
        {
          localObject = this.BdP[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.bf((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.BdQ != null)
    {
      j = i;
      if (this.BdQ.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.BdQ.length) {
            break;
          }
          localObject = this.BdQ[k];
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
    if (this.BdT != null) {
      i = j + b.b(203, this.BdT);
    }
    j = i;
    if (this.BdU != 0) {
      j = i + b.bm(204, this.BdU);
    }
    i = j;
    if (this.BdR != 0) {
      i = j + b.bm(240, this.BdR);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */