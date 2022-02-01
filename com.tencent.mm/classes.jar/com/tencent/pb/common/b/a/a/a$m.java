package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$m
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Mdr = 0;
  public byte[] Mds = g.bQV;
  public a.bc[] Mdt = a.bc.fXH();
  public a.ar[] Mdu = a.ar.fXC();
  public int Mdv = 0;
  public int Mdw = 0;
  public String groupId = "";
  public int ivg = 0;
  public int pcE = -1;
  
  public a$m()
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
    if (this.pcE != -1) {
      paramb.bx(4, this.pcE);
    }
    if (this.Mdr != 0) {
      paramb.bx(5, this.Mdr);
    }
    if (!Arrays.equals(this.Mds, g.bQV)) {
      paramb.b(6, this.Mds);
    }
    int i;
    Object localObject;
    if ((this.Mdt != null) && (this.Mdt.length > 0))
    {
      i = 0;
      while (i < this.Mdt.length)
      {
        localObject = this.Mdt[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Mdu != null) && (this.Mdu.length > 0))
    {
      i = j;
      while (i < this.Mdu.length)
      {
        localObject = this.Mdu[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Mdv != 0) {
      paramb.bx(9, this.Mdv);
    }
    if (this.Mdw != 0) {
      paramb.bx(10, this.Mdw);
    }
    if (this.ivg != 0) {
      paramb.bx(11, this.ivg);
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
    if (this.pcE != -1) {
      j = i + b.bz(4, this.pcE);
    }
    int k = j;
    if (this.Mdr != 0) {
      k = j + b.bz(5, this.Mdr);
    }
    i = k;
    if (!Arrays.equals(this.Mds, g.bQV)) {
      i = k + b.c(6, this.Mds);
    }
    j = i;
    Object localObject;
    if (this.Mdt != null)
    {
      j = i;
      if (this.Mdt.length > 0)
      {
        j = 0;
        while (j < this.Mdt.length)
        {
          localObject = this.Mdt[j];
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
    if (this.Mdu != null)
    {
      i = j;
      if (this.Mdu.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.Mdu.length) {
            break;
          }
          localObject = this.Mdu[k];
          i = j;
          if (localObject != null) {
            i = j + b.b(8, (e)localObject);
          }
          k += 1;
          j = i;
        }
      }
    }
    j = i;
    if (this.Mdv != 0) {
      j = i + b.bz(9, this.Mdv);
    }
    i = j;
    if (this.Mdw != 0) {
      i = j + b.bz(10, this.Mdw);
    }
    j = i;
    if (this.ivg != 0) {
      j = i + b.bz(11, this.ivg);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */