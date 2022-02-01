package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$m
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int LGn = 0;
  public byte[] LGo = g.bQV;
  public a.bc[] LGp = a.bc.fTh();
  public a.ar[] LGq = a.ar.fTc();
  public int LGr = 0;
  public int LGs = 0;
  public String groupId = "";
  public int ism = 0;
  public int oWb = -1;
  
  public a$m()
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
    if (this.oWb != -1) {
      paramb.bx(4, this.oWb);
    }
    if (this.LGn != 0) {
      paramb.bx(5, this.LGn);
    }
    if (!Arrays.equals(this.LGo, g.bQV)) {
      paramb.b(6, this.LGo);
    }
    int i;
    Object localObject;
    if ((this.LGp != null) && (this.LGp.length > 0))
    {
      i = 0;
      while (i < this.LGp.length)
      {
        localObject = this.LGp[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.LGq != null) && (this.LGq.length > 0))
    {
      i = j;
      while (i < this.LGq.length)
      {
        localObject = this.LGq[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LGr != 0) {
      paramb.bx(9, this.LGr);
    }
    if (this.LGs != 0) {
      paramb.bx(10, this.LGs);
    }
    if (this.ism != 0) {
      paramb.bx(11, this.ism);
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
    if (this.oWb != -1) {
      j = i + b.bz(4, this.oWb);
    }
    int k = j;
    if (this.LGn != 0) {
      k = j + b.bz(5, this.LGn);
    }
    i = k;
    if (!Arrays.equals(this.LGo, g.bQV)) {
      i = k + b.c(6, this.LGo);
    }
    j = i;
    Object localObject;
    if (this.LGp != null)
    {
      j = i;
      if (this.LGp.length > 0)
      {
        j = 0;
        while (j < this.LGp.length)
        {
          localObject = this.LGp[j];
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
    if (this.LGq != null)
    {
      i = j;
      if (this.LGq.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.LGq.length) {
            break;
          }
          localObject = this.LGq[k];
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
    if (this.LGr != 0) {
      j = i + b.bz(9, this.LGr);
    }
    i = j;
    if (this.LGs != 0) {
      i = j + b.bz(10, this.LGs);
    }
    j = i;
    if (this.ism != 0) {
      j = i + b.bz(11, this.ism);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */