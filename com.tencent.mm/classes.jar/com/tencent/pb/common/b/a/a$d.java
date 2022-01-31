package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$d
  extends e
{
  public int netType = 0;
  public String wGf = "";
  public a.at wGh = null;
  public int[] wGi = g.aUJ;
  public a.ba wGj = null;
  public int wGk = 0;
  public int wGl = 0;
  public a.ay wGm = null;
  public String wGn = "";
  public String[] wGo = g.EMPTY_STRING_ARRAY;
  public a.m[] wGp = a.m.cNX();
  public int wGq = 0;
  
  public a$d()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.wGh != null) {
      paramb.a(1, this.wGh);
    }
    int i;
    if ((this.wGi != null) && (this.wGi.length > 0))
    {
      i = 0;
      while (i < this.wGi.length)
      {
        paramb.aM(2, this.wGi[i]);
        i += 1;
      }
    }
    if (this.wGj != null) {
      paramb.a(3, this.wGj);
    }
    if (this.wGk != 0) {
      paramb.aM(4, this.wGk);
    }
    if (this.wGl != 0) {
      paramb.aM(5, this.wGl);
    }
    if (this.wGm != null) {
      paramb.a(6, this.wGm);
    }
    if (!this.wGf.equals("")) {
      paramb.d(7, this.wGf);
    }
    if (!this.wGn.equals("")) {
      paramb.d(8, this.wGn);
    }
    if (this.netType != 0) {
      paramb.aM(9, this.netType);
    }
    Object localObject;
    if ((this.wGo != null) && (this.wGo.length > 0))
    {
      i = 0;
      while (i < this.wGo.length)
      {
        localObject = this.wGo[i];
        if (localObject != null) {
          paramb.d(100, (String)localObject);
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
    if (this.wGh != null) {
      i = j + b.b(1, this.wGh);
    }
    j = i;
    if (this.wGi != null)
    {
      j = i;
      if (this.wGi.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.wGi.length)
        {
          k += b.dS(this.wGi[j]);
          j += 1;
        }
        j = i + k + this.wGi.length * 1;
      }
    }
    i = j;
    if (this.wGj != null) {
      i = j + b.b(3, this.wGj);
    }
    j = i;
    if (this.wGk != 0) {
      j = i + b.aO(4, this.wGk);
    }
    i = j;
    if (this.wGl != 0) {
      i = j + b.aO(5, this.wGl);
    }
    j = i;
    if (this.wGm != null) {
      j = i + b.b(6, this.wGm);
    }
    i = j;
    if (!this.wGf.equals("")) {
      i = j + b.e(7, this.wGf);
    }
    int k = i;
    if (!this.wGn.equals("")) {
      k = i + b.e(8, this.wGn);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.aO(9, this.netType);
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
    if (this.wGq != 0) {
      i = j + b.aO(240, this.wGq);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */