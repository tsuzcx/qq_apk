package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$ag
  extends e
{
  public a.at BdI = null;
  public a.av[] BeZ = a.av.dTR();
  public a.as Ben = null;
  public a.av[] Bet = a.av.dTR();
  public a.o[] Bfa = a.o.dTL();
  public a.aw[] Bfb = a.aw.dTS();
  public int Bfc = 0;
  public int[] Bfd = g.bgZ;
  public String groupId = "";
  public int twP = 0;
  public long twQ = 0L;
  
  public a$ag()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    int i;
    Object localObject;
    if ((this.Bfa != null) && (this.Bfa.length > 0))
    {
      i = 0;
      while (i < this.Bfa.length)
      {
        localObject = this.Bfa[i];
        if (localObject != null) {
          paramb.a(4, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ben != null) {
      paramb.a(5, this.Ben);
    }
    if (this.Bfc != 0) {
      paramb.bj(6, this.Bfc);
    }
    if ((this.Bfd != null) && (this.Bfd.length > 0))
    {
      i = 0;
      while (i < this.Bfd.length)
      {
        paramb.bj(7, this.Bfd[i]);
        i += 1;
      }
    }
    if ((this.BeZ != null) && (this.BeZ.length > 0))
    {
      i = 0;
      while (i < this.BeZ.length)
      {
        localObject = this.BeZ[i];
        if (localObject != null) {
          paramb.a(200, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Bfb != null) && (this.Bfb.length > 0))
    {
      i = 0;
      while (i < this.Bfb.length)
      {
        localObject = this.Bfb[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.BdI != null) {
      paramb.a(202, this.BdI);
    }
    if ((this.Bet != null) && (this.Bet.length > 0))
    {
      i = j;
      while (i < this.Bet.length)
      {
        localObject = this.Bet[i];
        if (localObject != null) {
          paramb.a(203, (e)localObject);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int m = 0;
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    j = i;
    Object localObject;
    if (this.Bfa != null)
    {
      j = i;
      if (this.Bfa.length > 0)
      {
        j = 0;
        while (j < this.Bfa.length)
        {
          localObject = this.Bfa[j];
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
    if (this.Ben != null) {
      i = j + b.b(5, this.Ben);
    }
    j = i;
    if (this.Bfc != 0) {
      j = i + b.bl(6, this.Bfc);
    }
    i = j;
    if (this.Bfd != null)
    {
      i = j;
      if (this.Bfd.length > 0)
      {
        i = 0;
        k = 0;
        while (i < this.Bfd.length)
        {
          k += b.eU(this.Bfd[i]);
          i += 1;
        }
        i = j + k + this.Bfd.length * 1;
      }
    }
    j = i;
    if (this.BeZ != null)
    {
      j = i;
      if (this.BeZ.length > 0)
      {
        j = 0;
        while (j < this.BeZ.length)
        {
          localObject = this.BeZ[j];
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
    if (this.Bfb != null)
    {
      k = j;
      if (this.Bfb.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Bfb.length)
        {
          localObject = this.Bfb[j];
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
    if (this.BdI != null) {
      i = k + b.b(202, this.BdI);
    }
    k = i;
    if (this.Bet != null)
    {
      k = i;
      if (this.Bet.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= this.Bet.length) {
            break;
          }
          localObject = this.Bet[j];
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.ag
 * JD-Core Version:    0.7.0.1
 */