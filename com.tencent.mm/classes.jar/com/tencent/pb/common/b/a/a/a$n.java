package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$n
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int RDH = 0;
  public byte[] RDI = g.cbu;
  public a.bf[] RDJ = a.bf.hjn();
  public a.au[] RDK = a.au.hji();
  public int RDL = 0;
  public int RDM = 0;
  public String groupId = "";
  public int jqs = 0;
  public int qrD = -1;
  
  public a$n()
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
    if (this.qrD != -1) {
      j = i + b.bu(4, this.qrD);
    }
    int k = j;
    if (this.RDH != 0) {
      k = j + b.bu(5, this.RDH);
    }
    i = k;
    if (!Arrays.equals(this.RDI, g.cbu)) {
      i = k + b.c(6, this.RDI);
    }
    j = i;
    Object localObject;
    if (this.RDJ != null)
    {
      j = i;
      if (this.RDJ.length > 0)
      {
        j = 0;
        while (j < this.RDJ.length)
        {
          localObject = this.RDJ[j];
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
    if (this.RDK != null)
    {
      i = j;
      if (this.RDK.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.RDK.length) {
            break;
          }
          localObject = this.RDK[k];
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
    if (this.RDL != 0) {
      j = i + b.bu(9, this.RDL);
    }
    i = j;
    if (this.RDM != 0) {
      i = j + b.bu(10, this.RDM);
    }
    j = i;
    if (this.jqs != 0) {
      j = i + b.bu(11, this.jqs);
    }
    return j;
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
    if (this.qrD != -1) {
      paramb.bs(4, this.qrD);
    }
    if (this.RDH != 0) {
      paramb.bs(5, this.RDH);
    }
    if (!Arrays.equals(this.RDI, g.cbu)) {
      paramb.b(6, this.RDI);
    }
    int i;
    Object localObject;
    if ((this.RDJ != null) && (this.RDJ.length > 0))
    {
      i = 0;
      while (i < this.RDJ.length)
      {
        localObject = this.RDJ[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.RDK != null) && (this.RDK.length > 0))
    {
      i = j;
      while (i < this.RDK.length)
      {
        localObject = this.RDK[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDL != 0) {
      paramb.bs(9, this.RDL);
    }
    if (this.RDM != 0) {
      paramb.bs(10, this.RDM);
    }
    if (this.jqs != 0) {
      paramb.bs(11, this.jqs);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */