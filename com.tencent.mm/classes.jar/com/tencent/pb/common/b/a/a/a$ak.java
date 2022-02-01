package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;

public final class a$ak
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public a.ay ahdv = null;
  public a.ba[] aheQ = a.ba.jRm();
  public a.q[] aheR = a.q.jRe();
  public a.bb[] aheS = a.bb.jRn();
  public int aheT = 0;
  public int[] aheU = g.dTZ;
  public a.ax aheh = null;
  public a.ba[] ahen = a.ba.jRm();
  public String groupId = "";
  
  public a$ak()
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
    int i;
    Object localObject;
    if ((this.aheR != null) && (this.aheR.length > 0))
    {
      i = 0;
      while (i < this.aheR.length)
      {
        localObject = this.aheR[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheh != null) {
      paramb.a(5, this.aheh);
    }
    if (this.aheT != 0) {
      paramb.cF(6, this.aheT);
    }
    if ((this.aheU != null) && (this.aheU.length > 0))
    {
      i = 0;
      while (i < this.aheU.length)
      {
        paramb.cF(7, this.aheU[i]);
        i += 1;
      }
    }
    if ((this.aheQ != null) && (this.aheQ.length > 0))
    {
      i = 0;
      while (i < this.aheQ.length)
      {
        localObject = this.aheQ[i];
        if (localObject != null) {
          paramb.a(200, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.aheS != null) && (this.aheS.length > 0))
    {
      i = 0;
      while (i < this.aheS.length)
      {
        localObject = this.aheS[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ahdv != null) {
      paramb.a(202, this.ahdv);
    }
    if ((this.ahen != null) && (this.ahen.length > 0))
    {
      i = j;
      while (i < this.ahen.length)
      {
        localObject = this.ahen[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int m = 0;
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
    Object localObject;
    if (this.aheR != null)
    {
      j = i;
      if (this.aheR.length > 0)
      {
        j = 0;
        while (j < this.aheR.length)
        {
          localObject = this.aheR[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(4, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.aheh != null) {
      i = j + b.b(5, this.aheh);
    }
    j = i;
    if (this.aheT != 0) {
      j = i + b.cJ(6, this.aheT);
    }
    i = j;
    if (this.aheU != null)
    {
      i = j;
      if (this.aheU.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.aheU.length)
        {
          k += b.kp(this.aheU[i]);
          i += 1;
        }
        i = j + k + this.aheU.length * 1;
      }
    }
    j = i;
    if (this.aheQ != null)
    {
      j = i;
      if (this.aheQ.length > 0)
      {
        j = 0;
        while (j < this.aheQ.length)
        {
          localObject = this.aheQ[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(200, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.aheS != null)
    {
      k = j;
      if (this.aheS.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.aheS.length)
        {
          localObject = this.aheS[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(201, (e)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (this.ahdv != null) {
      i = k + b.b(202, this.ahdv);
    }
    k = i;
    if (this.ahen != null)
    {
      k = i;
      if (this.ahen.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.ahen.length) {
            break;
          }
          localObject = this.ahen[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(203, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ak
 * JD-Core Version:    0.7.0.1
 */