package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$d
  extends e
{
  public String IkB = "";
  public a.aw IkD = null;
  public int[] IkE = g.bIT;
  public a.bd IkF = null;
  public int IkG = 0;
  public int IkH = 0;
  public a.bb IkI = null;
  public String IkJ = "";
  public String[] IkK = g.EMPTY_STRING_ARRAY;
  public a.n[] IkL = a.n.flq();
  public int IkM = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.IkD != null) {
      paramb.a(1, this.IkD);
    }
    int i;
    if ((this.IkE != null) && (this.IkE.length > 0))
    {
      i = 0;
      while (i < this.IkE.length)
      {
        paramb.bz(2, this.IkE[i]);
        i += 1;
      }
    }
    if (this.IkF != null) {
      paramb.a(3, this.IkF);
    }
    if (this.IkG != 0) {
      paramb.bz(4, this.IkG);
    }
    if (this.IkH != 0) {
      paramb.bz(5, this.IkH);
    }
    if (this.IkI != null) {
      paramb.a(6, this.IkI);
    }
    if (!this.IkB.equals("")) {
      paramb.d(7, this.IkB);
    }
    if (!this.IkJ.equals("")) {
      paramb.d(8, this.IkJ);
    }
    if (this.netType != 0) {
      paramb.bz(9, this.netType);
    }
    Object localObject;
    if ((this.IkK != null) && (this.IkK.length > 0))
    {
      i = 0;
      while (i < this.IkK.length)
      {
        localObject = this.IkK[i];
        if (localObject != null) {
          paramb.d(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.IkL != null) && (this.IkL.length > 0))
    {
      i = j;
      while (i < this.IkL.length)
      {
        localObject = this.IkL[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.IkM != 0) {
      paramb.bz(240, this.IkM);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int i2 = 0;
    int j = super.yg();
    int i = j;
    if (this.IkD != null) {
      i = j + b.b(1, this.IkD);
    }
    j = i;
    if (this.IkE != null)
    {
      j = i;
      if (this.IkE.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.IkE.length)
        {
          k += b.ga(this.IkE[j]);
          j += 1;
        }
        j = i + k + this.IkE.length * 1;
      }
    }
    i = j;
    if (this.IkF != null) {
      i = j + b.b(3, this.IkF);
    }
    j = i;
    if (this.IkG != 0) {
      j = i + b.bB(4, this.IkG);
    }
    i = j;
    if (this.IkH != 0) {
      i = j + b.bB(5, this.IkH);
    }
    j = i;
    if (this.IkI != null) {
      j = i + b.b(6, this.IkI);
    }
    i = j;
    if (!this.IkB.equals("")) {
      i = j + b.e(7, this.IkB);
    }
    int k = i;
    if (!this.IkJ.equals("")) {
      k = i + b.e(8, this.IkJ);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.bB(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.IkK != null)
    {
      i = j;
      if (this.IkK.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.IkK.length; m = n)
        {
          localObject = this.IkK[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.bs((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.IkL != null)
    {
      j = i;
      if (this.IkL.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.IkL.length) {
            break;
          }
          localObject = this.IkL[k];
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
    if (this.IkM != 0) {
      i = j + b.bB(240, this.IkM);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */