package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$a
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public int[] RDl = g.bYn;
  public int RDm = 0;
  public String[] RDn = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  
  public a$a()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
    }
    j = i;
    int k;
    if (this.RDl != null)
    {
      j = i;
      if (this.RDl.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.RDl.length)
        {
          k += b.fY(this.RDl[j]);
          j += 1;
        }
        j = i + k + this.RDl.length * 1;
      }
    }
    i = j;
    if (this.RDm != 0) {
      i = j + b.bu(5, this.RDm);
    }
    j = i;
    if (this.RDn != null)
    {
      j = i;
      if (this.RDn.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.RDn.length; m = n)
        {
          String str = this.RDn[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.cb(str);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 2;
      }
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    int i;
    if ((this.RDl != null) && (this.RDl.length > 0))
    {
      i = 0;
      while (i < this.RDl.length)
      {
        paramb.bB(4, this.RDl[i]);
        i += 1;
      }
    }
    if (this.RDm != 0) {
      paramb.bs(5, this.RDm);
    }
    if ((this.RDn != null) && (this.RDn.length > 0))
    {
      i = j;
      while (i < this.RDn.length)
      {
        String str = this.RDn[i];
        if (str != null) {
          paramb.e(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */