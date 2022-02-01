package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$e
  extends e
{
  public a.aw IkD = null;
  public a.bd IkF = null;
  public int IkH = 0;
  public String[] IkK = g.EMPTY_STRING_ARRAY;
  public a.n[] IkL = a.n.flq();
  public int IkM = 0;
  public a.t IkN = null;
  public int IkO = 0;
  public int Ikz = 0;
  public String groupId = "";
  public int netType = 0;
  public int tjk = 0;
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$e()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.zkT != 0) {
      paramb.by(2, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(3, this.zkU);
    }
    if (this.IkF != null) {
      paramb.a(4, this.IkF);
    }
    if (this.tjk != 0) {
      paramb.by(5, this.tjk);
    }
    if (this.IkH != 0) {
      paramb.bz(6, this.IkH);
    }
    if (this.Ikz != 0) {
      paramb.by(7, this.Ikz);
    }
    if (this.netType != 0) {
      paramb.bz(8, this.netType);
    }
    if (this.IkD != null) {
      paramb.a(200, this.IkD);
    }
    int i;
    Object localObject;
    if ((this.IkK != null) && (this.IkK.length > 0))
    {
      i = 0;
      while (i < this.IkK.length)
      {
        localObject = this.IkK[i];
        if (localObject != null) {
          paramb.d(201, (String)localObject);
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
    if (this.IkN != null) {
      paramb.a(203, this.IkN);
    }
    if (this.IkO != 0) {
      paramb.bz(204, this.IkO);
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
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.zkT != 0) {
      j = i + b.bA(2, this.zkT);
    }
    i = j;
    if (this.zkU != 0L) {
      i = j + b.q(3, this.zkU);
    }
    j = i;
    if (this.IkF != null) {
      j = i + b.b(4, this.IkF);
    }
    i = j;
    if (this.tjk != 0) {
      i = j + b.bA(5, this.tjk);
    }
    j = i;
    if (this.IkH != 0) {
      j = i + b.bB(6, this.IkH);
    }
    i = j;
    if (this.Ikz != 0) {
      i = j + b.bA(7, this.Ikz);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.bB(8, this.netType);
    }
    j = k;
    if (this.IkD != null) {
      j = k + b.b(200, this.IkD);
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
    if (this.IkN != null) {
      i = j + b.b(203, this.IkN);
    }
    j = i;
    if (this.IkO != 0) {
      j = i + b.bB(204, this.IkO);
    }
    i = j;
    if (this.IkM != 0) {
      i = j + b.bB(240, this.IkM);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */