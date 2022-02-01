package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int Lnt = -1;
  public int RDQ = 0;
  public a.bb[] RDX = a.bb.hjl();
  public a.ay RDY = null;
  public String RDo = "";
  public a.az RDq = null;
  public int RDt = 0;
  public a.q[] REL = a.q.hjd();
  public a.bc[] REM = a.bc.hjm();
  public int REN = 0;
  public int[] REO = g.bYn;
  public a.q[] REP = a.q.hjd();
  public int REQ = 0;
  public int RER = 0;
  public a.q[] RES = a.q.hjd();
  public int RET = 0;
  public int REU = 0;
  public int REW = 0;
  public byte[] REX = g.cbu;
  public int[] REY = g.bYn;
  public int REa = 0;
  public a.bb[] REe = a.bb.hjl();
  public String groupId = "";
  
  public a$ab()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    int k = j;
    if (this.GXP != 0L) {
      k = j + b.r(3, this.GXP);
    }
    i = k;
    if (this.RDt != 0) {
      i = k + b.bC(4, this.RDt);
    }
    j = i;
    Object localObject;
    if (this.REL != null)
    {
      j = i;
      if (this.REL.length > 0)
      {
        j = 0;
        while (j < this.REL.length)
        {
          localObject = this.REL[j];
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
    if (this.REM != null)
    {
      i = j;
      if (this.REM.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.REM.length)
        {
          localObject = this.REM[j];
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
    if (this.RDY != null) {
      j = i + b.b(7, this.RDY);
    }
    i = j;
    if (!this.RDo.equals("")) {
      i = j + b.f(8, this.RDo);
    }
    j = i;
    if (this.RDX != null)
    {
      j = i;
      if (this.RDX.length > 0)
      {
        j = 0;
        while (j < this.RDX.length)
        {
          localObject = this.RDX[j];
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
    if (this.REN != 0) {
      i = j + b.bu(10, this.REN);
    }
    j = i;
    if (this.REO != null)
    {
      j = i;
      if (this.REO.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.REO.length)
        {
          k += b.fT(this.REO[j]);
          j += 1;
        }
        j = i + k + this.REO.length * 1;
      }
    }
    k = j;
    if (this.RDq != null) {
      k = j + b.b(12, this.RDq);
    }
    i = k;
    if (this.RDQ != 0) {
      i = k + b.bC(13, this.RDQ);
    }
    j = i;
    if (this.REP != null)
    {
      j = i;
      if (this.REP.length > 0)
      {
        j = 0;
        while (j < this.REP.length)
        {
          localObject = this.REP[j];
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
    if (this.REQ != 0) {
      k = j + b.bC(15, this.REQ);
    }
    i = k;
    if (this.RER != 0) {
      i = k + b.bC(16, this.RER);
    }
    j = i;
    if (this.REe != null)
    {
      j = i;
      if (this.REe.length > 0)
      {
        j = 0;
        while (j < this.REe.length)
        {
          localObject = this.REe[j];
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
    if (this.RES != null)
    {
      i = j;
      if (this.RES.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.RES.length)
        {
          localObject = this.RES[j];
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
    if (this.RET != 0) {
      j = i + b.bu(19, this.RET);
    }
    i = j;
    if (this.REU != 0) {
      i = j + b.bu(20, this.REU);
    }
    j = i;
    if (this.REW != 0) {
      j = i + b.bu(21, this.REW);
    }
    k = j;
    if (!Arrays.equals(this.REX, g.cbu)) {
      k = j + b.c(22, this.REX);
    }
    i = k;
    if (this.Lnt != -1) {
      i = k + b.bu(23, this.Lnt);
    }
    j = i;
    if (this.REY != null)
    {
      j = i;
      if (this.REY.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.REY.length)
        {
          k += b.fY(this.REY[j]);
          j += 1;
        }
        j = i + k + this.REY.length * 2;
      }
    }
    i = j;
    if (this.REa != 0) {
      i = j + b.bC(25, this.REa);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    if (this.RDt != 0) {
      paramb.bB(4, this.RDt);
    }
    int i;
    Object localObject;
    if ((this.REL != null) && (this.REL.length > 0))
    {
      i = 0;
      while (i < this.REL.length)
      {
        localObject = this.REL[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.REM != null) && (this.REM.length > 0))
    {
      i = 0;
      while (i < this.REM.length)
      {
        localObject = this.REM[i];
        if (localObject != null) {
          paramb.a(6, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDY != null) {
      paramb.a(7, this.RDY);
    }
    if (!this.RDo.equals("")) {
      paramb.e(8, this.RDo);
    }
    if ((this.RDX != null) && (this.RDX.length > 0))
    {
      i = 0;
      while (i < this.RDX.length)
      {
        localObject = this.RDX[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.REN != 0) {
      paramb.bs(10, this.REN);
    }
    if ((this.REO != null) && (this.REO.length > 0))
    {
      i = 0;
      while (i < this.REO.length)
      {
        paramb.bs(11, this.REO[i]);
        i += 1;
      }
    }
    if (this.RDq != null) {
      paramb.a(12, this.RDq);
    }
    if (this.RDQ != 0) {
      paramb.bB(13, this.RDQ);
    }
    if ((this.REP != null) && (this.REP.length > 0))
    {
      i = 0;
      while (i < this.REP.length)
      {
        localObject = this.REP[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.REQ != 0) {
      paramb.bB(15, this.REQ);
    }
    if (this.RER != 0) {
      paramb.bB(16, this.RER);
    }
    if ((this.REe != null) && (this.REe.length > 0))
    {
      i = 0;
      while (i < this.REe.length)
      {
        localObject = this.REe[i];
        if (localObject != null) {
          paramb.a(17, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.RES != null) && (this.RES.length > 0))
    {
      i = 0;
      while (i < this.RES.length)
      {
        localObject = this.RES[i];
        if (localObject != null) {
          paramb.a(18, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RET != 0) {
      paramb.bs(19, this.RET);
    }
    if (this.REU != 0) {
      paramb.bs(20, this.REU);
    }
    if (this.REW != 0) {
      paramb.bs(21, this.REW);
    }
    if (!Arrays.equals(this.REX, g.cbu)) {
      paramb.b(22, this.REX);
    }
    if (this.Lnt != -1) {
      paramb.bs(23, this.Lnt);
    }
    if ((this.REY != null) && (this.REY.length > 0))
    {
      i = j;
      while (i < this.REY.length)
      {
        paramb.bB(24, this.REY[i]);
        i += 1;
      }
    }
    if (this.REa != 0) {
      paramb.bB(25, this.REa);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */