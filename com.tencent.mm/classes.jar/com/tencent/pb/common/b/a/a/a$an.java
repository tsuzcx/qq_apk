package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$an
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int Lnt = -1;
  public a.ay RDY = null;
  public a.az RDq = null;
  public a.bb[] REK = a.bb.hjl();
  public a.q[] REL = a.q.hjd();
  public a.bc[] REM = a.bc.hjm();
  public int REN = 0;
  public int[] REO = g.bYn;
  public a.q[] REP = a.q.hjd();
  public a.q[] RES = a.q.hjd();
  public int RET = 0;
  public int REU = 0;
  public int REW = 0;
  public byte[] REX = g.cbu;
  public int[] REY = g.bYn;
  public int REa = 0;
  public a.bb[] REe = a.bb.hjl();
  public String groupId = "";
  
  public a$an()
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
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
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
            k = i + b.b(4, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.REK != null)
    {
      i = j;
      if (this.REK.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.REK.length)
        {
          localObject = this.REK[j];
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
    if (this.RDY != null) {
      k = i + b.b(6, this.RDY);
    }
    j = k;
    if (this.REN != 0) {
      j = k + b.bu(7, this.REN);
    }
    i = j;
    if (this.REO != null)
    {
      i = j;
      if (this.REO.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.REO.length)
        {
          k += b.fT(this.REO[i]);
          i += 1;
        }
        i = j + k + this.REO.length * 1;
      }
    }
    j = i;
    if (this.REM != null)
    {
      j = i;
      if (this.REM.length > 0)
      {
        j = 0;
        while (j < this.REM.length)
        {
          localObject = this.REM[j];
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
    if (this.RDq != null) {
      i = j + b.b(10, this.RDq);
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
            k = i + b.b(11, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.REe != null)
    {
      i = j;
      if (this.REe.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.REe.length)
        {
          localObject = this.REe[j];
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
    if (this.RES != null)
    {
      j = i;
      if (this.RES.length > 0)
      {
        j = 0;
        while (j < this.RES.length)
        {
          localObject = this.RES[j];
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
    if (this.RET != 0) {
      i = j + b.bu(14, this.RET);
    }
    j = i;
    if (this.REU != 0) {
      j = i + b.bu(15, this.REU);
    }
    i = j;
    if (this.REW != 0) {
      i = j + b.bu(16, this.REW);
    }
    j = i;
    if (!Arrays.equals(this.REX, g.cbu)) {
      j = i + b.c(17, this.REX);
    }
    i = j;
    if (this.Lnt != -1) {
      i = j + b.bu(18, this.Lnt);
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
      i = j + b.bC(20, this.REa);
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
    int i;
    Object localObject;
    if ((this.REL != null) && (this.REL.length > 0))
    {
      i = 0;
      while (i < this.REL.length)
      {
        localObject = this.REL[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.REK != null) && (this.REK.length > 0))
    {
      i = 0;
      while (i < this.REK.length)
      {
        localObject = this.REK[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDY != null) {
      paramb.a(6, this.RDY);
    }
    if (this.REN != 0) {
      paramb.bs(7, this.REN);
    }
    if ((this.REO != null) && (this.REO.length > 0))
    {
      i = 0;
      while (i < this.REO.length)
      {
        paramb.bs(8, this.REO[i]);
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
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDq != null) {
      paramb.a(10, this.RDq);
    }
    if ((this.REP != null) && (this.REP.length > 0))
    {
      i = 0;
      while (i < this.REP.length)
      {
        localObject = this.REP[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.REe != null) && (this.REe.length > 0))
    {
      i = 0;
      while (i < this.REe.length)
      {
        localObject = this.REe[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
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
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RET != 0) {
      paramb.bs(14, this.RET);
    }
    if (this.REU != 0) {
      paramb.bs(15, this.REU);
    }
    if (this.REW != 0) {
      paramb.bs(16, this.REW);
    }
    if (!Arrays.equals(this.REX, g.cbu)) {
      paramb.b(17, this.REX);
    }
    if (this.Lnt != -1) {
      paramb.bs(18, this.Lnt);
    }
    if ((this.REY != null) && (this.REY.length > 0))
    {
      i = j;
      while (i < this.REY.length)
      {
        paramb.bB(19, this.REY[i]);
        i += 1;
      }
    }
    if (this.REa != 0) {
      paramb.bB(20, this.REa);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.an
 * JD-Core Version:    0.7.0.1
 */