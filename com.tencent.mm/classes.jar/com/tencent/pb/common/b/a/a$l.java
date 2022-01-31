package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$l
  extends e
{
  public int eFO = 0;
  public String groupId = "";
  public int iEo = -1;
  public int pRI = 0;
  public long pRJ = 0L;
  public int wGA = 0;
  public int wGB = 0;
  public int wGw = 0;
  public byte[] wGx = g.aUP;
  public a.az[] wGy = a.az.cOh();
  public a.ao[] wGz = a.ao.cOc();
  
  public a$l()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.pRI != 0) {
      paramb.aL(2, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(3, this.pRJ);
    }
    if (this.iEo != -1) {
      paramb.aL(4, this.iEo);
    }
    if (this.wGw != 0) {
      paramb.aL(5, this.wGw);
    }
    if (!Arrays.equals(this.wGx, g.aUP)) {
      paramb.b(6, this.wGx);
    }
    int i;
    Object localObject;
    if ((this.wGy != null) && (this.wGy.length > 0))
    {
      i = 0;
      while (i < this.wGy.length)
      {
        localObject = this.wGy[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.wGz != null) && (this.wGz.length > 0))
    {
      i = j;
      while (i < this.wGz.length)
      {
        localObject = this.wGz[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wGA != 0) {
      paramb.aL(9, this.wGA);
    }
    if (this.wGB != 0) {
      paramb.aL(10, this.wGB);
    }
    if (this.eFO != 0) {
      paramb.aL(11, this.eFO);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int m = 0;
    int j = super.oQ();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.pRI != 0) {
      j = i + b.aN(2, this.pRI);
    }
    i = j;
    if (this.pRJ != 0L) {
      i = j + b.k(3, this.pRJ);
    }
    j = i;
    if (this.iEo != -1) {
      j = i + b.aN(4, this.iEo);
    }
    int k = j;
    if (this.wGw != 0) {
      k = j + b.aN(5, this.wGw);
    }
    i = k;
    if (!Arrays.equals(this.wGx, g.aUP)) {
      i = k + b.c(6, this.wGx);
    }
    j = i;
    Object localObject;
    if (this.wGy != null)
    {
      j = i;
      if (this.wGy.length > 0)
      {
        j = 0;
        while (j < this.wGy.length)
        {
          localObject = this.wGy[j];
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
    if (this.wGz != null)
    {
      i = j;
      if (this.wGz.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.wGz.length) {
            break;
          }
          localObject = this.wGz[k];
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
    if (this.wGA != 0) {
      j = i + b.aN(9, this.wGA);
    }
    i = j;
    if (this.wGB != 0) {
      i = j + b.aN(10, this.wGB);
    }
    j = i;
    if (this.eFO != 0) {
      j = i + b.aN(11, this.eFO);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.l
 * JD-Core Version:    0.7.0.1
 */