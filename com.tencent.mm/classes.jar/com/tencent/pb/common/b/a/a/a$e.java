package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$e
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public int JMk = 0;
  public a.aw JMo = null;
  public a.bd JMq = null;
  public int JMs = 0;
  public String[] JMv = g.EMPTY_STRING_ARRAY;
  public a.n[] JMw = a.n.fBH();
  public int JMx = 0;
  public a.t JMy = null;
  public int JMz = 0;
  public String groupId = "";
  public int netType = 0;
  public int urD = 0;
  
  public a$e()
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
    if (this.JMq != null) {
      paramb.a(4, this.JMq);
    }
    if (this.urD != 0) {
      paramb.bv(5, this.urD);
    }
    if (this.JMs != 0) {
      paramb.bw(6, this.JMs);
    }
    if (this.JMk != 0) {
      paramb.bv(7, this.JMk);
    }
    if (this.netType != 0) {
      paramb.bw(8, this.netType);
    }
    if (this.JMo != null) {
      paramb.a(200, this.JMo);
    }
    int i;
    Object localObject;
    if ((this.JMv != null) && (this.JMv.length > 0))
    {
      i = 0;
      while (i < this.JMv.length)
      {
        localObject = this.JMv[i];
        if (localObject != null) {
          paramb.d(201, (String)localObject);
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
    if (this.JMy != null) {
      paramb.a(203, this.JMy);
    }
    if (this.JMz != 0) {
      paramb.bw(204, this.JMz);
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
    if (this.JMq != null) {
      j = i + b.b(4, this.JMq);
    }
    i = j;
    if (this.urD != 0) {
      i = j + b.bx(5, this.urD);
    }
    j = i;
    if (this.JMs != 0) {
      j = i + b.by(6, this.JMs);
    }
    i = j;
    if (this.JMk != 0) {
      i = j + b.bx(7, this.JMk);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.by(8, this.netType);
    }
    j = k;
    if (this.JMo != null) {
      j = k + b.b(200, this.JMo);
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
    if (this.JMy != null) {
      i = j + b.b(203, this.JMy);
    }
    j = i;
    if (this.JMz != 0) {
      j = i + b.by(204, this.JMz);
    }
    i = j;
    if (this.JMx != 0) {
      i = j + b.by(240, this.JMx);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */