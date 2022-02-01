package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$am
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int ZnB = -1;
  public a.ay ahdv = null;
  public a.ba[] aheQ = a.ba.jRm();
  public a.q[] aheR = a.q.jRe();
  public a.bb[] aheS = a.bb.jRn();
  public int aheT = 0;
  public int[] aheU = g.dTZ;
  public a.q[] aheV = a.q.jRe();
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
  
  public a$am()
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
    if ((this.aheS != null) && (this.aheS.length > 0))
    {
      i = 0;
      while (i < this.aheS.length)
      {
        localObject = this.aheS[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ahdv != null) {
      paramb.a(10, this.ahdv);
    }
    if ((this.aheV != null) && (this.aheV.length > 0))
    {
      i = 0;
      while (i < this.aheV.length)
      {
        localObject = this.aheV[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.ahen != null) && (this.ahen.length > 0))
    {
      i = 0;
      while (i < this.ahen.length)
      {
        localObject = this.ahen[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
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
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheZ != 0) {
      paramb.cF(14, this.aheZ);
    }
    if (this.ahfa != 0) {
      paramb.cF(15, this.ahfa);
    }
    if (this.ahfb != 0) {
      paramb.cF(16, this.ahfb);
    }
    if (!Arrays.equals(this.ahfc, g.dXB)) {
      paramb.b(17, this.ahfc);
    }
    if (this.ZnB != -1) {
      paramb.cF(18, this.ZnB);
    }
    if ((this.ahfd != null) && (this.ahfd.length > 0))
    {
      i = j;
      while (i < this.ahfd.length)
      {
        paramb.cG(19, this.ahfd[i]);
        i += 1;
      }
    }
    if (this.ahej != 0) {
      paramb.cG(20, this.ahej);
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
    int k = i;
    if (this.aheh != null) {
      k = i + b.b(6, this.aheh);
    }
    j = k;
    if (this.aheT != 0) {
      j = k + b.cJ(7, this.aheT);
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
            k = i + b.b(9, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ahdv != null) {
      i = j + b.b(10, this.ahdv);
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
            k = i + b.b(11, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ahen != null)
    {
      i = j;
      if (this.ahen.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.ahen.length)
        {
          localObject = this.ahen[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(12, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.aheY != null)
    {
      j = i;
      if (this.aheY.length > 0)
      {
        j = 0;
        while (j < this.aheY.length)
        {
          localObject = this.aheY[j];
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
    if (this.aheZ != 0) {
      i = j + b.cJ(14, this.aheZ);
    }
    j = i;
    if (this.ahfa != 0) {
      j = i + b.cJ(15, this.ahfa);
    }
    i = j;
    if (this.ahfb != 0) {
      i = j + b.cJ(16, this.ahfb);
    }
    j = i;
    if (!Arrays.equals(this.ahfc, g.dXB)) {
      j = i + b.c(17, this.ahfc);
    }
    i = j;
    if (this.ZnB != -1) {
      i = j + b.cJ(18, this.ZnB);
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
      i = j + b.cK(20, this.ahej);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.am
 * JD-Core Version:    0.7.0.1
 */