package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$al
  extends e
{
  public int Dab = -1;
  public a.aw IkD = null;
  public a.ay[] IlV = a.ay.flz();
  public a.p[] IlW = a.p.fls();
  public a.az[] IlX = a.az.flA();
  public int IlY = 0;
  public int[] IlZ = g.bIT;
  public a.av Ilk = null;
  public int Ilm = 0;
  public a.ay[] Ilq = a.ay.flz();
  public a.p[] Ima = a.p.fls();
  public a.p[] Imd = a.p.fls();
  public int Ime = 0;
  public int Imf = 0;
  public int Img = 0;
  public byte[] Imh = g.bIZ;
  public int[] Imi = g.bIT;
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$al()
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
    int i;
    Object localObject;
    if ((this.IlW != null) && (this.IlW.length > 0))
    {
      i = 0;
      while (i < this.IlW.length)
      {
        localObject = this.IlW[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.IlV != null) && (this.IlV.length > 0))
    {
      i = 0;
      while (i < this.IlV.length)
      {
        localObject = this.IlV[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ilk != null) {
      paramb.a(6, this.Ilk);
    }
    if (this.IlY != 0) {
      paramb.by(7, this.IlY);
    }
    if ((this.IlZ != null) && (this.IlZ.length > 0))
    {
      i = 0;
      while (i < this.IlZ.length)
      {
        paramb.by(8, this.IlZ[i]);
        i += 1;
      }
    }
    if ((this.IlX != null) && (this.IlX.length > 0))
    {
      i = 0;
      while (i < this.IlX.length)
      {
        localObject = this.IlX[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.IkD != null) {
      paramb.a(10, this.IkD);
    }
    if ((this.Ima != null) && (this.Ima.length > 0))
    {
      i = 0;
      while (i < this.Ima.length)
      {
        localObject = this.Ima[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Ilq != null) && (this.Ilq.length > 0))
    {
      i = 0;
      while (i < this.Ilq.length)
      {
        localObject = this.Ilq[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Imd != null) && (this.Imd.length > 0))
    {
      i = 0;
      while (i < this.Imd.length)
      {
        localObject = this.Imd[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ime != 0) {
      paramb.by(14, this.Ime);
    }
    if (this.Imf != 0) {
      paramb.by(15, this.Imf);
    }
    if (this.Img != 0) {
      paramb.by(16, this.Img);
    }
    if (!Arrays.equals(this.Imh, g.bIZ)) {
      paramb.b(17, this.Imh);
    }
    if (this.Dab != -1) {
      paramb.by(18, this.Dab);
    }
    if ((this.Imi != null) && (this.Imi.length > 0))
    {
      i = j;
      while (i < this.Imi.length)
      {
        paramb.bz(19, this.Imi[i]);
        i += 1;
      }
    }
    if (this.Ilm != 0) {
      paramb.bz(20, this.Ilm);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
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
    Object localObject;
    if (this.IlW != null)
    {
      j = i;
      if (this.IlW.length > 0)
      {
        j = 0;
        while (j < this.IlW.length)
        {
          localObject = this.IlW[j];
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
    if (this.IlV != null)
    {
      i = j;
      if (this.IlV.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.IlV.length)
        {
          localObject = this.IlV[j];
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
    if (this.Ilk != null) {
      k = i + b.b(6, this.Ilk);
    }
    j = k;
    if (this.IlY != 0) {
      j = k + b.bA(7, this.IlY);
    }
    i = j;
    if (this.IlZ != null)
    {
      i = j;
      if (this.IlZ.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.IlZ.length)
        {
          k += b.fW(this.IlZ[i]);
          i += 1;
        }
        i = j + k + this.IlZ.length * 1;
      }
    }
    j = i;
    if (this.IlX != null)
    {
      j = i;
      if (this.IlX.length > 0)
      {
        j = 0;
        while (j < this.IlX.length)
        {
          localObject = this.IlX[j];
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
    if (this.IkD != null) {
      i = j + b.b(10, this.IkD);
    }
    j = i;
    if (this.Ima != null)
    {
      j = i;
      if (this.Ima.length > 0)
      {
        j = 0;
        while (j < this.Ima.length)
        {
          localObject = this.Ima[j];
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
    if (this.Ilq != null)
    {
      i = j;
      if (this.Ilq.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Ilq.length)
        {
          localObject = this.Ilq[j];
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
    if (this.Imd != null)
    {
      j = i;
      if (this.Imd.length > 0)
      {
        j = 0;
        while (j < this.Imd.length)
        {
          localObject = this.Imd[j];
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
    if (this.Ime != 0) {
      i = j + b.bA(14, this.Ime);
    }
    j = i;
    if (this.Imf != 0) {
      j = i + b.bA(15, this.Imf);
    }
    i = j;
    if (this.Img != 0) {
      i = j + b.bA(16, this.Img);
    }
    j = i;
    if (!Arrays.equals(this.Imh, g.bIZ)) {
      j = i + b.c(17, this.Imh);
    }
    i = j;
    if (this.Dab != -1) {
      i = j + b.bA(18, this.Dab);
    }
    j = i;
    if (this.Imi != null)
    {
      j = i;
      if (this.Imi.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Imi.length)
        {
          k += b.ga(this.Imi[j]);
          j += 1;
        }
        j = i + k + this.Imi.length * 2;
      }
    }
    i = j;
    if (this.Ilm != 0) {
      i = j + b.bB(20, this.Ilm);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.al
 * JD-Core Version:    0.7.0.1
 */