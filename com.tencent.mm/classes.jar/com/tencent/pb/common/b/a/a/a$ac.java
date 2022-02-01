package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$ac
  extends e
{
  public int ACR = 0;
  public int UAZ = 0;
  public long UBa = 0L;
  public int ZnB = -1;
  public int ahdZ = 0;
  public a.ay ahdv = null;
  public a.ba[] aheQ = a.ba.jRm();
  public a.q[] aheR = a.q.jRe();
  public a.bb[] aheS = a.bb.jRn();
  public int aheT = 0;
  public int[] aheU = g.dTZ;
  public a.q[] aheV = a.q.jRe();
  public int aheW = 0;
  public int aheX = 0;
  public a.q[] aheY = a.q.jRe();
  public int aheZ = 0;
  public a.ax aheh = null;
  public int ahej = 0;
  public a.ba[] ahen = a.ba.jRm();
  public int ahfa = 0;
  public int ahfb = 0;
  public byte[] ahfc = g.dXB;
  public int[] ahfd = g.dTZ;
  public String groupId = "";
  
  public a$ac()
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
    if ((this.aheQ != null) && (this.aheQ.length > 0))
    {
      i = 0;
      while (i < this.aheQ.length)
      {
        localObject = this.aheQ[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheh != null) {
      paramb.a(6, this.aheh);
    }
    if (this.aheT != 0) {
      paramb.cF(7, this.aheT);
    }
    if ((this.aheU != null) && (this.aheU.length > 0))
    {
      i = 0;
      while (i < this.aheU.length)
      {
        paramb.cF(8, this.aheU[i]);
        i += 1;
      }
    }
    if (this.ACR != 0) {
      paramb.cF(9, this.ACR);
    }
    if ((this.aheS != null) && (this.aheS.length > 0))
    {
      i = 0;
      while (i < this.aheS.length)
      {
        localObject = this.aheS[i];
        if (localObject != null) {
          paramb.a(10, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ahdv != null) {
      paramb.a(11, this.ahdv);
    }
    if (this.ahdZ != 0) {
      paramb.cG(12, this.ahdZ);
    }
    if ((this.aheV != null) && (this.aheV.length > 0))
    {
      i = 0;
      while (i < this.aheV.length)
      {
        localObject = this.aheV[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.aheY != null) && (this.aheY.length > 0))
    {
      i = 0;
      while (i < this.aheY.length)
      {
        localObject = this.aheY[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheZ != 0) {
      paramb.cF(15, this.aheZ);
    }
    if (this.ahfa != 0) {
      paramb.cF(16, this.ahfa);
    }
    if (this.ahfb != 0) {
      paramb.cF(17, this.ahfb);
    }
    if (!Arrays.equals(this.ahfc, g.dXB)) {
      paramb.b(18, this.ahfc);
    }
    if (this.ZnB != -1) {
      paramb.cF(19, this.ZnB);
    }
    if ((this.ahfd != null) && (this.ahfd.length > 0))
    {
      i = 0;
      while (i < this.ahfd.length)
      {
        paramb.cG(20, this.ahfd[i]);
        i += 1;
      }
    }
    if (this.ahej != 0) {
      paramb.cG(21, this.ahej);
    }
    if (this.aheW != 0) {
      paramb.cG(100, this.aheW);
    }
    if (this.aheX != 0) {
      paramb.cG(101, this.aheX);
    }
    if ((this.ahen != null) && (this.ahen.length > 0))
    {
      i = j;
      while (i < this.ahen.length)
      {
        localObject = this.ahen[i];
        if (localObject != null) {
          paramb.a(102, (e)localObject);
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
    if (this.aheQ != null)
    {
      i = j;
      if (this.aheQ.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.aheQ.length)
        {
          localObject = this.aheQ[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(5, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.aheh != null) {
      j = i + b.b(6, this.aheh);
    }
    i = j;
    if (this.aheT != 0) {
      i = j + b.cJ(7, this.aheT);
    }
    j = i;
    if (this.aheU != null)
    {
      j = i;
      if (this.aheU.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.aheU.length)
        {
          k += b.kp(this.aheU[j]);
          j += 1;
        }
        j = i + k + this.aheU.length * 1;
      }
    }
    i = j;
    if (this.ACR != 0) {
      i = j + b.cJ(9, this.ACR);
    }
    j = i;
    if (this.aheS != null)
    {
      j = i;
      if (this.aheS.length > 0)
      {
        j = 0;
        while (j < this.aheS.length)
        {
          localObject = this.aheS[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(10, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.ahdv != null) {
      k = j + b.b(11, this.ahdv);
    }
    i = k;
    if (this.ahdZ != 0) {
      i = k + b.cK(12, this.ahdZ);
    }
    j = i;
    if (this.aheV != null)
    {
      j = i;
      if (this.aheV.length > 0)
      {
        j = 0;
        while (j < this.aheV.length)
        {
          localObject = this.aheV[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(13, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.aheY != null)
    {
      i = j;
      if (this.aheY.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.aheY.length)
        {
          localObject = this.aheY[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.aheZ != 0) {
      j = i + b.cJ(15, this.aheZ);
    }
    i = j;
    if (this.ahfa != 0) {
      i = j + b.cJ(16, this.ahfa);
    }
    j = i;
    if (this.ahfb != 0) {
      j = i + b.cJ(17, this.ahfb);
    }
    k = j;
    if (!Arrays.equals(this.ahfc, g.dXB)) {
      k = j + b.c(18, this.ahfc);
    }
    i = k;
    if (this.ZnB != -1) {
      i = k + b.cJ(19, this.ZnB);
    }
    j = i;
    if (this.ahfd != null)
    {
      j = i;
      if (this.ahfd.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ahfd.length)
        {
          k += b.kv(this.ahfd[j]);
          j += 1;
        }
        j = i + k + this.ahfd.length * 2;
      }
    }
    i = j;
    if (this.ahej != 0) {
      i = j + b.cK(21, this.ahej);
    }
    j = i;
    if (this.aheW != 0) {
      j = i + b.cK(100, this.aheW);
    }
    i = j;
    if (this.aheX != 0) {
      i = j + b.cK(101, this.aheX);
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
            k = i + b.b(102, (e)localObject);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ac
 * JD-Core Version:    0.7.0.1
 */