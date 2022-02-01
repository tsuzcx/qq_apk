package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int Dab = -1;
  public a.aw IkD = null;
  public a.ay[] IlV = a.ay.flz();
  public a.p[] IlW = a.p.fls();
  public a.az[] IlX = a.az.flA();
  public int IlY = 0;
  public int[] IlZ = g.bIT;
  public int Ilc = 0;
  public a.av Ilk = null;
  public int Ilm = 0;
  public a.ay[] Ilq = a.ay.flz();
  public a.p[] Ima = a.p.fls();
  public int Imb = 0;
  public int Imc = 0;
  public a.p[] Imd = a.p.fls();
  public int Ime = 0;
  public int Imf = 0;
  public int Img = 0;
  public byte[] Imh = g.bIZ;
  public int[] Imi = g.bIT;
  public String groupId = "";
  public int tjk = 0;
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$ab()
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
    if (this.tjk != 0) {
      paramb.by(9, this.tjk);
    }
    if ((this.IlX != null) && (this.IlX.length > 0))
    {
      i = 0;
      while (i < this.IlX.length)
      {
        localObject = this.IlX[i];
        if (localObject != null) {
          paramb.a(10, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.IkD != null) {
      paramb.a(11, this.IkD);
    }
    if (this.Ilc != 0) {
      paramb.bz(12, this.Ilc);
    }
    if ((this.Ima != null) && (this.Ima.length > 0))
    {
      i = 0;
      while (i < this.Ima.length)
      {
        localObject = this.Ima[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
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
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ime != 0) {
      paramb.by(15, this.Ime);
    }
    if (this.Imf != 0) {
      paramb.by(16, this.Imf);
    }
    if (this.Img != 0) {
      paramb.by(17, this.Img);
    }
    if (!Arrays.equals(this.Imh, g.bIZ)) {
      paramb.b(18, this.Imh);
    }
    if (this.Dab != -1) {
      paramb.by(19, this.Dab);
    }
    if ((this.Imi != null) && (this.Imi.length > 0))
    {
      i = 0;
      while (i < this.Imi.length)
      {
        paramb.bz(20, this.Imi[i]);
        i += 1;
      }
    }
    if (this.Ilm != 0) {
      paramb.bz(21, this.Ilm);
    }
    if (this.Imb != 0) {
      paramb.bz(100, this.Imb);
    }
    if (this.Imc != 0) {
      paramb.bz(101, this.Imc);
    }
    if ((this.Ilq != null) && (this.Ilq.length > 0))
    {
      i = j;
      while (i < this.Ilq.length)
      {
        localObject = this.Ilq[i];
        if (localObject != null) {
          paramb.a(102, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int m = 0;
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
    j = i;
    if (this.Ilk != null) {
      j = i + b.b(6, this.Ilk);
    }
    i = j;
    if (this.IlY != 0) {
      i = j + b.bA(7, this.IlY);
    }
    j = i;
    if (this.IlZ != null)
    {
      j = i;
      if (this.IlZ.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.IlZ.length)
        {
          k += b.fW(this.IlZ[j]);
          j += 1;
        }
        j = i + k + this.IlZ.length * 1;
      }
    }
    i = j;
    if (this.tjk != 0) {
      i = j + b.bA(9, this.tjk);
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
            k = i + b.b(10, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.IkD != null) {
      k = j + b.b(11, this.IkD);
    }
    i = k;
    if (this.Ilc != 0) {
      i = k + b.bB(12, this.Ilc);
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
            k = i + b.b(13, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Imd != null)
    {
      i = j;
      if (this.Imd.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Imd.length)
        {
          localObject = this.Imd[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Ime != 0) {
      j = i + b.bA(15, this.Ime);
    }
    i = j;
    if (this.Imf != 0) {
      i = j + b.bA(16, this.Imf);
    }
    j = i;
    if (this.Img != 0) {
      j = i + b.bA(17, this.Img);
    }
    k = j;
    if (!Arrays.equals(this.Imh, g.bIZ)) {
      k = j + b.c(18, this.Imh);
    }
    i = k;
    if (this.Dab != -1) {
      i = k + b.bA(19, this.Dab);
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
      i = j + b.bB(21, this.Ilm);
    }
    j = i;
    if (this.Imb != 0) {
      j = i + b.bB(100, this.Imb);
    }
    i = j;
    if (this.Imc != 0) {
      i = j + b.bB(101, this.Imc);
    }
    k = i;
    if (this.Ilq != null)
    {
      k = i;
      if (this.Ilq.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.Ilq.length) {
            break;
          }
          localObject = this.Ilq[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(102, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */