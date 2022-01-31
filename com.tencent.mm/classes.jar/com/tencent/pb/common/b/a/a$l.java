package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$l
  extends e
{
  public int BdX = 0;
  public byte[] BdY = g.bhf;
  public a.az[] BdZ = a.az.dTT();
  public a.ao[] Bea = a.ao.dTO();
  public int Beb = 0;
  public int Bec = 0;
  public int fVF = 0;
  public String groupId = "";
  public int kJx = -1;
  public int twP = 0;
  public long twQ = 0L;
  
  public a$l()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    if (this.kJx != -1) {
      paramb.bj(4, this.kJx);
    }
    if (this.BdX != 0) {
      paramb.bj(5, this.BdX);
    }
    if (!Arrays.equals(this.BdY, g.bhf)) {
      paramb.b(6, this.BdY);
    }
    int i;
    Object localObject;
    if ((this.BdZ != null) && (this.BdZ.length > 0))
    {
      i = 0;
      while (i < this.BdZ.length)
      {
        localObject = this.BdZ[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Bea != null) && (this.Bea.length > 0))
    {
      i = j;
      while (i < this.Bea.length)
      {
        localObject = this.Bea[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Beb != 0) {
      paramb.bj(9, this.Beb);
    }
    if (this.Bec != 0) {
      paramb.bj(10, this.Bec);
    }
    if (this.fVF != 0) {
      paramb.bj(11, this.fVF);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int m = 0;
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    j = i;
    if (this.kJx != -1) {
      j = i + b.bl(4, this.kJx);
    }
    int k = j;
    if (this.BdX != 0) {
      k = j + b.bl(5, this.BdX);
    }
    i = k;
    if (!Arrays.equals(this.BdY, g.bhf)) {
      i = k + b.c(6, this.BdY);
    }
    j = i;
    Object localObject;
    if (this.BdZ != null)
    {
      j = i;
      if (this.BdZ.length > 0)
      {
        j = 0;
        while (j < this.BdZ.length)
        {
          localObject = this.BdZ[j];
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
    if (this.Bea != null)
    {
      i = j;
      if (this.Bea.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.Bea.length) {
            break;
          }
          localObject = this.Bea[k];
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
    if (this.Beb != 0) {
      j = i + b.bl(9, this.Beb);
    }
    i = j;
    if (this.Bec != 0) {
      i = j + b.bl(10, this.Bec);
    }
    j = i;
    if (this.fVF != 0) {
      j = i + b.bl(11, this.fVF);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.l
 * JD-Core Version:    0.7.0.1
 */