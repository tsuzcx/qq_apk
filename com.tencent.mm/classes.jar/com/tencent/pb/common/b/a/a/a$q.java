package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$q
  extends e
{
  public a.aw IkD = null;
  public int IkG = 0;
  public a.bb IkI = null;
  public int Ilh = 0;
  public a.az[] Ili = a.az.flA();
  public a.ay[] Ilj = a.ay.flz();
  public a.av Ilk = null;
  public int Ill = 0;
  public int Ilm = 0;
  public int Iln = 0;
  public byte[] Ilo = g.bIZ;
  public byte[] Ilp = g.bIZ;
  public a.ay[] Ilq = a.ay.flz();
  public int audioStreamType = 0;
  public String groupId = "";
  public int htk = 0;
  public long msgId = 0L;
  public int zkT = 0;
  public long zkU = 0L;
  
  public a$q()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.Ilh != 0) {
      paramb.by(1, this.Ilh);
    }
    if (!this.groupId.equals("")) {
      paramb.d(2, this.groupId);
    }
    if (this.zkT != 0) {
      paramb.by(3, this.zkT);
    }
    if (this.zkU != 0L) {
      paramb.o(4, this.zkU);
    }
    if (this.IkG != 0) {
      paramb.bz(5, this.IkG);
    }
    if (this.IkD != null) {
      paramb.a(6, this.IkD);
    }
    int i;
    Object localObject;
    if ((this.Ili != null) && (this.Ili.length > 0))
    {
      i = 0;
      while (i < this.Ili.length)
      {
        localObject = this.Ili[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Ilj != null) && (this.Ilj.length > 0))
    {
      i = 0;
      while (i < this.Ilj.length)
      {
        localObject = this.Ilj[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Ilk != null) {
      paramb.a(9, this.Ilk);
    }
    if (this.IkI != null) {
      paramb.a(10, this.IkI);
    }
    if (this.Ill != 0) {
      paramb.bz(11, this.Ill);
    }
    if (this.Ilm != 0) {
      paramb.bz(12, this.Ilm);
    }
    if (this.htk != 0) {
      paramb.bz(13, this.htk);
    }
    if (this.msgId != 0L) {
      paramb.n(101, this.msgId);
    }
    if (this.Iln != 0) {
      paramb.bz(102, this.Iln);
    }
    if (!Arrays.equals(this.Ilo, g.bIZ)) {
      paramb.b(103, this.Ilo);
    }
    if (!Arrays.equals(this.Ilp, g.bIZ)) {
      paramb.b(200, this.Ilp);
    }
    if ((this.Ilq != null) && (this.Ilq.length > 0))
    {
      i = j;
      while (i < this.Ilq.length)
      {
        localObject = this.Ilq[i];
        if (localObject != null) {
          paramb.a(201, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.audioStreamType != 0) {
      paramb.by(202, this.audioStreamType);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int m = 0;
    int j = super.yg();
    int i = j;
    if (this.Ilh != 0) {
      i = j + b.bA(1, this.Ilh);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.e(2, this.groupId);
    }
    i = j;
    if (this.zkT != 0) {
      i = j + b.bA(3, this.zkT);
    }
    j = i;
    if (this.zkU != 0L) {
      j = i + b.q(4, this.zkU);
    }
    int k = j;
    if (this.IkG != 0) {
      k = j + b.bB(5, this.IkG);
    }
    i = k;
    if (this.IkD != null) {
      i = k + b.b(6, this.IkD);
    }
    j = i;
    Object localObject;
    if (this.Ili != null)
    {
      j = i;
      if (this.Ili.length > 0)
      {
        j = 0;
        while (j < this.Ili.length)
        {
          localObject = this.Ili[j];
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
    if (this.Ilj != null)
    {
      i = j;
      if (this.Ilj.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.Ilj.length)
        {
          localObject = this.Ilj[j];
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
    if (this.Ilk != null) {
      j = i + b.b(9, this.Ilk);
    }
    i = j;
    if (this.IkI != null) {
      i = j + b.b(10, this.IkI);
    }
    j = i;
    if (this.Ill != 0) {
      j = i + b.bB(11, this.Ill);
    }
    i = j;
    if (this.Ilm != 0) {
      i = j + b.bB(12, this.Ilm);
    }
    j = i;
    if (this.htk != 0) {
      j = i + b.bB(13, this.htk);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.p(101, this.msgId);
    }
    j = i;
    if (this.Iln != 0) {
      j = i + b.bB(102, this.Iln);
    }
    k = j;
    if (!Arrays.equals(this.Ilo, g.bIZ)) {
      k = j + b.c(103, this.Ilo);
    }
    i = k;
    if (!Arrays.equals(this.Ilp, g.bIZ)) {
      i = k + b.c(200, this.Ilp);
    }
    j = i;
    if (this.Ilq != null)
    {
      j = i;
      if (this.Ilq.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.Ilq.length) {
            break;
          }
          localObject = this.Ilq[k];
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
      i = j + b.bA(202, this.audioStreamType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.q
 * JD-Core Version:    0.7.0.1
 */