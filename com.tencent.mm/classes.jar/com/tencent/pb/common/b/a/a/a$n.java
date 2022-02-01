package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$n
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public int Zfn = 0;
  public byte[] Zfo = g.ccX;
  public a.be[] Zfp = a.be.ikX();
  public a.at[] Zfq = a.at.ikS();
  public int Zfr = 0;
  public int Zfs = 0;
  public String groupId = "";
  public int mfT = 0;
  public int tQm = -1;
  
  public a$n()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int m = 0;
    int j = super.JG();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(1, this.groupId);
    }
    j = i;
    if (this.NOc != 0) {
      j = i + b.bM(2, this.NOc);
    }
    i = j;
    if (this.NOd != 0L) {
      i = j + b.p(3, this.NOd);
    }
    j = i;
    if (this.tQm != -1) {
      j = i + b.bM(4, this.tQm);
    }
    int k = j;
    if (this.Zfn != 0) {
      k = j + b.bM(5, this.Zfn);
    }
    i = k;
    if (!Arrays.equals(this.Zfo, g.ccX)) {
      i = k + b.c(6, this.Zfo);
    }
    j = i;
    Object localObject;
    if (this.Zfp != null)
    {
      j = i;
      if (this.Zfp.length > 0)
      {
        j = 0;
        while (j < this.Zfp.length)
        {
          localObject = this.Zfp[j];
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
    if (this.Zfq != null)
    {
      i = j;
      if (this.Zfq.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.Zfq.length) {
            break;
          }
          localObject = this.Zfq[k];
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
    if (this.Zfr != 0) {
      j = i + b.bM(9, this.Zfr);
    }
    i = j;
    if (this.Zfs != 0) {
      i = j + b.bM(10, this.Zfs);
    }
    j = i;
    if (this.mfT != 0) {
      j = i + b.bM(11, this.mfT);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    if (this.tQm != -1) {
      paramb.bJ(4, this.tQm);
    }
    if (this.Zfn != 0) {
      paramb.bJ(5, this.Zfn);
    }
    if (!Arrays.equals(this.Zfo, g.ccX)) {
      paramb.b(6, this.Zfo);
    }
    int i;
    Object localObject;
    if ((this.Zfp != null) && (this.Zfp.length > 0))
    {
      i = 0;
      while (i < this.Zfp.length)
      {
        localObject = this.Zfp[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.Zfq != null) && (this.Zfq.length > 0))
    {
      i = j;
      while (i < this.Zfq.length)
      {
        localObject = this.Zfq[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Zfr != 0) {
      paramb.bJ(9, this.Zfr);
    }
    if (this.Zfs != 0) {
      paramb.bJ(10, this.Zfs);
    }
    if (this.mfT != 0) {
      paramb.bJ(11, this.mfT);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */