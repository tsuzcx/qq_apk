package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ak
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public a.ay RDY = null;
  public a.az RDq = null;
  public a.bb[] REK = a.bb.hjl();
  public a.q[] REL = a.q.hjd();
  public a.bc[] REM = a.bc.hjm();
  public int REN = 0;
  public int[] REO = g.bYn;
  public a.bb[] REe = a.bb.hjl();
  public String groupId = "";
  
  public a$ak()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int m = 0;
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
    if (this.RDY != null) {
      i = j + b.b(5, this.RDY);
    }
    j = i;
    if (this.REN != 0) {
      j = i + b.bu(6, this.REN);
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
    if (this.REK != null)
    {
      j = i;
      if (this.REK.length > 0)
      {
        j = 0;
        while (j < this.REK.length)
        {
          localObject = this.REK[j];
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
    if (this.REM != null)
    {
      k = j;
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
            k = i + b.b(201, (e)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (this.RDq != null) {
      i = k + b.b(202, this.RDq);
    }
    k = i;
    if (this.REe != null)
    {
      k = i;
      if (this.REe.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.REe.length) {
            break;
          }
          localObject = this.REe[j];
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
    if (this.RDY != null) {
      paramb.a(5, this.RDY);
    }
    if (this.REN != 0) {
      paramb.bs(6, this.REN);
    }
    if ((this.REO != null) && (this.REO.length > 0))
    {
      i = 0;
      while (i < this.REO.length)
      {
        paramb.bs(7, this.REO[i]);
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
          paramb.a(200, (e)localObject);
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
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDq != null) {
      paramb.a(202, this.RDq);
    }
    if ((this.REe != null) && (this.REe.length > 0))
    {
      i = j;
      while (i < this.REe.length)
      {
        localObject = this.REe[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ak
 * JD-Core Version:    0.7.0.1
 */