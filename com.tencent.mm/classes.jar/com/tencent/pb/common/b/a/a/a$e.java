package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$e
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public a.u RDA = null;
  public int RDB = 0;
  public int RDm = 0;
  public a.az RDq = null;
  public a.bg RDs = null;
  public int RDu = 0;
  public String[] RDx = g.EMPTY_STRING_ARRAY;
  public a.o[] RDy = a.o.hjb();
  public int RDz = 0;
  public String groupId = "";
  public int netType = 0;
  public int vkj = 0;
  
  public a$e()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int i2 = 0;
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
    }
    j = i;
    if (this.RDs != null) {
      j = i + b.b(4, this.RDs);
    }
    i = j;
    if (this.vkj != 0) {
      i = j + b.bu(5, this.vkj);
    }
    j = i;
    if (this.RDu != 0) {
      j = i + b.bC(6, this.RDu);
    }
    i = j;
    if (this.RDm != 0) {
      i = j + b.bu(7, this.RDm);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.bC(8, this.netType);
    }
    j = k;
    if (this.RDq != null) {
      j = k + b.b(200, this.RDq);
    }
    i = j;
    Object localObject;
    if (this.RDx != null)
    {
      i = j;
      if (this.RDx.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.RDx.length; m = n)
        {
          localObject = this.RDx[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cb((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.RDy != null)
    {
      j = i;
      if (this.RDy.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.RDy.length) {
            break;
          }
          localObject = this.RDy[k];
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
    if (this.RDA != null) {
      i = j + b.b(203, this.RDA);
    }
    j = i;
    if (this.RDB != 0) {
      j = i + b.bC(204, this.RDB);
    }
    i = j;
    if (this.RDz != 0) {
      i = j + b.bC(240, this.RDz);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    if (this.RDs != null) {
      paramb.a(4, this.RDs);
    }
    if (this.vkj != 0) {
      paramb.bs(5, this.vkj);
    }
    if (this.RDu != 0) {
      paramb.bB(6, this.RDu);
    }
    if (this.RDm != 0) {
      paramb.bs(7, this.RDm);
    }
    if (this.netType != 0) {
      paramb.bB(8, this.netType);
    }
    if (this.RDq != null) {
      paramb.a(200, this.RDq);
    }
    int i;
    Object localObject;
    if ((this.RDx != null) && (this.RDx.length > 0))
    {
      i = 0;
      while (i < this.RDx.length)
      {
        localObject = this.RDx[i];
        if (localObject != null) {
          paramb.e(201, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.RDy != null) && (this.RDy.length > 0))
    {
      i = j;
      while (i < this.RDy.length)
      {
        localObject = this.RDy[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.RDA != null) {
      paramb.a(203, this.RDA);
    }
    if (this.RDB != 0) {
      paramb.bB(204, this.RDB);
    }
    if (this.RDz != 0) {
      paramb.bB(240, this.RDz);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */