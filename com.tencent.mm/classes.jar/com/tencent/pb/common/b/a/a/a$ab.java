package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ab
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Gsd = -1;
  public int MdA = 0;
  public a.av MdI = null;
  public int MdK = 0;
  public a.ay[] MdO = a.ay.fXF();
  public a.aw Mdb = null;
  public int MeA = 0;
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
  public int Mez = 0;
  public String groupId = "";
  public int vGk = 0;
  
  public a$ab()
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
    if (this.vGk != 0) {
      paramb.bx(9, this.vGk);
    }
    if ((this.Mev != null) && (this.Mev.length > 0))
    {
      i = 0;
      while (i < this.Mev.length)
      {
        localObject = this.Mev[i];
        if (localObject != null) {
          paramb.a(10, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Mdb != null) {
      paramb.a(11, this.Mdb);
    }
    if (this.MdA != 0) {
      paramb.by(12, this.MdA);
    }
    if ((this.Mey != null) && (this.Mey.length > 0))
    {
      i = 0;
      while (i < this.Mey.length)
      {
        localObject = this.Mey[i];
        if (localObject != null) {
          paramb.a(13, (e)localObject);
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
          paramb.a(14, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.MeC != 0) {
      paramb.bx(15, this.MeC);
    }
    if (this.MeD != 0) {
      paramb.bx(16, this.MeD);
    }
    if (this.MeE != 0) {
      paramb.bx(17, this.MeE);
    }
    if (!Arrays.equals(this.MeF, g.bQV)) {
      paramb.b(18, this.MeF);
    }
    if (this.Gsd != -1) {
      paramb.bx(19, this.Gsd);
    }
    if ((this.MeG != null) && (this.MeG.length > 0))
    {
      i = 0;
      while (i < this.MeG.length)
      {
        paramb.by(20, this.MeG[i]);
        i += 1;
      }
    }
    if (this.MdK != 0) {
      paramb.by(21, this.MdK);
    }
    if (this.Mez != 0) {
      paramb.by(100, this.Mez);
    }
    if (this.MeA != 0) {
      paramb.by(101, this.MeA);
    }
    if ((this.MdO != null) && (this.MdO.length > 0))
    {
      i = j;
      while (i < this.MdO.length)
      {
        localObject = this.MdO[i];
        if (localObject != null) {
          paramb.a(102, (e)localObject);
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
    j = i;
    if (this.MdI != null) {
      j = i + b.b(6, this.MdI);
    }
    i = j;
    if (this.Mew != 0) {
      i = j + b.bz(7, this.Mew);
    }
    j = i;
    if (this.Mex != null)
    {
      j = i;
      if (this.Mex.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.Mex.length)
        {
          k += b.fL(this.Mex[j]);
          j += 1;
        }
        j = i + k + this.Mex.length * 1;
      }
    }
    i = j;
    if (this.vGk != 0) {
      i = j + b.bz(9, this.vGk);
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
            k = i + b.b(10, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    int k = j;
    if (this.Mdb != null) {
      k = j + b.b(11, this.Mdb);
    }
    i = k;
    if (this.MdA != 0) {
      i = k + b.bA(12, this.MdA);
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
            k = i + b.b(13, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.MeB != null)
    {
      i = j;
      if (this.MeB.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.MeB.length)
        {
          localObject = this.MeB[j];
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
    if (this.MeC != 0) {
      j = i + b.bz(15, this.MeC);
    }
    i = j;
    if (this.MeD != 0) {
      i = j + b.bz(16, this.MeD);
    }
    j = i;
    if (this.MeE != 0) {
      j = i + b.bz(17, this.MeE);
    }
    k = j;
    if (!Arrays.equals(this.MeF, g.bQV)) {
      k = j + b.c(18, this.MeF);
    }
    i = k;
    if (this.Gsd != -1) {
      i = k + b.bz(19, this.Gsd);
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
      i = j + b.bA(21, this.MdK);
    }
    j = i;
    if (this.Mez != 0) {
      j = i + b.bA(100, this.Mez);
    }
    i = j;
    if (this.MeA != 0) {
      i = j + b.bA(101, this.MeA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ab
 * JD-Core Version:    0.7.0.1
 */