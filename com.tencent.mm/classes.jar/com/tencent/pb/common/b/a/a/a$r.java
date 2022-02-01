package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$r
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int RDV = 0;
  public a.bc[] RDW = a.bc.hjm();
  public a.bb[] RDX = a.bb.hjl();
  public a.ay RDY = null;
  public int RDZ = 0;
  public a.az RDq = null;
  public int RDt = 0;
  public a.be RDv = null;
  public int REa = 0;
  public int REb = 0;
  public byte[] REc = g.cbu;
  public byte[] REd = g.cbu;
  public a.bb[] REe = a.bb.hjl();
  public int audioStreamType = 0;
  public String groupId = "";
  public int jlm = 0;
  public long msgId = 0L;
  
  public a$r()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int m = 0;
    int j = super.Ig();
    int i = j;
    if (this.RDV != 0) {
      i = j + b.bu(1, this.RDV);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.f(2, this.groupId);
    }
    i = j;
    if (this.GXO != 0) {
      i = j + b.bu(3, this.GXO);
    }
    j = i;
    if (this.GXP != 0L) {
      j = i + b.r(4, this.GXP);
    }
    int k = j;
    if (this.RDt != 0) {
      k = j + b.bC(5, this.RDt);
    }
    i = k;
    if (this.RDq != null) {
      i = k + b.b(6, this.RDq);
    }
    j = i;
    Object localObject;
    if (this.RDW != null)
    {
      j = i;
      if (this.RDW.length > 0)
      {
        j = 0;
        while (j < this.RDW.length)
        {
          localObject = this.RDW[j];
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
    if (this.RDX != null)
    {
      i = j;
      if (this.RDX.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.RDX.length)
        {
          localObject = this.RDX[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(8, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.RDY != null) {
      j = i + b.b(9, this.RDY);
    }
    i = j;
    if (this.RDv != null) {
      i = j + b.b(10, this.RDv);
    }
    j = i;
    if (this.RDZ != 0) {
      j = i + b.bC(11, this.RDZ);
    }
    i = j;
    if (this.REa != 0) {
      i = j + b.bC(12, this.REa);
    }
    j = i;
    if (this.jlm != 0) {
      j = i + b.bC(13, this.jlm);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.p(101, this.msgId);
    }
    j = i;
    if (this.REb != 0) {
      j = i + b.bC(102, this.REb);
    }
    k = j;
    if (!Arrays.equals(this.REc, g.cbu)) {
      k = j + b.c(103, this.REc);
    }
    i = k;
    if (!Arrays.equals(this.REd, g.cbu)) {
      i = k + b.c(200, this.REd);
    }
    j = i;
    if (this.REe != null)
    {
      j = i;
      if (this.REe.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.REe.length) {
            break;
          }
          localObject = this.REe[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(201, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.audioStreamType != 0) {
      i = j + b.bu(202, this.audioStreamType);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.RDV != 0) {
      paramb.bs(1, this.RDV);
    }
    if (!this.groupId.equals("")) {
      paramb.e(2, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(3, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(4, this.GXP);
    }
    if (this.RDt != 0) {
      paramb.bB(5, this.RDt);
    }
    if (this.RDq != null) {
      paramb.a(6, this.RDq);
    }
    int i;
    Object localObject;
    if ((this.RDW != null) && (this.RDW.length > 0))
    {
      i = 0;
      while (i < this.RDW.length)
      {
        localObject = this.RDW[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.RDX != null) && (this.RDX.length > 0))
    {
      i = 0;
      while (i < this.RDX.length)
      {
        localObject = this.RDX[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDY != null) {
      paramb.a(9, this.RDY);
    }
    if (this.RDv != null) {
      paramb.a(10, this.RDv);
    }
    if (this.RDZ != 0) {
      paramb.bB(11, this.RDZ);
    }
    if (this.REa != 0) {
      paramb.bB(12, this.REa);
    }
    if (this.jlm != 0) {
      paramb.bB(13, this.jlm);
    }
    if (this.msgId != 0L) {
      paramb.n(101, this.msgId);
    }
    if (this.REb != 0) {
      paramb.bB(102, this.REb);
    }
    if (!Arrays.equals(this.REc, g.cbu)) {
      paramb.b(103, this.REc);
    }
    if (!Arrays.equals(this.REd, g.cbu)) {
      paramb.b(200, this.REd);
    }
    if ((this.REe != null) && (this.REe.length > 0))
    {
      i = j;
      while (i < this.REe.length)
      {
        localObject = this.REe[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.audioStreamType != 0) {
      paramb.bs(202, this.audioStreamType);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.r
 * JD-Core Version:    0.7.0.1
 */