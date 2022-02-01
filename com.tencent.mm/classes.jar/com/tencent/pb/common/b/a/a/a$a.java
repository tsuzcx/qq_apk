package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;

public final class a$a
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public int[] ahdq = g.dTZ;
  public int ahdr = 0;
  public String[] ahds = g.EMPTY_STRING_ARRAY;
  public String groupId = "";
  
  public a$a()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (!this.groupId.equals("")) {
      paramb.g(1, this.groupId);
    }
    if (this.UAZ != 0) {
      paramb.cF(2, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(3, this.UBa);
    }
    int i;
    if ((this.ahdq != null) && (this.ahdq.length > 0))
    {
      i = 0;
      while (i < this.ahdq.length)
      {
        paramb.cG(4, this.ahdq[i]);
        i += 1;
      }
    }
    if (this.ahdr != 0) {
      paramb.cF(5, this.ahdr);
    }
    if ((this.ahds != null) && (this.ahds.length > 0))
    {
      i = j;
      while (i < this.ahds.length)
      {
        String str = this.ahds[i];
        if (str != null) {
          paramb.g(100, str);
        }
        i += 1;
      }
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.h(1, this.groupId);
    }
    j = i;
    if (this.UAZ != 0) {
      j = i + b.cJ(2, this.UAZ);
    }
    i = j;
    if (this.UBa != 0L) {
      i = j + b.q(3, this.UBa);
    }
    j = i;
    int k;
    if (this.ahdq != null)
    {
      j = i;
      if (this.ahdq.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.ahdq.length)
        {
          k += b.kv(this.ahdq[j]);
          j += 1;
        }
        j = i + k + this.ahdq.length * 1;
      }
    }
    i = j;
    if (this.ahdr != 0) {
      i = j + b.cJ(5, this.ahdr);
    }
    j = i;
    if (this.ahds != null)
    {
      j = i;
      if (this.ahds.length > 0)
      {
        j = 0;
        k = 0;
        int n;
        for (int m = 0; j < this.ahds.length; m = n)
        {
          String str = this.ahds[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + b.dU(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */