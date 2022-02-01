package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$aa
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int Gan = -1;
  public String LFV = "";
  public a.aw LFX = null;
  public a.ay[] LGD = a.ay.fTf();
  public a.av LGE = null;
  public int LGG = 0;
  public a.ay[] LGK = a.ay.fTf();
  public int LGa = 0;
  public int LGw = 0;
  public int LHA = 0;
  public byte[] LHB = g.bQV;
  public int[] LHC = g.bQP;
  public a.p[] LHq = a.p.fSY();
  public a.az[] LHr = a.az.fTg();
  public int LHs = 0;
  public int[] LHt = g.bQP;
  public a.p[] LHu = a.p.fSY();
  public int LHv = 0;
  public int LHw = 0;
  public a.p[] LHx = a.p.fSY();
  public int LHy = 0;
  public int LHz = 0;
  public String groupId = "";
  
  public a$aa()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.CcE != 0) {
      paramb.bx(2, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(3, this.CcF);
    }
    if (this.LGa != 0) {
      paramb.by(4, this.LGa);
    }
    int i;
    Object localObject;
    if ((this.LHq != null) && (this.LHq.length > 0))
    {
      i = 0;
      while (i < this.LHq.length)
      {
        localObject = this.LHq[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.LHr != null) && (this.LHr.length > 0))
    {
      i = 0;
      while (i < this.LHr.length)
      {
        localObject = this.LHr[i];
        if (localObject != null) {
          paramb.a(6, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LGE != null) {
      paramb.a(7, this.LGE);
    }
    if (!this.LFV.equals("")) {
      paramb.d(8, this.LFV);
    }
    if ((this.LGD != null) && (this.LGD.length > 0))
    {
      i = 0;
      while (i < this.LGD.length)
      {
        localObject = this.LGD[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LHs != 0) {
      paramb.bx(10, this.LHs);
    }
    if ((this.LHt != null) && (this.LHt.length > 0))
    {
      i = 0;
      while (i < this.LHt.length)
      {
        paramb.bx(11, this.LHt[i]);
        i += 1;
      }
    }
    if (this.LFX != null) {
      paramb.a(12, this.LFX);
    }
    if (this.LGw != 0) {
      paramb.by(13, this.LGw);
    }
    if ((this.LHu != null) && (this.LHu.length > 0))
    {
      i = 0;
      while (i < this.LHu.length)
      {
        localObject = this.LHu[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LHv != 0) {
      paramb.by(15, this.LHv);
    }
    if (this.LHw != 0) {
      paramb.by(16, this.LHw);
    }
    if ((this.LGK != null) && (this.LGK.length > 0))
    {
      i = 0;
      while (i < this.LGK.length)
      {
        localObject = this.LGK[i];
        if (localObject != null) {
          paramb.a(17, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.LHx != null) && (this.LHx.length > 0))
    {
      i = 0;
      while (i < this.LHx.length)
      {
        localObject = this.LHx[i];
        if (localObject != null) {
          paramb.a(18, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LHy != 0) {
      paramb.bx(19, this.LHy);
    }
    if (this.LHz != 0) {
      paramb.bx(20, this.LHz);
    }
    if (this.LHA != 0) {
      paramb.bx(21, this.LHA);
    }
    if (!Arrays.equals(this.LHB, g.bQV)) {
      paramb.b(22, this.LHB);
    }
    if (this.Gan != -1) {
      paramb.bx(23, this.Gan);
    }
    if ((this.LHC != null) && (this.LHC.length > 0))
    {
      i = j;
      while (i < this.LHC.length)
      {
        paramb.by(24, this.LHC[i]);
        i += 1;
      }
    }
    if (this.LGG != 0) {
      paramb.by(25, this.LGG);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.CcE != 0) {
      j = i + b.bz(2, this.CcE);
    }
    int k = j;
    if (this.CcF != 0L) {
      k = j + b.p(3, this.CcF);
    }
    i = k;
    if (this.LGa != 0) {
      i = k + b.bA(4, this.LGa);
    }
    j = i;
    Object localObject;
    if (this.LHq != null)
    {
      j = i;
      if (this.LHq.length > 0)
      {
        j = 0;
        while (j < this.LHq.length)
        {
          localObject = this.LHq[j];
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
    if (this.LHr != null)
    {
      i = j;
      if (this.LHr.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.LHr.length)
        {
          localObject = this.LHr[j];
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
    if (this.LGE != null) {
      j = i + b.b(7, this.LGE);
    }
    i = j;
    if (!this.LFV.equals("")) {
      i = j + b.e(8, this.LFV);
    }
    j = i;
    if (this.LGD != null)
    {
      j = i;
      if (this.LGD.length > 0)
      {
        j = 0;
        while (j < this.LGD.length)
        {
          localObject = this.LGD[j];
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
    if (this.LHs != 0) {
      i = j + b.bz(10, this.LHs);
    }
    j = i;
    if (this.LHt != null)
    {
      j = i;
      if (this.LHt.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.LHt.length)
        {
          k += b.fL(this.LHt[j]);
          j += 1;
        }
        j = i + k + this.LHt.length * 1;
      }
    }
    k = j;
    if (this.LFX != null) {
      k = j + b.b(12, this.LFX);
    }
    i = k;
    if (this.LGw != 0) {
      i = k + b.bA(13, this.LGw);
    }
    j = i;
    if (this.LHu != null)
    {
      j = i;
      if (this.LHu.length > 0)
      {
        j = 0;
        while (j < this.LHu.length)
        {
          localObject = this.LHu[j];
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
    if (this.LHv != 0) {
      k = j + b.bA(15, this.LHv);
    }
    i = k;
    if (this.LHw != 0) {
      i = k + b.bA(16, this.LHw);
    }
    j = i;
    if (this.LGK != null)
    {
      j = i;
      if (this.LGK.length > 0)
      {
        j = 0;
        while (j < this.LGK.length)
        {
          localObject = this.LGK[j];
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
    if (this.LHx != null)
    {
      i = j;
      if (this.LHx.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.LHx.length)
        {
          localObject = this.LHx[j];
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
    if (this.LHy != 0) {
      j = i + b.bz(19, this.LHy);
    }
    i = j;
    if (this.LHz != 0) {
      i = j + b.bz(20, this.LHz);
    }
    j = i;
    if (this.LHA != 0) {
      j = i + b.bz(21, this.LHA);
    }
    k = j;
    if (!Arrays.equals(this.LHB, g.bQV)) {
      k = j + b.c(22, this.LHB);
    }
    i = k;
    if (this.Gan != -1) {
      i = k + b.bz(23, this.Gan);
    }
    j = i;
    if (this.LHC != null)
    {
      j = i;
      if (this.LHC.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.LHC.length)
        {
          k += b.fP(this.LHC[j]);
          j += 1;
        }
        j = i + k + this.LHC.length * 2;
      }
    }
    i = j;
    if (this.LGG != 0) {
      i = j + b.bA(25, this.LGG);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aa
 * JD-Core Version:    0.7.0.1
 */