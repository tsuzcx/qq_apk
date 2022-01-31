package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$aj
  extends e
{
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public int sPg = -1;
  public a.as wGM = null;
  public int wGO = 0;
  public a.av[] wGS = a.av.cOf();
  public a.at wGh = null;
  public a.o[] wHA = a.o.cNZ();
  public a.aw[] wHB = a.aw.cOg();
  public int wHC = 0;
  public int[] wHD = g.aUJ;
  public a.o[] wHE = a.o.cNZ();
  public a.o[] wHH = a.o.cNZ();
  public int wHI = 0;
  public int wHJ = 0;
  public int wHK = 0;
  public byte[] wHL = g.aUP;
  public int[] wHM = g.aUJ;
  public a.av[] wHz = a.av.cOf();
  
  public a$aj()
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
    if ((this.wHz != null) && (this.wHz.length > 0))
    {
      i = 0;
      while (i < this.wHz.length)
      {
        localObject = this.wHz[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wGM != null) {
      paramb.a(6, this.wGM);
    }
    if (this.wHC != 0) {
      paramb.aL(7, this.wHC);
    }
    if ((this.wHD != null) && (this.wHD.length > 0))
    {
      i = 0;
      while (i < this.wHD.length)
      {
        paramb.aL(8, this.wHD[i]);
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
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wGh != null) {
      paramb.a(10, this.wGh);
    }
    if ((this.wHE != null) && (this.wHE.length > 0))
    {
      i = 0;
      while (i < this.wHE.length)
      {
        localObject = this.wHE[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.wGS != null) && (this.wGS.length > 0))
    {
      i = 0;
      while (i < this.wGS.length)
      {
        localObject = this.wGS[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.wHH != null) && (this.wHH.length > 0))
    {
      i = 0;
      while (i < this.wHH.length)
      {
        localObject = this.wHH[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.wHI != 0) {
      paramb.aL(14, this.wHI);
    }
    if (this.wHJ != 0) {
      paramb.aL(15, this.wHJ);
    }
    if (this.wHK != 0) {
      paramb.aL(16, this.wHK);
    }
    if (!Arrays.equals(this.wHL, g.aUP)) {
      paramb.b(17, this.wHL);
    }
    if (this.sPg != -1) {
      paramb.aL(18, this.sPg);
    }
    if ((this.wHM != null) && (this.wHM.length > 0))
    {
      i = j;
      while (i < this.wHM.length)
      {
        paramb.aM(19, this.wHM[i]);
        i += 1;
      }
    }
    if (this.wGO != 0) {
      paramb.aM(20, this.wGO);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
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
    if (this.wHz != null)
    {
      i = j;
      if (this.wHz.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.wHz.length)
        {
          localObject = this.wHz[j];
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
    if (this.wGM != null) {
      k = i + b.b(6, this.wGM);
    }
    j = k;
    if (this.wHC != 0) {
      j = k + b.aN(7, this.wHC);
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
    if (this.wHB != null)
    {
      j = i;
      if (this.wHB.length > 0)
      {
        j = 0;
        while (j < this.wHB.length)
        {
          localObject = this.wHB[j];
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
    if (this.wGh != null) {
      i = j + b.b(10, this.wGh);
    }
    j = i;
    if (this.wHE != null)
    {
      j = i;
      if (this.wHE.length > 0)
      {
        j = 0;
        while (j < this.wHE.length)
        {
          localObject = this.wHE[j];
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
    if (this.wGS != null)
    {
      i = j;
      if (this.wGS.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.wGS.length)
        {
          localObject = this.wGS[j];
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
    if (this.wHH != null)
    {
      j = i;
      if (this.wHH.length > 0)
      {
        j = 0;
        while (j < this.wHH.length)
        {
          localObject = this.wHH[j];
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
    if (this.wHI != 0) {
      i = j + b.aN(14, this.wHI);
    }
    j = i;
    if (this.wHJ != 0) {
      j = i + b.aN(15, this.wHJ);
    }
    i = j;
    if (this.wHK != 0) {
      i = j + b.aN(16, this.wHK);
    }
    j = i;
    if (!Arrays.equals(this.wHL, g.aUP)) {
      j = i + b.c(17, this.wHL);
    }
    i = j;
    if (this.sPg != -1) {
      i = j + b.aN(18, this.sPg);
    }
    j = i;
    if (this.wHM != null)
    {
      j = i;
      if (this.wHM.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.wHM.length)
        {
          k += b.dS(this.wHM[j]);
          j += 1;
        }
        j = i + k + this.wHM.length * 2;
      }
    }
    i = j;
    if (this.wGO != 0) {
      i = j + b.aO(20, this.wGO);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.aj
 * JD-Core Version:    0.7.0.1
 */