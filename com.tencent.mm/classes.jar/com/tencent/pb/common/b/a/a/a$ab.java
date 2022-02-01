package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int ZnB = -1;
  public int ahdZ = 0;
  public String ahdt = "";
  public a.ay ahdv = null;
  public int ahdy = 0;
  public a.q[] aheR = a.q.jRe();
  public a.bb[] aheS = a.bb.jRn();
  public int aheT = 0;
  public int[] aheU = g.dTZ;
  public a.q[] aheV = a.q.jRe();
  public int aheW = 0;
  public int aheX = 0;
  public a.q[] aheY = a.q.jRe();
  public int aheZ = 0;
  public a.ba[] aheg = a.ba.jRm();
  public a.ax aheh = null;
  public int ahej = 0;
  public a.ba[] ahen = a.ba.jRm();
  public int ahfa = 0;
  public int ahfb = 0;
  public byte[] ahfc = g.dXB;
  public int[] ahfd = g.dTZ;
  public String groupId = "";
  
  public a$ab()
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
    int i;
    Object localObject;
    if ((this.aheR != null) && (this.aheR.length > 0))
    {
      i = 0;
      while (i < this.aheR.length)
      {
        localObject = this.aheR[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
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
          paramb.a(6, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheh != null) {
      paramb.a(7, this.aheh);
    }
    if (!this.ahdt.equals("")) {
      paramb.g(8, this.ahdt);
    }
    if ((this.aheg != null) && (this.aheg.length > 0))
    {
      i = 0;
      while (i < this.aheg.length)
      {
        localObject = this.aheg[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheT != 0) {
      paramb.cF(10, this.aheT);
    }
    if ((this.aheU != null) && (this.aheU.length > 0))
    {
      i = 0;
      while (i < this.aheU.length)
      {
        paramb.cF(11, this.aheU[i]);
        i += 1;
      }
    }
    if (this.ahdv != null) {
      paramb.a(12, this.ahdv);
    }
    if (this.ahdZ != 0) {
      paramb.cG(13, this.ahdZ);
    }
    if ((this.aheV != null) && (this.aheV.length > 0))
    {
      i = 0;
      while (i < this.aheV.length)
      {
        localObject = this.aheV[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheW != 0) {
      paramb.cG(15, this.aheW);
    }
    if (this.aheX != 0) {
      paramb.cG(16, this.aheX);
    }
    if ((this.ahen != null) && (this.ahen.length > 0))
    {
      i = 0;
      while (i < this.ahen.length)
      {
        localObject = this.ahen[i];
        if (localObject != null) {
          paramb.a(17, (e)localObject);
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
          paramb.a(18, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.aheZ != 0) {
      paramb.cF(19, this.aheZ);
    }
    if (this.ahfa != 0) {
      paramb.cF(20, this.ahfa);
    }
    if (this.ahfb != 0) {
      paramb.cF(21, this.ahfb);
    }
    if (!Arrays.equals(this.ahfc, g.dXB)) {
      paramb.b(22, this.ahfc);
    }
    if (this.ZnB != -1) {
      paramb.cF(23, this.ZnB);
    }
    if ((this.ahfd != null) && (this.ahfd.length > 0))
    {
      i = j;
      while (i < this.ahfd.length)
      {
        paramb.cG(24, this.ahfd[i]);
        i += 1;
      }
    }
    if (this.ahej != 0) {
      paramb.cG(25, this.ahej);
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
    int k = j;
    if (this.UBa != 0L) {
      k = j + b.q(3, this.UBa);
    }
    i = k;
    if (this.ahdy != 0) {
      i = k + b.cK(4, this.ahdy);
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
            k = i + b.b(5, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.aheS != null)
    {
      i = j;
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
            k = i + b.b(6, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.aheh != null) {
      j = i + b.b(7, this.aheh);
    }
    i = j;
    if (!this.ahdt.equals("")) {
      i = j + b.h(8, this.ahdt);
    }
    j = i;
    if (this.aheg != null)
    {
      j = i;
      if (this.aheg.length > 0)
      {
        j = 0;
        while (j < this.aheg.length)
        {
          localObject = this.aheg[j];
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
    if (this.aheT != 0) {
      i = j + b.cJ(10, this.aheT);
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
    k = j;
    if (this.ahdv != null) {
      k = j + b.b(12, this.ahdv);
    }
    i = k;
    if (this.ahdZ != 0) {
      i = k + b.cK(13, this.ahdZ);
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
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    k = j;
    if (this.aheW != 0) {
      k = j + b.cK(15, this.aheW);
    }
    i = k;
    if (this.aheX != 0) {
      i = k + b.cK(16, this.aheX);
    }
    j = i;
    if (this.ahen != null)
    {
      j = i;
      if (this.ahen.length > 0)
      {
        j = 0;
        while (j < this.ahen.length)
        {
          localObject = this.ahen[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(17, (e)localObject);
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
            k = i + b.b(18, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.aheZ != 0) {
      j = i + b.cJ(19, this.aheZ);
    }
    i = j;
    if (this.ahfa != 0) {
      i = j + b.cJ(20, this.ahfa);
    }
    j = i;
    if (this.ahfb != 0) {
      j = i + b.cJ(21, this.ahfb);
    }
    k = j;
    if (!Arrays.equals(this.ahfc, g.dXB)) {
      k = j + b.c(22, this.ahfc);
    }
    i = k;
    if (this.ZnB != -1) {
      i = k + b.cJ(23, this.ZnB);
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
      i = j + b.cK(25, this.ahej);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */