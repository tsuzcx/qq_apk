package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;

public final class a$bb
  extends e
{
  public int BdL = 0;
  public a.av[] BeZ = a.av.dTR();
  public int BgX = 0;
  public String BgY = "";
  public String[] BgZ = g.EMPTY_STRING_ARRAY;
  public String Bgo = "";
  public long Bha = 0L;
  public String groupId = "";
  public int twP = 0;
  public long twQ = 0L;
  
  public a$bb()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    if (this.BdL != 0) {
      paramb.bk(4, this.BdL);
    }
    if (this.BgX != 0) {
      paramb.bj(5, this.BgX);
    }
    if (!this.Bgo.equals("")) {
      paramb.e(6, this.Bgo);
    }
    int i;
    Object localObject;
    if ((this.BeZ != null) && (this.BeZ.length > 0))
    {
      i = 0;
      while (i < this.BeZ.length)
      {
        localObject = this.BeZ[i];
        if (localObject != null) {
          paramb.a(7, (e)localObject);
        }
        i += 1;
      }
    }
    if (!this.BgY.equals("")) {
      paramb.e(8, this.BgY);
    }
    if ((this.BgZ != null) && (this.BgZ.length > 0))
    {
      i = j;
      while (i < this.BgZ.length)
      {
        localObject = this.BgZ[i];
        if (localObject != null) {
          paramb.e(9, (String)localObject);
        }
        i += 1;
      }
    }
    if (this.Bha != 0L) {
      paramb.m(10, this.Bha);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    j = i;
    if (this.BdL != 0) {
      j = i + b.bm(4, this.BdL);
    }
    int k = j;
    if (this.BgX != 0) {
      k = j + b.bl(5, this.BgX);
    }
    i = k;
    if (!this.Bgo.equals("")) {
      i = k + b.f(6, this.Bgo);
    }
    j = i;
    Object localObject;
    if (this.BeZ != null)
    {
      j = i;
      if (this.BeZ.length > 0)
      {
        j = 0;
        while (j < this.BeZ.length)
        {
          localObject = this.BeZ[j];
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
    if (!this.BgY.equals("")) {
      i = j + b.f(8, this.BgY);
    }
    j = i;
    if (this.BgZ != null)
    {
      j = i;
      if (this.BgZ.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.BgZ.length; m = n)
        {
          localObject = this.BgZ[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + b.bf((String)localObject);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (this.Bha != 0L) {
      i = j + b.o(10, this.Bha);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.bb
 * JD-Core Version:    0.7.0.1
 */