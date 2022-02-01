package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$d
  extends e
{
  public String McZ = "";
  public a.aw Mdb = null;
  public int[] Mdc = g.bQP;
  public a.bd Mdd = null;
  public int Mde = 0;
  public int Mdf = 0;
  public a.bb Mdg = null;
  public String Mdh = "";
  public String[] Mdi = g.EMPTY_STRING_ARRAY;
  public a.n[] Mdj = a.n.fXw();
  public int Mdk = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.Mdb != null) {
      paramb.a(1, this.Mdb);
    }
    int i;
    if ((this.Mdc != null) && (this.Mdc.length > 0))
    {
      i = 0;
      while (i < this.Mdc.length)
      {
        paramb.by(2, this.Mdc[i]);
        i += 1;
      }
    }
    if (this.Mdd != null) {
      paramb.a(3, this.Mdd);
    }
    if (this.Mde != 0) {
      paramb.by(4, this.Mde);
    }
    if (this.Mdf != 0) {
      paramb.by(5, this.Mdf);
    }
    if (this.Mdg != null) {
      paramb.a(6, this.Mdg);
    }
    if (!this.McZ.equals("")) {
      paramb.d(7, this.McZ);
    }
    if (!this.Mdh.equals("")) {
      paramb.d(8, this.Mdh);
    }
    if (this.netType != 0) {
      paramb.by(9, this.netType);
    }
    Object localObject;
    if ((this.Mdi != null) && (this.Mdi.length > 0))
    {
      i = 0;
      while (i < this.Mdi.length)
      {
        localObject = this.Mdi[i];
        if (localObject != null) {
          paramb.d(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.Mdj != null) && (this.Mdj.length > 0))
    {
      i = j;
      while (i < this.Mdj.length)
      {
        localObject = this.Mdj[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Mdk != 0) {
      paramb.by(240, this.Mdk);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int i2 = 0;
    int j = super.zq();
    int i = j;
    if (this.Mdb != null) {
      i = j + b.b(1, this.Mdb);
    }
    j = i;
    if (this.Mdc != null)
    {
      j = i;
      if (this.Mdc.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Mdc.length)
        {
          k += b.fP(this.Mdc[j]);
          j += 1;
        }
        j = i + k + this.Mdc.length * 1;
      }
    }
    i = j;
    if (this.Mdd != null) {
      i = j + b.b(3, this.Mdd);
    }
    j = i;
    if (this.Mde != 0) {
      j = i + b.bA(4, this.Mde);
    }
    i = j;
    if (this.Mdf != 0) {
      i = j + b.bA(5, this.Mdf);
    }
    j = i;
    if (this.Mdg != null) {
      j = i + b.b(6, this.Mdg);
    }
    i = j;
    if (!this.McZ.equals("")) {
      i = j + b.e(7, this.McZ);
    }
    int k = i;
    if (!this.Mdh.equals("")) {
      k = i + b.e(8, this.Mdh);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.bA(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.Mdi != null)
    {
      i = j;
      if (this.Mdi.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.Mdi.length; m = n)
        {
          localObject = this.Mdi[i];
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
    if (this.Mdj != null)
    {
      j = i;
      if (this.Mdj.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.Mdj.length) {
            break;
          }
          localObject = this.Mdj[k];
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
    if (this.Mdk != 0) {
      i = j + b.bA(240, this.Mdk);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */