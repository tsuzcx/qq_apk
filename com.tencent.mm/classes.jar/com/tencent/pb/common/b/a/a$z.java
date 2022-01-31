package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$z
  extends e
{
  public String BdG = "";
  public a.at BdI = null;
  public int BdL = 0;
  public int Beg = 0;
  public a.av[] Bem = a.av.dTR();
  public a.as Ben = null;
  public int Bep = 0;
  public a.av[] Bet = a.av.dTR();
  public a.o[] Bfa = a.o.dTL();
  public a.aw[] Bfb = a.aw.dTS();
  public int Bfc = 0;
  public int[] Bfd = g.bgZ;
  public a.o[] Bfe = a.o.dTL();
  public int Bff = 0;
  public int Bfg = 0;
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
  
  public a$z()
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
    if (this.BdL != 0) {
      paramb.bk(4, this.BdL);
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
          paramb.a(5, (e)localObject);
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
          paramb.a(6, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ben != null) {
      paramb.a(7, this.Ben);
    }
    if (!this.BdG.equals("")) {
      paramb.e(8, this.BdG);
    }
    if ((this.Bem != null) && (this.Bem.length > 0))
    {
      i = 0;
      while (i < this.Bem.length)
      {
        localObject = this.Bem[i];
        if (localObject != null) {
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Bfc != 0) {
      paramb.bj(10, this.Bfc);
    }
    if ((this.Bfd != null) && (this.Bfd.length > 0))
    {
      i = 0;
      while (i < this.Bfd.length)
      {
        paramb.bj(11, this.Bfd[i]);
        i += 1;
      }
    }
    if (this.BdI != null) {
      paramb.a(12, this.BdI);
    }
    if (this.Beg != 0) {
      paramb.bk(13, this.Beg);
    }
    if ((this.Bfe != null) && (this.Bfe.length > 0))
    {
      i = 0;
      while (i < this.Bfe.length)
      {
        localObject = this.Bfe[i];
        if (localObject != null) {
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Bff != 0) {
      paramb.bk(15, this.Bff);
    }
    if (this.Bfg != 0) {
      paramb.bk(16, this.Bfg);
    }
    if ((this.Bet != null) && (this.Bet.length > 0))
    {
      i = 0;
      while (i < this.Bet.length)
      {
        localObject = this.Bet[i];
        if (localObject != null) {
          paramb.a(17, (e)localObject);
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
          paramb.a(18, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Bfi != 0) {
      paramb.bj(19, this.Bfi);
    }
    if (this.Bfj != 0) {
      paramb.bj(20, this.Bfj);
    }
    if (this.Bfk != 0) {
      paramb.bj(21, this.Bfk);
    }
    if (!Arrays.equals(this.Bfl, g.bhf)) {
      paramb.b(22, this.Bfl);
    }
    if (this.wNy != -1) {
      paramb.bj(23, this.wNy);
    }
    if ((this.Bfm != null) && (this.Bfm.length > 0))
    {
      i = j;
      while (i < this.Bfm.length)
      {
        paramb.bk(24, this.Bfm[i]);
        i += 1;
      }
    }
    if (this.Bep != 0) {
      paramb.bk(25, this.Bep);
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
    int k = j;
    if (this.twQ != 0L) {
      k = j + b.p(3, this.twQ);
    }
    i = k;
    if (this.BdL != 0) {
      i = k + b.bm(4, this.BdL);
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
            k = i + b.b(5, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Bfb != null)
    {
      i = j;
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
            k = i + b.b(6, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Ben != null) {
      j = i + b.b(7, this.Ben);
    }
    i = j;
    if (!this.BdG.equals("")) {
      i = j + b.f(8, this.BdG);
    }
    j = i;
    if (this.Bem != null)
    {
      j = i;
      if (this.Bem.length > 0)
      {
        j = 0;
        while (j < this.Bem.length)
        {
          localObject = this.Bem[j];
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
    if (this.Bfc != 0) {
      i = j + b.bl(10, this.Bfc);
    }
    j = i;
    if (this.Bfd != null)
    {
      j = i;
      if (this.Bfd.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Bfd.length)
        {
          k += b.eU(this.Bfd[j]);
          j += 1;
        }
        j = i + k + this.Bfd.length * 1;
      }
    }
    k = j;
    if (this.BdI != null) {
      k = j + b.b(12, this.BdI);
    }
    i = k;
    if (this.Beg != 0) {
      i = k + b.bm(13, this.Beg);
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
            k = i + b.b(14, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    k = j;
    if (this.Bff != 0) {
      k = j + b.bm(15, this.Bff);
    }
    i = k;
    if (this.Bfg != 0) {
      i = k + b.bm(16, this.Bfg);
    }
    j = i;
    if (this.Bet != null)
    {
      j = i;
      if (this.Bet.length > 0)
      {
        j = 0;
        while (j < this.Bet.length)
        {
          localObject = this.Bet[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(17, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Bfh != null)
    {
      i = j;
      if (this.Bfh.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Bfh.length)
        {
          localObject = this.Bfh[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(18, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.Bfi != 0) {
      j = i + b.bl(19, this.Bfi);
    }
    i = j;
    if (this.Bfj != 0) {
      i = j + b.bl(20, this.Bfj);
    }
    j = i;
    if (this.Bfk != 0) {
      j = i + b.bl(21, this.Bfk);
    }
    k = j;
    if (!Arrays.equals(this.Bfl, g.bhf)) {
      k = j + b.c(22, this.Bfl);
    }
    i = k;
    if (this.wNy != -1) {
      i = k + b.bl(23, this.wNy);
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
      i = j + b.bm(25, this.Bep);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.z
 * JD-Core Version:    0.7.0.1
 */