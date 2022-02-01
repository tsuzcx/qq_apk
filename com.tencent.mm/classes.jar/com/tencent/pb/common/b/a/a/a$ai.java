package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$ai
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public a.av MdI = null;
  public a.ay[] MdO = a.ay.fXF();
  public a.aw Mdb = null;
  public a.ay[] Met = a.ay.fXF();
  public a.p[] Meu = a.p.fXy();
  public a.az[] Mev = a.az.fXG();
  public int Mew = 0;
  public int[] Mex = g.bQP;
  public String groupId = "";
  
  public a$ai()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(2, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(3, this.Cug);
    }
    int i;
    Object localObject;
    if ((this.Meu != null) && (this.Meu.length > 0))
    {
      i = 0;
      while (i < this.Meu.length)
      {
        localObject = this.Meu[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.MdI != null) {
      paramb.a(5, this.MdI);
    }
    if (this.Mew != 0) {
      paramb.bx(6, this.Mew);
    }
    if ((this.Mex != null) && (this.Mex.length > 0))
    {
      i = 0;
      while (i < this.Mex.length)
      {
        paramb.bx(7, this.Mex[i]);
        i += 1;
      }
    }
    if ((this.Met != null) && (this.Met.length > 0))
    {
      i = 0;
      while (i < this.Met.length)
      {
        localObject = this.Met[i];
        if (localObject != null) {
          paramb.a(200, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Mev != null) && (this.Mev.length > 0))
    {
      i = 0;
      while (i < this.Mev.length)
      {
        localObject = this.Mev[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Mdb != null) {
      paramb.a(202, this.Mdb);
    }
    if ((this.MdO != null) && (this.MdO.length > 0))
    {
      i = j;
      while (i < this.MdO.length)
      {
        localObject = this.MdO[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int m = 0;
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.Cuf != 0) {
      j = i + b.bz(2, this.Cuf);
    }
    i = j;
    if (this.Cug != 0L) {
      i = j + b.p(3, this.Cug);
    }
    j = i;
    Object localObject;
    if (this.Meu != null)
    {
      j = i;
      if (this.Meu.length > 0)
      {
        j = 0;
        while (j < this.Meu.length)
        {
          localObject = this.Meu[j];
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
    if (this.MdI != null) {
      i = j + b.b(5, this.MdI);
    }
    j = i;
    if (this.Mew != 0) {
      j = i + b.bz(6, this.Mew);
    }
    i = j;
    if (this.Mex != null)
    {
      i = j;
      if (this.Mex.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.Mex.length)
        {
          k += b.fL(this.Mex[i]);
          i += 1;
        }
        i = j + k + this.Mex.length * 1;
      }
    }
    j = i;
    if (this.Met != null)
    {
      j = i;
      if (this.Met.length > 0)
      {
        j = 0;
        while (j < this.Met.length)
        {
          localObject = this.Met[j];
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
    if (this.Mev != null)
    {
      k = j;
      if (this.Mev.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Mev.length)
        {
          localObject = this.Mev[j];
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
    if (this.Mdb != null) {
      i = k + b.b(202, this.Mdb);
    }
    k = i;
    if (this.MdO != null)
    {
      k = i;
      if (this.MdO.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.MdO.length) {
            break;
          }
          localObject = this.MdO[j];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ai
 * JD-Core Version:    0.7.0.1
 */