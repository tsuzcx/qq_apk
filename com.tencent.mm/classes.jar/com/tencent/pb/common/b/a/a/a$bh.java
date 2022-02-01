package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$bh
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int RDt = 0;
  public a.bb[] REK = a.bb.hjl();
  public int RGK = 0;
  public String RGL = "";
  public String[] RGM = g.EMPTY_STRING_ARRAY;
  public long RGN = 0L;
  public String RGc = "";
  public String groupId = "";
  
  public a$bh()
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
    if (this.RDt != 0) {
      j = i + b.bC(4, this.RDt);
    }
    int k = j;
    if (this.RGK != 0) {
      k = j + b.bu(5, this.RGK);
    }
    i = k;
    if (!this.RGc.equals("")) {
      i = k + b.f(6, this.RGc);
    }
    j = i;
    Object localObject;
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
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (!this.RGL.equals("")) {
      i = j + b.f(8, this.RGL);
    }
    j = i;
    if (this.RGM != null)
    {
      j = i;
      if (this.RGM.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.RGM.length; m = n)
        {
          localObject = this.RGM[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cb((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.RGN != 0L) {
      i = j + b.p(10, this.RGN);
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
    if (this.RGK != 0) {
      paramb.bs(5, this.RGK);
    }
    if (!this.RGc.equals("")) {
      paramb.e(6, this.RGc);
    }
    int i;
    Object localObject;
    if ((this.REK != null) && (this.REK.length > 0))
    {
      i = 0;
      while (i < this.REK.length)
      {
        localObject = this.REK[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.RGL.equals("")) {
      paramb.e(8, this.RGL);
    }
    if ((this.RGM != null) && (this.RGM.length > 0))
    {
      i = j;
      while (i < this.RGM.length)
      {
        localObject = this.RGM[i];
        if (localObject != null) {
          paramb.e(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.RGN != 0L) {
      paramb.n(10, this.RGN);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bh
 * JD-Core Version:    0.7.0.1
 */