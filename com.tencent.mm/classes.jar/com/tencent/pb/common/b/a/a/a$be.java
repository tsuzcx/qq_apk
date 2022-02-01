package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$be
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int LGa = 0;
  public a.ay[] LHp = a.ay.fTf();
  public String LIG = "";
  public int LJo = 0;
  public String LJp = "";
  public String[] LJq = g.EMPTY_STRING_ARRAY;
  public long LJr = 0L;
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
    if (this.CcE != 0) {
      paramb.bx(2, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(3, this.CcF);
    }
    if (this.LGa != 0) {
      paramb.by(4, this.LGa);
    }
    if (this.LJo != 0) {
      paramb.bx(5, this.LJo);
    }
    if (!this.LIG.equals("")) {
      paramb.d(6, this.LIG);
    }
    int i;
    Object localObject;
    if ((this.LHp != null) && (this.LHp.length > 0))
    {
      i = 0;
      while (i < this.LHp.length)
      {
        localObject = this.LHp[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.LJp.equals("")) {
      paramb.d(8, this.LJp);
    }
    if ((this.LJq != null) && (this.LJq.length > 0))
    {
      i = j;
      while (i < this.LJq.length)
      {
        localObject = this.LJq[i];
        if (localObject != null) {
          paramb.d(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.LJr != 0L) {
      paramb.m(10, this.LJr);
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
    if (this.CcE != 0) {
      j = i + b.bz(2, this.CcE);
    }
    i = j;
    if (this.CcF != 0L) {
      i = j + b.p(3, this.CcF);
    }
    j = i;
    if (this.LGa != 0) {
      j = i + b.bA(4, this.LGa);
    }
    int k = j;
    if (this.LJo != 0) {
      k = j + b.bz(5, this.LJo);
    }
    i = k;
    if (!this.LIG.equals("")) {
      i = k + b.e(6, this.LIG);
    }
    j = i;
    Object localObject;
    if (this.LHp != null)
    {
      j = i;
      if (this.LHp.length > 0)
      {
        j = 0;
        while (j < this.LHp.length)
        {
          localObject = this.LHp[j];
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
    if (!this.LJp.equals("")) {
      i = j + b.e(8, this.LJp);
    }
    j = i;
    if (this.LJq != null)
    {
      j = i;
      if (this.LJq.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.LJq.length; m = n)
        {
          localObject = this.LJq[j];
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
    if (this.LJr != 0L) {
      i = j + b.o(10, this.LJr);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.be
 * JD-Core Version:    0.7.0.1
 */