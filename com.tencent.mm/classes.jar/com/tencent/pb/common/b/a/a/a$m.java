package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$m
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JME = 0;
  public byte[] JMF = g.bGH;
  public a.bc[] JMG = a.bc.fBS();
  public a.ar[] JMH = a.ar.fBN();
  public int JMI = 0;
  public int JMJ = 0;
  public String groupId = "";
  public int hYQ = 0;
  public int osF = -1;
  
  public a$m()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.ADE != 0) {
      paramb.bv(2, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(3, this.ADF);
    }
    if (this.osF != -1) {
      paramb.bv(4, this.osF);
    }
    if (this.JME != 0) {
      paramb.bv(5, this.JME);
    }
    if (!Arrays.equals(this.JMF, g.bGH)) {
      paramb.b(6, this.JMF);
    }
    int i;
    Object localObject;
    if ((this.JMG != null) && (this.JMG.length > 0))
    {
      i = 0;
      while (i < this.JMG.length)
      {
        localObject = this.JMG[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if ((this.JMH != null) && (this.JMH.length > 0))
    {
      i = j;
      while (i < this.JMH.length)
      {
        localObject = this.JMH[i];
        if (localObject != null) {
          paramb.a(8, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMI != 0) {
      paramb.bv(9, this.JMI);
    }
    if (this.JMJ != 0) {
      paramb.bv(10, this.JMJ);
    }
    if (this.hYQ != 0) {
      paramb.bv(11, this.hYQ);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int m = 0;
    int j = super.xT();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.ADE != 0) {
      j = i + b.bx(2, this.ADE);
    }
    i = j;
    if (this.ADF != 0L) {
      i = j + b.p(3, this.ADF);
    }
    j = i;
    if (this.osF != -1) {
      j = i + b.bx(4, this.osF);
    }
    int k = j;
    if (this.JME != 0) {
      k = j + b.bx(5, this.JME);
    }
    i = k;
    if (!Arrays.equals(this.JMF, g.bGH)) {
      i = k + b.c(6, this.JMF);
    }
    j = i;
    Object localObject;
    if (this.JMG != null)
    {
      j = i;
      if (this.JMG.length > 0)
      {
        j = 0;
        while (j < this.JMG.length)
        {
          localObject = this.JMG[j];
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
    if (this.JMH != null)
    {
      i = j;
      if (this.JMH.length > 0)
      {
        k = m;
        for (;;)
        {
          i = j;
          if (k >= this.JMH.length) {
            break;
          }
          localObject = this.JMH[k];
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
    if (this.JMI != 0) {
      j = i + b.bx(9, this.JMI);
    }
    i = j;
    if (this.JMJ != 0) {
      i = j + b.bx(10, this.JMJ);
    }
    j = i;
    if (this.hYQ != 0) {
      j = i + b.bx(11, this.hYQ);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */