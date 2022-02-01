package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$be
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public int Mde = 0;
  public a.ay[] Met = a.ay.fXF();
  public String MfK = "";
  public int Mgs = 0;
  public String Mgt = "";
  public String[] Mgu = g.EMPTY_STRING_ARRAY;
  public long Mgv = 0L;
  public String groupId = "";
  
  public a$be()
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
    if (this.Mde != 0) {
      paramb.by(4, this.Mde);
    }
    if (this.Mgs != 0) {
      paramb.bx(5, this.Mgs);
    }
    if (!this.MfK.equals("")) {
      paramb.d(6, this.MfK);
    }
    int i;
    Object localObject;
    if ((this.Met != null) && (this.Met.length > 0))
    {
      i = 0;
      while (i < this.Met.length)
      {
        localObject = this.Met[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.Mgt.equals("")) {
      paramb.d(8, this.Mgt);
    }
    if ((this.Mgu != null) && (this.Mgu.length > 0))
    {
      i = j;
      while (i < this.Mgu.length)
      {
        localObject = this.Mgu[i];
        if (localObject != null) {
          paramb.d(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.Mgv != 0L) {
      paramb.m(10, this.Mgv);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
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
    if (this.Mde != 0) {
      j = i + b.bA(4, this.Mde);
    }
    int k = j;
    if (this.Mgs != 0) {
      k = j + b.bz(5, this.Mgs);
    }
    i = k;
    if (!this.MfK.equals("")) {
      i = k + b.e(6, this.MfK);
    }
    j = i;
    Object localObject;
    if (this.Met != null)
    {
      j = i;
      if (this.Met.length > 0)
      {
        j = 0;
        while (j < this.Met.length)
        {
          localObject = this.Met[j];
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
    if (!this.Mgt.equals("")) {
      i = j + b.e(8, this.Mgt);
    }
    j = i;
    if (this.Mgu != null)
    {
      j = i;
      if (this.Mgu.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.Mgu.length; m = n)
        {
          localObject = this.Mgu[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.cc((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.Mgv != 0L) {
      i = j + b.o(10, this.Mgv);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */