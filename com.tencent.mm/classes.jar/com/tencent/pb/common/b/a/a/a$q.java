package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$q
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int MdF = 0;
  public a.az[] MdG = a.az.fXG();
  public a.ay[] MdH = a.ay.fXF();
  public a.av MdI = null;
  public int MdJ = 0;
  public int MdK = 0;
  public int MdL = 0;
  public byte[] MdM = g.bQV;
  public byte[] MdN = g.bQV;
  public a.ay[] MdO = a.ay.fXF();
  public a.aw Mdb = null;
  public int Mde = 0;
  public a.bb Mdg = null;
  public int audioStreamType = 0;
  public String groupId = "";
  public int iqb = 0;
  public long msgId = 0L;
  
  public a$q()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.MdF != 0) {
      paramb.bx(1, this.MdF);
    }
    if (!this.groupId.equals("")) {
      paramb.d(2, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(3, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(4, this.Cug);
    }
    if (this.Mde != 0) {
      paramb.by(5, this.Mde);
    }
    if (this.Mdb != null) {
      paramb.a(6, this.Mdb);
    }
    int i;
    Object localObject;
    if ((this.MdG != null) && (this.MdG.length > 0))
    {
      i = 0;
      while (i < this.MdG.length)
      {
        localObject = this.MdG[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.MdH != null) && (this.MdH.length > 0))
    {
      i = 0;
      while (i < this.MdH.length)
      {
        localObject = this.MdH[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.MdI != null) {
      paramb.a(9, this.MdI);
    }
    if (this.Mdg != null) {
      paramb.a(10, this.Mdg);
    }
    if (this.MdJ != 0) {
      paramb.by(11, this.MdJ);
    }
    if (this.MdK != 0) {
      paramb.by(12, this.MdK);
    }
    if (this.iqb != 0) {
      paramb.by(13, this.iqb);
    }
    if (this.msgId != 0L) {
      paramb.m(101, this.msgId);
    }
    if (this.MdL != 0) {
      paramb.by(102, this.MdL);
    }
    if (!Arrays.equals(this.MdM, g.bQV)) {
      paramb.b(103, this.MdM);
    }
    if (!Arrays.equals(this.MdN, g.bQV)) {
      paramb.b(200, this.MdN);
    }
    if ((this.MdO != null) && (this.MdO.length > 0))
    {
      i = j;
      while (i < this.MdO.length)
      {
        localObject = this.MdO[i];
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
    if (this.MdF != 0) {
      i = j + b.bz(1, this.MdF);
    }
    j = i;
    if (!this.groupId.equals("")) {
      j = i + b.e(2, this.groupId);
    }
    i = j;
    if (this.Cuf != 0) {
      i = j + b.bz(3, this.Cuf);
    }
    j = i;
    if (this.Cug != 0L) {
      j = i + b.p(4, this.Cug);
    }
    int k = j;
    if (this.Mde != 0) {
      k = j + b.bA(5, this.Mde);
    }
    i = k;
    if (this.Mdb != null) {
      i = k + b.b(6, this.Mdb);
    }
    j = i;
    Object localObject;
    if (this.MdG != null)
    {
      j = i;
      if (this.MdG.length > 0)
      {
        j = 0;
        while (j < this.MdG.length)
        {
          localObject = this.MdG[j];
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
    if (this.MdH != null)
    {
      i = j;
      if (this.MdH.length > 0)
      {
        k = 0;
        i = j;
        j = k;
        while (j < this.MdH.length)
        {
          localObject = this.MdH[j];
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
    if (this.MdI != null) {
      j = i + b.b(9, this.MdI);
    }
    i = j;
    if (this.Mdg != null) {
      i = j + b.b(10, this.Mdg);
    }
    j = i;
    if (this.MdJ != 0) {
      j = i + b.bA(11, this.MdJ);
    }
    i = j;
    if (this.MdK != 0) {
      i = j + b.bA(12, this.MdK);
    }
    j = i;
    if (this.iqb != 0) {
      j = i + b.bA(13, this.iqb);
    }
    i = j;
    if (this.msgId != 0L) {
      i = j + b.o(101, this.msgId);
    }
    j = i;
    if (this.MdL != 0) {
      j = i + b.bA(102, this.MdL);
    }
    k = j;
    if (!Arrays.equals(this.MdM, g.bQV)) {
      k = j + b.c(103, this.MdM);
    }
    i = k;
    if (!Arrays.equals(this.MdN, g.bQV)) {
      i = k + b.c(200, this.MdN);
    }
    j = i;
    if (this.MdO != null)
    {
      j = i;
      if (this.MdO.length > 0)
      {
        k = m;
        for (;;)
        {
          j = i;
          if (k >= this.MdO.length) {
            break;
          }
          localObject = this.MdO[k];
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