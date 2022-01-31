package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$aj
  extends e
{
  public a.at BdI = null;
  public a.av[] BeZ = a.av.dTR();
  public a.as Ben = null;
  public int Bep = 0;
  public a.av[] Bet = a.av.dTR();
  public a.o[] Bfa = a.o.dTL();
  public a.aw[] Bfb = a.aw.dTS();
  public int Bfc = 0;
  public int[] Bfd = g.bgZ;
  public a.o[] Bfe = a.o.dTL();
  public a.o[] Bfh = a.o.dTL();
  public int Bfi = 0;
  public int Bfj = 0;
  public int Bfk = 0;
  public byte[] Bfl = g.bhf;
  public int[] Bfm = g.bgZ;
  public String groupId = "";
  public int twP = 0;
  public long twQ = 0L;
  public int wNy = -1;
  
  public a$aj()
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
    if ((this.BeZ != null) && (this.BeZ.length > 0))
    {
      i = 0;
      while (i < this.BeZ.length)
      {
        localObject = this.BeZ[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ben != null) {
      paramb.a(6, this.Ben);
    }
    if (this.Bfc != 0) {
      paramb.bj(7, this.Bfc);
    }
    if ((this.Bfd != null) && (this.Bfd.length > 0))
    {
      i = 0;
      while (i < this.Bfd.length)
      {
        paramb.bj(8, this.Bfd[i]);
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
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.BdI != null) {
      paramb.a(10, this.BdI);
    }
    if ((this.Bfe != null) && (this.Bfe.length > 0))
    {
      i = 0;
      while (i < this.Bfe.length)
      {
        localObject = this.Bfe[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Bet != null) && (this.Bet.length > 0))
    {
      i = 0;
      while (i < this.Bet.length)
      {
        localObject = this.Bet[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Bfh != null) && (this.Bfh.length > 0))
    {
      i = 0;
      while (i < this.Bfh.length)
      {
        localObject = this.Bfh[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Bfi != 0) {
      paramb.bj(14, this.Bfi);
    }
    if (this.Bfj != 0) {
      paramb.bj(15, this.Bfj);
    }
    if (this.Bfk != 0) {
      paramb.bj(16, this.Bfk);
    }
    if (!Arrays.equals(this.Bfl, g.bhf)) {
      paramb.b(17, this.Bfl);
    }
    if (this.wNy != -1) {
      paramb.bj(18, this.wNy);
    }
    if ((this.Bfm != null) && (this.Bfm.length > 0))
    {
      i = j;
      while (i < this.Bfm.length)
      {
        paramb.bk(19, this.Bfm[i]);
        i += 1;
      }
    }
    if (this.Bep != 0) {
      paramb.bk(20, this.Bep);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
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
    if (this.BeZ != null)
    {
      i = j;
      if (this.BeZ.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.BeZ.length)
        {
          localObject = this.BeZ[j];
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
    if (this.Ben != null) {
      k = i + b.b(6, this.Ben);
    }
    j = k;
    if (this.Bfc != 0) {
      j = k + b.bl(7, this.Bfc);
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
    if (this.Bfb != null)
    {
      j = i;
      if (this.Bfb.length > 0)
      {
        j = 0;
        while (j < this.Bfb.length)
        {
          localObject = this.Bfb[j];
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
    if (this.BdI != null) {
      i = j + b.b(10, this.BdI);
    }
    j = i;
    if (this.Bfe != null)
    {
      j = i;
      if (this.Bfe.length > 0)
      {
        j = 0;
        while (j < this.Bfe.length)
        {
          localObject = this.Bfe[j];
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
    if (this.Bet != null)
    {
      i = j;
      if (this.Bet.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Bet.length)
        {
          localObject = this.Bet[j];
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
    if (this.Bfh != null)
    {
      j = i;
      if (this.Bfh.length > 0)
      {
        j = 0;
        while (j < this.Bfh.length)
        {
          localObject = this.Bfh[j];
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
    if (this.Bfi != 0) {
      i = j + b.bl(14, this.Bfi);
    }
    j = i;
    if (this.Bfj != 0) {
      j = i + b.bl(15, this.Bfj);
    }
    i = j;
    if (this.Bfk != 0) {
      i = j + b.bl(16, this.Bfk);
    }
    j = i;
    if (!Arrays.equals(this.Bfl, g.bhf)) {
      j = i + b.c(17, this.Bfl);
    }
    i = j;
    if (this.wNy != -1) {
      i = j + b.bl(18, this.wNy);
    }
    j = i;
    if (this.Bfm != null)
    {
      j = i;
      if (this.Bfm.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Bfm.length)
        {
          k += b.eY(this.Bfm[j]);
          j += 1;
        }
        j = i + k + this.Bfm.length * 2;
      }
    }
    i = j;
    if (this.Bep != 0) {
      i = j + b.bm(20, this.Bep);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.aj
 * JD-Core Version:    0.7.0.1
 */