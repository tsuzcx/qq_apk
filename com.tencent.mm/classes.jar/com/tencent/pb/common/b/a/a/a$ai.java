package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$ai
  extends e
{
  public a.aw IkD = null;
  public a.ay[] IlV = a.ay.flz();
  public a.p[] IlW = a.p.fls();
  public a.az[] IlX = a.az.flA();
  public int IlY = 0;
  public int[] IlZ = g.bIT;
  public a.av Ilk = null;
  public a.ay[] Ilq = a.ay.flz();
  public String groupId = "";
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$ai()
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
    if (this.Ilk != null) {
      paramb.a(5, this.Ilk);
    }
    if (this.IlY != 0) {
      paramb.by(6, this.IlY);
    }
    if ((this.IlZ != null) && (this.IlZ.length > 0))
    {
      i = 0;
      while (i < this.IlZ.length)
      {
        paramb.by(7, this.IlZ[i]);
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
          paramb.a(200, (e)localObject);
        }
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
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.IkD != null) {
      paramb.a(202, this.IkD);
    }
    if ((this.Ilq != null) && (this.Ilq.length > 0))
    {
      i = j;
      while (i < this.Ilq.length)
      {
        localObject = this.Ilq[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
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
    if (this.Ilk != null) {
      i = j + b.b(5, this.Ilk);
    }
    j = i;
    if (this.IlY != 0) {
      j = i + b.bA(6, this.IlY);
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
    if (this.IlV != null)
    {
      j = i;
      if (this.IlV.length > 0)
      {
        j = 0;
        while (j < this.IlV.length)
        {
          localObject = this.IlV[j];
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
    if (this.IlX != null)
    {
      k = j;
      if (this.IlX.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.IlX.length)
        {
          localObject = this.IlX[j];
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
    if (this.IkD != null) {
      i = k + b.b(202, this.IkD);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ai
 * JD-Core Version:    0.7.0.1
 */