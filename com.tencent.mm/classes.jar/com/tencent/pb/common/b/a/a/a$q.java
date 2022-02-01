package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$q
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public a.aw LFX = null;
  public int LGB = 0;
  public a.az[] LGC = a.az.fTg();
  public a.ay[] LGD = a.ay.fTf();
  public a.av LGE = null;
  public int LGF = 0;
  public int LGG = 0;
  public int LGH = 0;
  public byte[] LGI = g.bQV;
  public byte[] LGJ = g.bQV;
  public a.ay[] LGK = a.ay.fTf();
  public int LGa = 0;
  public a.bb LGc = null;
  public int audioStreamType = 0;
  public String groupId = "";
  public int inh = 0;
  public long msgId = 0L;
  
  public a$q()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.LGB != 0) {
      paramb.bx(1, this.LGB);
    }
    if (!this.groupId.equals("")) {
      paramb.d(2, this.groupId);
    }
    if (this.CcE != 0) {
      paramb.bx(3, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(4, this.CcF);
    }
    if (this.LGa != 0) {
      paramb.by(5, this.LGa);
    }
    if (this.LFX != null) {
      paramb.a(6, this.LFX);
    }
    int i;
    Object localObject;
    if ((this.LGC != null) && (this.LGC.length > 0))
    {
      i = 0;
      while (i < this.LGC.length)
      {
        localObject = this.LGC[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.LGD != null) && (this.LGD.length > 0))
    {
      i = 0;
      while (i < this.LGD.length)
      {
        localObject = this.LGD[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.LGE != null) {
      paramb.a(9, this.LGE);
    }
    if (this.LGc != null) {
      paramb.a(10, this.LGc);
    }
    if (this.LGF != 0) {
      paramb.by(11, this.LGF);
    }
    if (this.LGG != 0) {
      paramb.by(12, this.LGG);
    }
    if (this.inh != 0) {
      paramb.by(13, this.inh);
    }
    if (this.msgId != 0L) {
      paramb.m(101, this.msgId);
    }
    if (this.LGH != 0) {
      paramb.by(102, this.LGH);
    }
    if (!Arrays.equals(this.LGI, g.bQV)) {
      paramb.b(103, this.LGI);
    }
    if (!Arrays.equals(this.LGJ, g.bQV)) {
      paramb.b(200, this.LGJ);
    }
    if ((this.LGK != null) && (this.LGK.length > 0))
    {
      i = j;
      while (i < this.LGK.length)
      {
        localObject = this.LGK[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.audioStreamType != 0) {
      paramb.bx(202, this.audioStreamType);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int m = 0;
    int j = super.zq();
    int i = j;
    if (this.LGB != 0) {
      i = j + b.bz(1, this.LGB);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.e(2, this.groupId);
    }
    i = j;
    if (this.CcE != 0) {
      i = j + b.bz(3, this.CcE);
    }
    j = i;
    if (this.CcF != 0L) {
      j = i + b.p(4, this.CcF);
    }
    int k = j;
    if (this.LGa != 0) {
      k = j + b.bA(5, this.LGa);
    }
    i = k;
    if (this.LFX != null) {
      i = k + b.b(6, this.LFX);
    }
    j = i;
    Object localObject;
    if (this.LGC != null)
    {
      j = i;
      if (this.LGC.length > 0)
      {
        j = 0;
        while (j < this.LGC.length)
        {
          localObject = this.LGC[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(7, (e)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.LGD != null)
    {
      i = j;
      if (this.LGD.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.LGD.length)
        {
          localObject = this.LGD[j];
          k = i;
          if (localObject != null) {
            k = i + b.b(8, (e)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    j = i;
    if (this.LGE != null) {
      j = i + b.b(9, this.LGE);
    }
    i = j;
    if (this.LGc != null) {
      i = j + b.b(10, this.LGc);
    }
    j = i;
    if (this.LGF != 0) {
      j = i + b.bA(11, this.LGF);
    }
    i = j;
    if (this.LGG != 0) {
      i = j + b.bA(12, this.LGG);
    }
    j = i;
    if (this.inh != 0) {
      j = i + b.bA(13, this.inh);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.o(101, this.msgId);
    }
    j = i;
    if (this.LGH != 0) {
      j = i + b.bA(102, this.LGH);
    }
    k = j;
    if (!Arrays.equals(this.LGI, g.bQV)) {
      k = j + b.c(103, this.LGI);
    }
    i = k;
    if (!Arrays.equals(this.LGJ, g.bQV)) {
      i = k + b.c(200, this.LGJ);
    }
    j = i;
    if (this.LGK != null)
    {
      j = i;
      if (this.LGK.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.LGK.length) {
            break;
          }
          localObject = this.LGK[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(201, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.audioStreamType != 0) {
      i = j + b.bz(202, this.audioStreamType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */