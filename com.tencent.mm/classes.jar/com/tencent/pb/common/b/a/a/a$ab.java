package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int Gan = -1;
  public a.aw LFX = null;
  public a.av LGE = null;
  public int LGG = 0;
  public a.ay[] LGK = a.ay.fTf();
  public int LGw = 0;
  public int LHA = 0;
  public byte[] LHB = g.bQV;
  public int[] LHC = g.bQP;
  public a.ay[] LHp = a.ay.fTf();
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
  public int vug = 0;
  
  public a$ab()
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
    int i;
    Object localObject;
    if ((this.LHq != null) && (this.LHq.length > 0))
    {
      i = 0;
      while (i < this.LHq.length)
      {
        localObject = this.LHq[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.LHp != null) && (this.LHp.length > 0))
    {
      i = 0;
      while (i < this.LHp.length)
      {
        localObject = this.LHp[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LGE != null) {
      paramb.a(6, this.LGE);
    }
    if (this.LHs != 0) {
      paramb.bx(7, this.LHs);
    }
    if ((this.LHt != null) && (this.LHt.length > 0))
    {
      i = 0;
      while (i < this.LHt.length)
      {
        paramb.bx(8, this.LHt[i]);
        i += 1;
      }
    }
    if (this.vug != 0) {
      paramb.bx(9, this.vug);
    }
    if ((this.LHr != null) && (this.LHr.length > 0))
    {
      i = 0;
      while (i < this.LHr.length)
      {
        localObject = this.LHr[i];
        if (localObject != null) {
          paramb.a(10, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LFX != null) {
      paramb.a(11, this.LFX);
    }
    if (this.LGw != 0) {
      paramb.by(12, this.LGw);
    }
    if ((this.LHu != null) && (this.LHu.length > 0))
    {
      i = 0;
      while (i < this.LHu.length)
      {
        localObject = this.LHu[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
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
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LHy != 0) {
      paramb.bx(15, this.LHy);
    }
    if (this.LHz != 0) {
      paramb.bx(16, this.LHz);
    }
    if (this.LHA != 0) {
      paramb.bx(17, this.LHA);
    }
    if (!Arrays.equals(this.LHB, g.bQV)) {
      paramb.b(18, this.LHB);
    }
    if (this.Gan != -1) {
      paramb.bx(19, this.Gan);
    }
    if ((this.LHC != null) && (this.LHC.length > 0))
    {
      i = 0;
      while (i < this.LHC.length)
      {
        paramb.by(20, this.LHC[i]);
        i += 1;
      }
    }
    if (this.LGG != 0) {
      paramb.by(21, this.LGG);
    }
    if (this.LHv != 0) {
      paramb.by(100, this.LHv);
    }
    if (this.LHw != 0) {
      paramb.by(101, this.LHw);
    }
    if ((this.LGK != null) && (this.LGK.length > 0))
    {
      i = j;
      while (i < this.LGK.length)
      {
        localObject = this.LGK[i];
        if (localObject != null) {
          paramb.a(102, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int m = 0;
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.CcE != 0) {
      j = i + b.bz(2, this.CcE);
    }
    i = j;
    if (this.CcF != 0L) {
      i = j + b.p(3, this.CcF);
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
            k = i + b.b(4, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.LHp != null)
    {
      i = j;
      if (this.LHp.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.LHp.length)
        {
          localObject = this.LHp[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(5, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.LGE != null) {
      j = i + b.b(6, this.LGE);
    }
    i = j;
    if (this.LHs != 0) {
      i = j + b.bz(7, this.LHs);
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
    i = j;
    if (this.vug != 0) {
      i = j + b.bz(9, this.vug);
    }
    j = i;
    if (this.LHr != null)
    {
      j = i;
      if (this.LHr.length > 0)
      {
        j = 0;
        while (j < this.LHr.length)
        {
          localObject = this.LHr[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(10, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.LFX != null) {
      k = j + b.b(11, this.LFX);
    }
    i = k;
    if (this.LGw != 0) {
      i = k + b.bA(12, this.LGw);
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
            k = i + b.b(13, (e)localObject);
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
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.LHy != 0) {
      j = i + b.bz(15, this.LHy);
    }
    i = j;
    if (this.LHz != 0) {
      i = j + b.bz(16, this.LHz);
    }
    j = i;
    if (this.LHA != 0) {
      j = i + b.bz(17, this.LHA);
    }
    k = j;
    if (!Arrays.equals(this.LHB, g.bQV)) {
      k = j + b.c(18, this.LHB);
    }
    i = k;
    if (this.Gan != -1) {
      i = k + b.bz(19, this.Gan);
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
      i = j + b.bA(21, this.LGG);
    }
    j = i;
    if (this.LHv != 0) {
      j = i + b.bA(100, this.LHv);
    }
    i = j;
    if (this.LHw != 0) {
      i = j + b.bA(101, this.LHw);
    }
    k = i;
    if (this.LGK != null)
    {
      k = i;
      if (this.LGK.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.LGK.length) {
            break;
          }
          localObject = this.LGK[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(102, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */