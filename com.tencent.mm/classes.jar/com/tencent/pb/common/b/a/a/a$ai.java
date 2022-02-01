package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$ai
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public a.aw LFX = null;
  public a.av LGE = null;
  public a.ay[] LGK = a.ay.fTf();
  public a.ay[] LHp = a.ay.fTf();
  public a.p[] LHq = a.p.fSY();
  public a.az[] LHr = a.az.fTg();
  public int LHs = 0;
  public int[] LHt = g.bQP;
  public String groupId = "";
  
  public a$ai()
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
    if (this.LGE != null) {
      paramb.a(5, this.LGE);
    }
    if (this.LHs != 0) {
      paramb.bx(6, this.LHs);
    }
    if ((this.LHt != null) && (this.LHt.length > 0))
    {
      i = 0;
      while (i < this.LHt.length)
      {
        paramb.bx(7, this.LHt[i]);
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
          paramb.a(200, (e)localObject);
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
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LFX != null) {
      paramb.a(202, this.LFX);
    }
    if ((this.LGK != null) && (this.LGK.length > 0))
    {
      i = j;
      while (i < this.LGK.length)
      {
        localObject = this.LGK[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
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
    if (this.LGE != null) {
      i = j + b.b(5, this.LGE);
    }
    j = i;
    if (this.LHs != 0) {
      j = i + b.bz(6, this.LHs);
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
    if (this.LHp != null)
    {
      j = i;
      if (this.LHp.length > 0)
      {
        j = 0;
        while (j < this.LHp.length)
        {
          localObject = this.LHp[j];
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
    if (this.LHr != null)
    {
      k = j;
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
            k = i + b.b(201, (e)localObject);
          }
          j += 1;
          i = k;
        }
        k = i;
      }
    }
    i = k;
    if (this.LFX != null) {
      i = k + b.b(202, this.LFX);
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
            k = i + b.b(203, (e)localObject);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ai
 * JD-Core Version:    0.7.0.1
 */