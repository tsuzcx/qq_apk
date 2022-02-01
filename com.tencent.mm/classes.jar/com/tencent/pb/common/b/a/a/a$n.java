package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$n
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int ahdQ = 0;
  public byte[] ahdR = g.dXB;
  public a.be[] ahdS = a.be.jRo();
  public a.at[] ahdT = a.at.jRj();
  public int ahdU = 0;
  public int ahdV = 0;
  public String groupId = "";
  public int oYP = 0;
  public int wTC = -1;
  
  public a$n()
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
    if (this.wTC != -1) {
      paramb.cF(4, this.wTC);
    }
    if (this.ahdQ != 0) {
      paramb.cF(5, this.ahdQ);
    }
    if (!Arrays.equals(this.ahdR, g.dXB)) {
      paramb.b(6, this.ahdR);
    }
    int i;
    Object localObject;
    if ((this.ahdS != null) && (this.ahdS.length > 0))
    {
      i = 0;
      while (i < this.ahdS.length)
      {
        localObject = this.ahdS[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.ahdT != null) && (this.ahdT.length > 0))
    {
      i = j;
      while (i < this.ahdT.length)
      {
        localObject = this.ahdT[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.ahdU != 0) {
      paramb.cF(9, this.ahdU);
    }
    if (this.ahdV != 0) {
      paramb.cF(10, this.ahdV);
    }
    if (this.oYP != 0) {
      paramb.cF(11, this.oYP);
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
    if (this.wTC != -1) {
      j = i + b.cJ(4, this.wTC);
    }
    int k = j;
    if (this.ahdQ != 0) {
      k = j + b.cJ(5, this.ahdQ);
    }
    i = k;
    if (!Arrays.equals(this.ahdR, g.dXB)) {
      i = k + b.c(6, this.ahdR);
    }
    j = i;
    Object localObject;
    if (this.ahdS != null)
    {
      j = i;
      if (this.ahdS.length > 0)
      {
        j = 0;
        while (j < this.ahdS.length)
        {
          localObject = this.ahdS[j];
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
    if (this.ahdT != null)
    {
      i = j;
      if (this.ahdT.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.ahdT.length) {
            break;
          }
          localObject = this.ahdT[k];
          i = j;
          if (localObject != null) {
            i = j + b.b(8, (e)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    j = i;
    if (this.ahdU != 0) {
      j = i + b.cJ(9, this.ahdU);
    }
    i = j;
    if (this.ahdV != 0) {
      i = j + b.cJ(10, this.ahdV);
    }
    j = i;
    if (this.oYP != 0) {
      j = i + b.cJ(11, this.oYP);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */