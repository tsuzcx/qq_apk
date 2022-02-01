package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;

public final class a$bg
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int ahdy = 0;
  public a.ba[] aheQ = a.ba.jRm();
  public int ahgR = 0;
  public String ahgS = "";
  public String[] ahgT = g.EMPTY_STRING_ARRAY;
  public long ahgU = 0L;
  public String ahgj = "";
  public String groupId = "";
  
  public a$bg()
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
    if (this.ahdy != 0) {
      paramb.cG(4, this.ahdy);
    }
    if (this.ahgR != 0) {
      paramb.cF(5, this.ahgR);
    }
    if (!this.ahgj.equals("")) {
      paramb.g(6, this.ahgj);
    }
    int i;
    Object localObject;
    if ((this.aheQ != null) && (this.aheQ.length > 0))
    {
      i = 0;
      while (i < this.aheQ.length)
      {
        localObject = this.aheQ[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.ahgS.equals("")) {
      paramb.g(8, this.ahgS);
    }
    if ((this.ahgT != null) && (this.ahgT.length > 0))
    {
      i = j;
      while (i < this.ahgT.length)
      {
        localObject = this.ahgT[i];
        if (localObject != null) {
          paramb.g(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.ahgU != 0L) {
      paramb.n(10, this.ahgU);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
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
    if (this.ahdy != 0) {
      j = i + b.cK(4, this.ahdy);
    }
    int k = j;
    if (this.ahgR != 0) {
      k = j + b.cJ(5, this.ahgR);
    }
    i = k;
    if (!this.ahgj.equals("")) {
      i = k + b.h(6, this.ahgj);
    }
    j = i;
    Object localObject;
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
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!this.ahgS.equals("")) {
      i = j + b.h(8, this.ahgS);
    }
    j = i;
    if (this.ahgT != null)
    {
      j = i;
      if (this.ahgT.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.ahgT.length; m = n)
        {
          localObject = this.ahgT[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.dU((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.ahgU != 0L) {
      i = j + b.r(10, this.ahgU);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bg
 * JD-Core Version:    0.7.0.1
 */