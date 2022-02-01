package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$e
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int LFT = 0;
  public a.aw LFX = null;
  public a.bd LFZ = null;
  public int LGb = 0;
  public String[] LGe = g.EMPTY_STRING_ARRAY;
  public a.n[] LGf = a.n.fSW();
  public int LGg = 0;
  public a.t LGh = null;
  public int LGi = 0;
  public String groupId = "";
  public int netType = 0;
  public int vug = 0;
  
  public a$e()
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
    if (this.LFZ != null) {
      paramb.a(4, this.LFZ);
    }
    if (this.vug != 0) {
      paramb.bx(5, this.vug);
    }
    if (this.LGb != 0) {
      paramb.by(6, this.LGb);
    }
    if (this.LFT != 0) {
      paramb.bx(7, this.LFT);
    }
    if (this.netType != 0) {
      paramb.by(8, this.netType);
    }
    if (this.LFX != null) {
      paramb.a(200, this.LFX);
    }
    int i;
    Object localObject;
    if ((this.LGe != null) && (this.LGe.length > 0))
    {
      i = 0;
      while (i < this.LGe.length)
      {
        localObject = this.LGe[i];
        if (localObject != null) {
          paramb.d(201, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.LGf != null) && (this.LGf.length > 0))
    {
      i = j;
      while (i < this.LGf.length)
      {
        localObject = this.LGf[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LGh != null) {
      paramb.a(203, this.LGh);
    }
    if (this.LGi != 0) {
      paramb.by(204, this.LGi);
    }
    if (this.LGg != 0) {
      paramb.by(240, this.LGg);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int i2 = 0;
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
    if (this.LFZ != null) {
      j = i + b.b(4, this.LFZ);
    }
    i = j;
    if (this.vug != 0) {
      i = j + b.bz(5, this.vug);
    }
    j = i;
    if (this.LGb != 0) {
      j = i + b.bA(6, this.LGb);
    }
    i = j;
    if (this.LFT != 0) {
      i = j + b.bz(7, this.LFT);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.bA(8, this.netType);
    }
    j = k;
    if (this.LFX != null) {
      j = k + b.b(200, this.LFX);
    }
    i = j;
    Object localObject;
    if (this.LGe != null)
    {
      i = j;
      if (this.LGe.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.LGe.length; m = n)
        {
          localObject = this.LGe[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cc((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.LGf != null)
    {
      j = i;
      if (this.LGf.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.LGf.length) {
            break;
          }
          localObject = this.LGf[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(202, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.LGh != null) {
      i = j + b.b(203, this.LGh);
    }
    j = i;
    if (this.LGi != 0) {
      j = i + b.bA(204, this.LGi);
    }
    i = j;
    if (this.LGg != 0) {
      i = j + b.bA(240, this.LGg);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */