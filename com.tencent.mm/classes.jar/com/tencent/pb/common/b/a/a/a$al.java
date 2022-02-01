package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$al
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int Gan = -1;
  public a.aw LFX = null;
  public a.av LGE = null;
  public int LGG = 0;
  public a.ay[] LGK = a.ay.fTf();
  public int LHA = 0;
  public byte[] LHB = g.bQV;
  public int[] LHC = g.bQP;
  public a.ay[] LHp = a.ay.fTf();
  public a.p[] LHq = a.p.fSY();
  public a.az[] LHr = a.az.fTg();
  public int LHs = 0;
  public int[] LHt = g.bQP;
  public a.p[] LHu = a.p.fSY();
  public a.p[] LHx = a.p.fSY();
  public int LHy = 0;
  public int LHz = 0;
  public String groupId = "";
  
  public a$al()
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
    if ((this.LHr != null) && (this.LHr.length > 0))
    {
      i = 0;
      while (i < this.LHr.length)
      {
        localObject = this.LHr[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LFX != null) {
      paramb.a(10, this.LFX);
    }
    if ((this.LHu != null) && (this.LHu.length > 0))
    {
      i = 0;
      while (i < this.LHu.length)
      {
        localObject = this.LHu[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.LGK != null) && (this.LGK.length > 0))
    {
      i = 0;
      while (i < this.LGK.length)
      {
        localObject = this.LGK[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
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
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LHy != 0) {
      paramb.bx(14, this.LHy);
    }
    if (this.LHz != 0) {
      paramb.bx(15, this.LHz);
    }
    if (this.LHA != 0) {
      paramb.bx(16, this.LHA);
    }
    if (!Arrays.equals(this.LHB, g.bQV)) {
      paramb.b(17, this.LHB);
    }
    if (this.Gan != -1) {
      paramb.bx(18, this.Gan);
    }
    if ((this.LHC != null) && (this.LHC.length > 0))
    {
      i = j;
      while (i < this.LHC.length)
      {
        paramb.by(19, this.LHC[i]);
        i += 1;
      }
    }
    if (this.LGG != 0) {
      paramb.by(20, this.LGG);
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
    int k = i;
    if (this.LGE != null) {
      k = i + b.b(6, this.LGE);
    }
    j = k;
    if (this.LHs != 0) {
      j = k + b.bz(7, this.LHs);
    }
    i = j;
    if (this.LHt != null)
    {
      i = j;
      if (this.LHt.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.LHt.length)
        {
          k += b.fL(this.LHt[i]);
          i += 1;
        }
        i = j + k + this.LHt.length * 1;
      }
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
            k = i + b.b(9, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.LFX != null) {
      i = j + b.b(10, this.LFX);
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
            k = i + b.b(11, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.LGK != null)
    {
      i = j;
      if (this.LGK.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.LGK.length)
        {
          localObject = this.LGK[j];
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
    if (this.LHx != null)
    {
      j = i;
      if (this.LHx.length > 0)
      {
        j = 0;
        while (j < this.LHx.length)
        {
          localObject = this.LHx[j];
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
    if (this.LHy != 0) {
      i = j + b.bz(14, this.LHy);
    }
    j = i;
    if (this.LHz != 0) {
      j = i + b.bz(15, this.LHz);
    }
    i = j;
    if (this.LHA != 0) {
      i = j + b.bz(16, this.LHA);
    }
    j = i;
    if (!Arrays.equals(this.LHB, g.bQV)) {
      j = i + b.c(17, this.LHB);
    }
    i = j;
    if (this.Gan != -1) {
      i = j + b.bz(18, this.Gan);
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
      i = j + b.bA(20, this.LGG);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.al
 * JD-Core Version:    0.7.0.1
 */