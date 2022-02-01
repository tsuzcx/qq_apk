package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$d
  extends e
{
  public String JMm = "";
  public a.aw JMo = null;
  public int[] JMp = g.bGB;
  public a.bd JMq = null;
  public int JMr = 0;
  public int JMs = 0;
  public a.bb JMt = null;
  public String JMu = "";
  public String[] JMv = g.EMPTY_STRING_ARRAY;
  public a.n[] JMw = a.n.fBH();
  public int JMx = 0;
  public int netType = 0;
  
  public a$d()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.JMo != null) {
      paramb.a(1, this.JMo);
    }
    int i;
    if ((this.JMp != null) && (this.JMp.length > 0))
    {
      i = 0;
      while (i < this.JMp.length)
      {
        paramb.bw(2, this.JMp[i]);
        i += 1;
      }
    }
    if (this.JMq != null) {
      paramb.a(3, this.JMq);
    }
    if (this.JMr != 0) {
      paramb.bw(4, this.JMr);
    }
    if (this.JMs != 0) {
      paramb.bw(5, this.JMs);
    }
    if (this.JMt != null) {
      paramb.a(6, this.JMt);
    }
    if (!this.JMm.equals("")) {
      paramb.d(7, this.JMm);
    }
    if (!this.JMu.equals("")) {
      paramb.d(8, this.JMu);
    }
    if (this.netType != 0) {
      paramb.bw(9, this.netType);
    }
    Object localObject;
    if ((this.JMv != null) && (this.JMv.length > 0))
    {
      i = 0;
      while (i < this.JMv.length)
      {
        localObject = this.JMv[i];
        if (localObject != null) {
          paramb.d(100, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.JMw != null) && (this.JMw.length > 0))
    {
      i = j;
      while (i < this.JMw.length)
      {
        localObject = this.JMw[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.JMx != 0) {
      paramb.bw(240, this.JMx);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int i2 = 0;
    int j = super.xT();
    int i = j;
    if (this.JMo != null) {
      i = j + b.b(1, this.JMo);
    }
    j = i;
    if (this.JMp != null)
    {
      j = i;
      if (this.JMp.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.JMp.length)
        {
          k += b.fM(this.JMp[j]);
          j += 1;
        }
        j = i + k + this.JMp.length * 1;
      }
    }
    i = j;
    if (this.JMq != null) {
      i = j + b.b(3, this.JMq);
    }
    j = i;
    if (this.JMr != 0) {
      j = i + b.by(4, this.JMr);
    }
    i = j;
    if (this.JMs != 0) {
      i = j + b.by(5, this.JMs);
    }
    j = i;
    if (this.JMt != null) {
      j = i + b.b(6, this.JMt);
    }
    i = j;
    if (!this.JMm.equals("")) {
      i = j + b.e(7, this.JMm);
    }
    int k = i;
    if (!this.JMu.equals("")) {
      k = i + b.e(8, this.JMu);
    }
    j = k;
    if (this.netType != 0) {
      j = k + b.by(9, this.netType);
    }
    i = j;
    Object localObject;
    if (this.JMv != null)
    {
      i = j;
      if (this.JMv.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.JMv.length; m = n)
        {
          localObject = this.JMv[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.bj((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.JMw != null)
    {
      j = i;
      if (this.JMw.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.JMw.length) {
            break;
          }
          localObject = this.JMw[k];
          j = i;
          if (localObject != null) {
            j = i + b.b(202, (e)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (this.JMx != 0) {
      i = j + b.by(240, this.JMx);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */