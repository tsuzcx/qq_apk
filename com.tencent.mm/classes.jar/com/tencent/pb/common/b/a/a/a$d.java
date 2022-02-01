package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;

public final class a$d
  extends e
{
  public a.bd ahdA = null;
  public String ahdB = "";
  public String[] ahdC = g.EMPTY_STRING_ARRAY;
  public a.o[] ahdD = a.o.jRc();
  public int ahdE = 0;
  public String ahdt = "";
  public a.ay ahdv = null;
  public int[] ahdw = g.dTZ;
  public a.bf ahdx = null;
  public int ahdy = 0;
  public int ahdz = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.ahdv != null) {
      paramb.a(1, this.ahdv);
    }
    int i;
    if ((this.ahdw != null) && (this.ahdw.length > 0))
    {
      i = 0;
      while (i < this.ahdw.length)
      {
        paramb.cG(2, this.ahdw[i]);
        i += 1;
      }
    }
    if (this.ahdx != null) {
      paramb.a(3, this.ahdx);
    }
    if (this.ahdy != 0) {
      paramb.cG(4, this.ahdy);
    }
    if (this.ahdz != 0) {
      paramb.cG(5, this.ahdz);
    }
    if (this.ahdA != null) {
      paramb.a(6, this.ahdA);
    }
    if (!this.ahdt.equals("")) {
      paramb.g(7, this.ahdt);
    }
    if (!this.ahdB.equals("")) {
      paramb.g(8, this.ahdB);
    }
    if (this.netType != 0) {
      paramb.cG(9, this.netType);
    }
    Object localObject;
    if ((this.ahdC != null) && (this.ahdC.length > 0))
    {
      i = 0;
      while (i < this.ahdC.length)
      {
        localObject = this.ahdC[i];
        if (localObject != null) {
          paramb.g(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.ahdD != null) && (this.ahdD.length > 0))
    {
      i = j;
      while (i < this.ahdD.length)
      {
        localObject = this.ahdD[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ahdE != 0) {
      paramb.cG(240, this.ahdE);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int i2 = 0;
    int j = super.akc();
    int i = j;
    if (this.ahdv != null) {
      i = j + b.b(1, this.ahdv);
    }
    j = i;
    if (this.ahdw != null)
    {
      j = i;
      if (this.ahdw.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ahdw.length)
        {
          k += b.kv(this.ahdw[j]);
          j += 1;
        }
        j = i + k + this.ahdw.length * 1;
      }
    }
    i = j;
    if (this.ahdx != null) {
      i = j + b.b(3, this.ahdx);
    }
    j = i;
    if (this.ahdy != 0) {
      j = i + b.cK(4, this.ahdy);
    }
    i = j;
    if (this.ahdz != 0) {
      i = j + b.cK(5, this.ahdz);
    }
    j = i;
    if (this.ahdA != null) {
      j = i + b.b(6, this.ahdA);
    }
    i = j;
    if (!this.ahdt.equals("")) {
      i = j + b.h(7, this.ahdt);
    }
    int k = i;
    if (!this.ahdB.equals("")) {
      k = i + b.h(8, this.ahdB);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.cK(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.ahdC != null)
    {
      i = j;
      if (this.ahdC.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.ahdC.length; m = n)
        {
          localObject = this.ahdC[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.dU((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.ahdD != null)
    {
      j = i;
      if (this.ahdD.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.ahdD.length) {
            break;
          }
          localObject = this.ahdD[k];
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
    if (this.ahdE != 0) {
      i = j + b.cK(240, this.ahdE);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */