package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$d
  extends e
{
  public String RDo = "";
  public a.az RDq = null;
  public int[] RDr = g.bYn;
  public a.bg RDs = null;
  public int RDt = 0;
  public int RDu = 0;
  public a.be RDv = null;
  public String RDw = "";
  public String[] RDx = g.EMPTY_STRING_ARRAY;
  public a.o[] RDy = a.o.hjb();
  public int RDz = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int i2 = 0;
    int j = super.Ig();
    int i = j;
    if (this.RDq != null) {
      i = j + b.b(1, this.RDq);
    }
    j = i;
    if (this.RDr != null)
    {
      j = i;
      if (this.RDr.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.RDr.length)
        {
          k += b.fY(this.RDr[j]);
          j += 1;
        }
        j = i + k + this.RDr.length * 1;
      }
    }
    i = j;
    if (this.RDs != null) {
      i = j + b.b(3, this.RDs);
    }
    j = i;
    if (this.RDt != 0) {
      j = i + b.bC(4, this.RDt);
    }
    i = j;
    if (this.RDu != 0) {
      i = j + b.bC(5, this.RDu);
    }
    j = i;
    if (this.RDv != null) {
      j = i + b.b(6, this.RDv);
    }
    i = j;
    if (!this.RDo.equals("")) {
      i = j + b.f(7, this.RDo);
    }
    int k = i;
    if (!this.RDw.equals("")) {
      k = i + b.f(8, this.RDw);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.bC(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.RDx != null)
    {
      i = j;
      if (this.RDx.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.RDx.length; m = n)
        {
          localObject = this.RDx[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cb((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.RDy != null)
    {
      j = i;
      if (this.RDy.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.RDy.length) {
            break;
          }
          localObject = this.RDy[k];
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
    if (this.RDz != 0) {
      i = j + b.bC(240, this.RDz);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.RDq != null) {
      paramb.a(1, this.RDq);
    }
    int i;
    if ((this.RDr != null) && (this.RDr.length > 0))
    {
      i = 0;
      while (i < this.RDr.length)
      {
        paramb.bB(2, this.RDr[i]);
        i += 1;
      }
    }
    if (this.RDs != null) {
      paramb.a(3, this.RDs);
    }
    if (this.RDt != 0) {
      paramb.bB(4, this.RDt);
    }
    if (this.RDu != 0) {
      paramb.bB(5, this.RDu);
    }
    if (this.RDv != null) {
      paramb.a(6, this.RDv);
    }
    if (!this.RDo.equals("")) {
      paramb.e(7, this.RDo);
    }
    if (!this.RDw.equals("")) {
      paramb.e(8, this.RDw);
    }
    if (this.netType != 0) {
      paramb.bB(9, this.netType);
    }
    Object localObject;
    if ((this.RDx != null) && (this.RDx.length > 0))
    {
      i = 0;
      while (i < this.RDx.length)
      {
        localObject = this.RDx[i];
        if (localObject != null) {
          paramb.e(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.RDy != null) && (this.RDy.length > 0))
    {
      i = j;
      while (i < this.RDy.length)
      {
        localObject = this.RDy[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDz != 0) {
      paramb.bB(240, this.RDz);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */