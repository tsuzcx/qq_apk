package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;

public final class a$a
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public int[] LFS = g.bQP;
  public int LFT = 0;
  public String[] LFU = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  
  public a$a()
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
    int i;
    if ((this.LFS != null) && (this.LFS.length > 0))
    {
      i = 0;
      while (i < this.LFS.length)
      {
        paramb.by(4, this.LFS[i]);
        i += 1;
      }
    }
    if (this.LFT != 0) {
      paramb.bx(5, this.LFT);
    }
    if ((this.LFU != null) && (this.LFU.length > 0))
    {
      i = j;
      while (i < this.LFU.length)
      {
        String str = this.LFU[i];
        if (str != null) {
          paramb.d(100, str);
        }
        i += 1;
      }
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
    int k;
    if (this.LFS != null)
    {
      j = i;
      if (this.LFS.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.LFS.length)
        {
          k += b.fP(this.LFS[j]);
          j += 1;
        }
        j = i + k + this.LFS.length * 1;
      }
    }
    i = j;
    if (this.LFT != 0) {
      i = j + b.bz(5, this.LFT);
    }
    j = i;
    if (this.LFU != null)
    {
      j = i;
      if (this.LFU.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.LFU.length; m = n)
        {
          String str = this.LFU[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.cc(str);
          }
          j += 1;
          k = i1;
        }
        j = i + k + m * 2;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */