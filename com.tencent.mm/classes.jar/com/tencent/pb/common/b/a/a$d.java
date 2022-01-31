package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$d
  extends e
{
  public String BdG = "";
  public a.at BdI = null;
  public int[] BdJ = g.bgZ;
  public a.ba BdK = null;
  public int BdL = 0;
  public int BdM = 0;
  public a.ay BdN = null;
  public String BdO = "";
  public String[] BdP = g.EMPTY_STRING_ARRAY;
  public a.m[] BdQ = a.m.dTJ();
  public int BdR = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.BdI != null) {
      paramb.a(1, this.BdI);
    }
    int i;
    if ((this.BdJ != null) && (this.BdJ.length > 0))
    {
      i = 0;
      while (i < this.BdJ.length)
      {
        paramb.bk(2, this.BdJ[i]);
        i += 1;
      }
    }
    if (this.BdK != null) {
      paramb.a(3, this.BdK);
    }
    if (this.BdL != 0) {
      paramb.bk(4, this.BdL);
    }
    if (this.BdM != 0) {
      paramb.bk(5, this.BdM);
    }
    if (this.BdN != null) {
      paramb.a(6, this.BdN);
    }
    if (!this.BdG.equals("")) {
      paramb.e(7, this.BdG);
    }
    if (!this.BdO.equals("")) {
      paramb.e(8, this.BdO);
    }
    if (this.netType != 0) {
      paramb.bk(9, this.netType);
    }
    Object localObject;
    if ((this.BdP != null) && (this.BdP.length > 0))
    {
      i = 0;
      while (i < this.BdP.length)
      {
        localObject = this.BdP[i];
        if (localObject != null) {
          paramb.e(100, (String)localObject);
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
    if (this.BdI != null) {
      i = j + b.b(1, this.BdI);
    }
    j = i;
    if (this.BdJ != null)
    {
      j = i;
      if (this.BdJ.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.BdJ.length)
        {
          k += b.eY(this.BdJ[j]);
          j += 1;
        }
        j = i + k + this.BdJ.length * 1;
      }
    }
    i = j;
    if (this.BdK != null) {
      i = j + b.b(3, this.BdK);
    }
    j = i;
    if (this.BdL != 0) {
      j = i + b.bm(4, this.BdL);
    }
    i = j;
    if (this.BdM != 0) {
      i = j + b.bm(5, this.BdM);
    }
    j = i;
    if (this.BdN != null) {
      j = i + b.b(6, this.BdN);
    }
    i = j;
    if (!this.BdG.equals("")) {
      i = j + b.f(7, this.BdG);
    }
    int k = i;
    if (!this.BdO.equals("")) {
      k = i + b.f(8, this.BdO);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.bm(9, this.netType);
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
    if (this.BdR != 0) {
      i = j + b.bm(240, this.BdR);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */