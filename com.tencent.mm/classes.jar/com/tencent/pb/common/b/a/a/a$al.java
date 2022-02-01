package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$al
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Gsd = -1;
  public a.av MdI = null;
  public int MdK = 0;
  public a.ay[] MdO = a.ay.fXF();
  public a.aw Mdb = null;
  public a.p[] MeB = a.p.fXy();
  public int MeC = 0;
  public int MeD = 0;
  public int MeE = 0;
  public byte[] MeF = g.bQV;
  public int[] MeG = g.bQP;
  public a.ay[] Met = a.ay.fXF();
  public a.p[] Meu = a.p.fXy();
  public a.az[] Mev = a.az.fXG();
  public int Mew = 0;
  public int[] Mex = g.bQP;
  public a.p[] Mey = a.p.fXy();
  public String groupId = "";
  
  public a$al()
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
    if ((this.Met != null) && (this.Met.length > 0))
    {
      i = 0;
      while (i < this.Met.length)
      {
        localObject = this.Met[i];
        if (localObject != null) {
          paramb.a(5, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.MdI != null) {
      paramb.a(6, this.MdI);
    }
    if (this.Mew != 0) {
      paramb.bx(7, this.Mew);
    }
    if ((this.Mex != null) && (this.Mex.length > 0))
    {
      i = 0;
      while (i < this.Mex.length)
      {
        paramb.bx(8, this.Mex[i]);
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
          paramb.a(9, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Mdb != null) {
      paramb.a(10, this.Mdb);
    }
    if ((this.Mey != null) && (this.Mey.length > 0))
    {
      i = 0;
      while (i < this.Mey.length)
      {
        localObject = this.Mey[i];
        if (localObject != null) {
          paramb.a(11, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.MdO != null) && (this.MdO.length > 0))
    {
      i = 0;
      while (i < this.MdO.length)
      {
        localObject = this.MdO[i];
        if (localObject != null) {
          paramb.a(12, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.MeB != null) && (this.MeB.length > 0))
    {
      i = 0;
      while (i < this.MeB.length)
      {
        localObject = this.MeB[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.MeC != 0) {
      paramb.bx(14, this.MeC);
    }
    if (this.MeD != 0) {
      paramb.bx(15, this.MeD);
    }
    if (this.MeE != 0) {
      paramb.bx(16, this.MeE);
    }
    if (!Arrays.equals(this.MeF, g.bQV)) {
      paramb.b(17, this.MeF);
    }
    if (this.Gsd != -1) {
      paramb.bx(18, this.Gsd);
    }
    if ((this.MeG != null) && (this.MeG.length > 0))
    {
      i = j;
      while (i < this.MeG.length)
      {
        paramb.by(19, this.MeG[i]);
        i += 1;
      }
    }
    if (this.MdK != 0) {
      paramb.by(20, this.MdK);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
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
    if (this.Met != null)
    {
      i = j;
      if (this.Met.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Met.length)
        {
          localObject = this.Met[j];
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
    if (this.MdI != null) {
      k = i + b.b(6, this.MdI);
    }
    j = k;
    if (this.Mew != 0) {
      j = k + b.bz(7, this.Mew);
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
    if (this.Mev != null)
    {
      j = i;
      if (this.Mev.length > 0)
      {
        j = 0;
        while (j < this.Mev.length)
        {
          localObject = this.Mev[j];
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
    if (this.Mdb != null) {
      i = j + b.b(10, this.Mdb);
    }
    j = i;
    if (this.Mey != null)
    {
      j = i;
      if (this.Mey.length > 0)
      {
        j = 0;
        while (j < this.Mey.length)
        {
          localObject = this.Mey[j];
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
    if (this.MdO != null)
    {
      i = j;
      if (this.MdO.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.MdO.length)
        {
          localObject = this.MdO[j];
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
    if (this.MeB != null)
    {
      j = i;
      if (this.MeB.length > 0)
      {
        j = 0;
        while (j < this.MeB.length)
        {
          localObject = this.MeB[j];
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
    if (this.MeC != 0) {
      i = j + b.bz(14, this.MeC);
    }
    j = i;
    if (this.MeD != 0) {
      j = i + b.bz(15, this.MeD);
    }
    i = j;
    if (this.MeE != 0) {
      i = j + b.bz(16, this.MeE);
    }
    j = i;
    if (!Arrays.equals(this.MeF, g.bQV)) {
      j = i + b.c(17, this.MeF);
    }
    i = j;
    if (this.Gsd != -1) {
      i = j + b.bz(18, this.Gsd);
    }
    j = i;
    if (this.MeG != null)
    {
      j = i;
      if (this.MeG.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.MeG.length)
        {
          k += b.fP(this.MeG[j]);
          j += 1;
        }
        j = i + k + this.MeG.length * 2;
      }
    }
    i = j;
    if (this.MdK != 0) {
      i = j + b.bA(20, this.MdK);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.al
 * JD-Core Version:    0.7.0.1
 */