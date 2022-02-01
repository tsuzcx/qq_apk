package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$e
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int McX = 0;
  public a.aw Mdb = null;
  public a.bd Mdd = null;
  public int Mdf = 0;
  public String[] Mdi = g.EMPTY_STRING_ARRAY;
  public a.n[] Mdj = a.n.fXw();
  public int Mdk = 0;
  public a.t Mdl = null;
  public int Mdm = 0;
  public String groupId = "";
  public int netType = 0;
  public int vGk = 0;
  
  public a$e()
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
    if (this.Mdd != null) {
      paramb.a(4, this.Mdd);
    }
    if (this.vGk != 0) {
      paramb.bx(5, this.vGk);
    }
    if (this.Mdf != 0) {
      paramb.by(6, this.Mdf);
    }
    if (this.McX != 0) {
      paramb.bx(7, this.McX);
    }
    if (this.netType != 0) {
      paramb.by(8, this.netType);
    }
    if (this.Mdb != null) {
      paramb.a(200, this.Mdb);
    }
    int i;
    Object localObject;
    if ((this.Mdi != null) && (this.Mdi.length > 0))
    {
      i = 0;
      while (i < this.Mdi.length)
      {
        localObject = this.Mdi[i];
        if (localObject != null) {
          paramb.d(201, (String)localObject);
        }
        i += 1;
      }
    }
    if ((this.Mdj != null) && (this.Mdj.length > 0))
    {
      i = j;
      while (i < this.Mdj.length)
      {
        localObject = this.Mdj[i];
        if (localObject != null) {
          paramb.a(202, (e)localObject);
        }
        i += 1;
      }
    }
    if (this.Mdl != null) {
      paramb.a(203, this.Mdl);
    }
    if (this.Mdm != 0) {
      paramb.by(204, this.Mdm);
    }
    if (this.Mdk != 0) {
      paramb.by(240, this.Mdk);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int i2 = 0;
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
    if (this.Mdd != null) {
      j = i + b.b(4, this.Mdd);
    }
    i = j;
    if (this.vGk != 0) {
      i = j + b.bz(5, this.vGk);
    }
    j = i;
    if (this.Mdf != 0) {
      j = i + b.bA(6, this.Mdf);
    }
    i = j;
    if (this.McX != 0) {
      i = j + b.bz(7, this.McX);
    }
    int k = i;
    if (this.netType != 0) {
      k = i + b.bA(8, this.netType);
    }
    j = k;
    if (this.Mdb != null) {
      j = k + b.b(200, this.Mdb);
    }
    i = j;
    Object localObject;
    if (this.Mdi != null)
    {
      i = j;
      if (this.Mdi.length > 0)
      {
        i = 0;
        k = 0;
        int n;
        for (int m = 0; i < this.Mdi.length; m = n)
        {
          localObject = this.Mdi[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cc((String)localObject);
          }
          i += 1;
          k = i1;
        }
        i = j + k + m * 2;
      }
    }
    j = i;
    if (this.Mdj != null)
    {
      j = i;
      if (this.Mdj.length > 0)
      {
        k = i2;
        for (;;)
        {
          j = i;
          if (k >= this.Mdj.length) {
            break;
          }
          localObject = this.Mdj[k];
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
    if (this.Mdl != null) {
      i = j + b.b(203, this.Mdl);
    }
    j = i;
    if (this.Mdm != 0) {
      j = i + b.bA(204, this.Mdm);
    }
    i = j;
    if (this.Mdk != 0) {
      i = j + b.bA(240, this.Mdk);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */