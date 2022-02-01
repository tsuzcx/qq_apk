package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$d
  extends e
{
  public String LFV = "";
  public a.aw LFX = null;
  public int[] LFY = g.bQP;
  public a.bd LFZ = null;
  public int LGa = 0;
  public int LGb = 0;
  public a.bb LGc = null;
  public String LGd = "";
  public String[] LGe = g.EMPTY_STRING_ARRAY;
  public a.n[] LGf = a.n.fSW();
  public int LGg = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.LFX != null) {
      paramb.a(1, this.LFX);
    }
    int i;
    if ((this.LFY != null) && (this.LFY.length > 0))
    {
      i = 0;
      while (i < this.LFY.length)
      {
        paramb.by(2, this.LFY[i]);
        i += 1;
      }
    }
    if (this.LFZ != null) {
      paramb.a(3, this.LFZ);
    }
    if (this.LGa != 0) {
      paramb.by(4, this.LGa);
    }
    if (this.LGb != 0) {
      paramb.by(5, this.LGb);
    }
    if (this.LGc != null) {
      paramb.a(6, this.LGc);
    }
    if (!this.LFV.equals("")) {
      paramb.d(7, this.LFV);
    }
    if (!this.LGd.equals("")) {
      paramb.d(8, this.LGd);
    }
    if (this.netType != 0) {
      paramb.by(9, this.netType);
    }
    Object localObject;
    if ((this.LGe != null) && (this.LGe.length > 0))
    {
      i = 0;
      while (i < this.LGe.length)
      {
        localObject = this.LGe[i];
        if (localObject != null) {
          paramb.d(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.LGf != null) && (this.LGf.length > 0))
    {
      i = j;
      while (i < this.LGf.length)
      {
        localObject = this.LGf[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LGg != 0) {
      paramb.by(240, this.LGg);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int i2 = 0;
    int j = super.zq();
    int i = j;
    if (this.LFX != null) {
      i = j + b.b(1, this.LFX);
    }
    j = i;
    if (this.LFY != null)
    {
      j = i;
      if (this.LFY.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.LFY.length)
        {
          k += b.fP(this.LFY[j]);
          j += 1;
        }
        j = i + k + this.LFY.length * 1;
      }
    }
    i = j;
    if (this.LFZ != null) {
      i = j + b.b(3, this.LFZ);
    }
    j = i;
    if (this.LGa != 0) {
      j = i + b.bA(4, this.LGa);
    }
    i = j;
    if (this.LGb != 0) {
      i = j + b.bA(5, this.LGb);
    }
    j = i;
    if (this.LGc != null) {
      j = i + b.b(6, this.LGc);
    }
    i = j;
    if (!this.LFV.equals("")) {
      i = j + b.e(7, this.LFV);
    }
    int k = i;
    if (!this.LGd.equals("")) {
      k = i + b.e(8, this.LGd);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.bA(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.LGe != null)
    {
      i = j;
      if (this.LGe.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.LGe.length; m = n)
        {
          localObject = this.LGe[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cc((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.LGf != null)
    {
      j = i;
      if (this.LGf.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.LGf.length) {
            break;
          }
          localObject = this.LGf[k];
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
    if (this.LGg != 0) {
      i = j + b.bA(240, this.LGg);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */