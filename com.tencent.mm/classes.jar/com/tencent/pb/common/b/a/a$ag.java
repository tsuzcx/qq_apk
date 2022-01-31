package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ag
  extends e
{
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public a.as wGM = null;
  public a.av[] wGS = a.av.cOf();
  public a.at wGh = null;
  public a.o[] wHA = a.o.cNZ();
  public a.aw[] wHB = a.aw.cOg();
  public int wHC = 0;
  public int[] wHD = g.aUJ;
  public a.av[] wHz = a.av.cOf();
  
  public a$ag()
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
    int i;
    Object localObject;
    if ((this.wHA != null) && (this.wHA.length > 0))
    {
      i = 0;
      while (i < this.wHA.length)
      {
        localObject = this.wHA[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wGM != null) {
      paramb.a(5, this.wGM);
    }
    if (this.wHC != 0) {
      paramb.aL(6, this.wHC);
    }
    if ((this.wHD != null) && (this.wHD.length > 0))
    {
      i = 0;
      while (i < this.wHD.length)
      {
        paramb.aL(7, this.wHD[i]);
        i += 1;
      }
    }
    if ((this.wHz != null) && (this.wHz.length > 0))
    {
      i = 0;
      while (i < this.wHz.length)
      {
        localObject = this.wHz[i];
        if (localObject != null) {
          paramb.a(200, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.wHB != null) && (this.wHB.length > 0))
    {
      i = 0;
      while (i < this.wHB.length)
      {
        localObject = this.wHB[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wGh != null) {
      paramb.a(202, this.wGh);
    }
    if ((this.wGS != null) && (this.wGS.length > 0))
    {
      i = j;
      while (i < this.wGS.length)
      {
        localObject = this.wGS[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
        }
        i += 1;
      }
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
    Object localObject;
    if (this.wHA != null)
    {
      j = i;
      if (this.wHA.length > 0)
      {
        j = 0;
        while (j < this.wHA.length)
        {
          localObject = this.wHA[j];
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
    if (this.wGM != null) {
      i = j + b.b(5, this.wGM);
    }
    j = i;
    if (this.wHC != 0) {
      j = i + b.aN(6, this.wHC);
    }
    i = j;
    if (this.wHD != null)
    {
      i = j;
      if (this.wHD.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.wHD.length)
        {
          k += b.dO(this.wHD[i]);
          i += 1;
        }
        i = j + k + this.wHD.length * 1;
      }
    }
    j = i;
    if (this.wHz != null)
    {
      j = i;
      if (this.wHz.length > 0)
      {
        j = 0;
        while (j < this.wHz.length)
        {
          localObject = this.wHz[j];
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
    if (this.wHB != null)
    {
      k = j;
      if (this.wHB.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.wHB.length)
        {
          localObject = this.wHB[j];
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
    if (this.wGh != null) {
      i = k + b.b(202, this.wGh);
    }
    k = i;
    if (this.wGS != null)
    {
      k = i;
      if (this.wGS.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.wGS.length) {
            break;
          }
          localObject = this.wGS[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ag
 * JD-Core Version:    0.7.0.1
 */