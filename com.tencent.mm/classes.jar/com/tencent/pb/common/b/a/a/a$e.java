package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;

public final class a$e
  extends e
{
  public int ACR = 0;
  public int UAZ = 0;
  public long UBa = 0L;
  public String[] ahdC = g.EMPTY_STRING_ARRAY;
  public a.o[] ahdD = a.o.jRc();
  public int ahdE = 0;
  public a.u ahdF = null;
  public int ahdG = 0;
  public int ahdr = 0;
  public a.ay ahdv = null;
  public a.bf ahdx = null;
  public int ahdz = 0;
  public String groupId = "";
  public int netType = 0;
  
  public a$e()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.g(1, this.groupId);
    }
    if (this.UAZ != 0) {
      paramb.cF(2, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(3, this.UBa);
    }
    if (this.ahdx != null) {
      paramb.a(4, this.ahdx);
    }
    if (this.ACR != 0) {
      paramb.cF(5, this.ACR);
    }
    if (this.ahdz != 0) {
      paramb.cG(6, this.ahdz);
    }
    if (this.ahdr != 0) {
      paramb.cF(7, this.ahdr);
    }
    if (this.netType != 0) {
      paramb.cG(8, this.netType);
    }
    if (this.ahdv != null) {
      paramb.a(200, this.ahdv);
    }
    int i;
    Object localObject;
    if ((this.ahdC != null) && (this.ahdC.length > 0))
    {
      i = 0;
      while (i < this.ahdC.length)
      {
        localObject = this.ahdC[i];
        if (localObject != null) {
          paramb.g(201, (String)localObject);
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
    if (this.ahdF != null) {
      paramb.a(203, this.ahdF);
    }
    if (this.ahdG != 0) {
      paramb.cG(204, this.ahdG);
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
    if (!this.groupId.equals("")) {
      i = j + b.h(1, this.groupId);
    }
    j = i;
    if (this.UAZ != 0) {
      j = i + b.cJ(2, this.UAZ);
    }
    i = j;
    if (this.UBa != 0L) {
      i = j + b.q(3, this.UBa);
    }
    j = i;
    if (this.ahdx != null) {
      j = i + b.b(4, this.ahdx);
    }
    i = j;
    if (this.ACR != 0) {
      i = j + b.cJ(5, this.ACR);
    }
    j = i;
    if (this.ahdz != 0) {
      j = i + b.cK(6, this.ahdz);
    }
    i = j;
    if (this.ahdr != 0) {
      i = j + b.cJ(7, this.ahdr);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.cK(8, this.netType);
    }
    j = k;
    if (this.ahdv != null) {
      j = k + b.b(200, this.ahdv);
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
    if (this.ahdF != null) {
      i = j + b.b(203, this.ahdF);
    }
    j = i;
    if (this.ahdG != 0) {
      j = i + b.cK(204, this.ahdG);
    }
    i = j;
    if (this.ahdE != 0) {
      i = j + b.cK(240, this.ahdE);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */