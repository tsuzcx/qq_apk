package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$i
  extends e
{
  public a.aq[] RDD = a.aq.hjf();
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  public long ypH = 0L;
  
  public a$i()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig() + b.bu(1, this.roomId) + b.r(2, this.ypH);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(3, this.groupId);
    }
    j = i;
    if (this.RDD != null)
    {
      j = i;
      if (this.RDD.length > 0)
      {
        j = 0;
        while (j < this.RDD.length)
        {
          a.aq localaq = this.RDD[j];
          int k = i;
          if (localaq != null) {
            k = i + b.b(4, localaq);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.timestamp != 0L) {
      i = j + b.p(5, this.timestamp);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    paramb.bs(1, this.roomId);
    paramb.q(2, this.ypH);
    if (!this.groupId.equals("")) {
      paramb.e(3, this.groupId);
    }
    if ((this.RDD != null) && (this.RDD.length > 0))
    {
      int i = 0;
      while (i < this.RDD.length)
      {
        a.aq localaq = this.RDD[i];
        if (localaq != null) {
          paramb.a(4, localaq);
        }
        i += 1;
      }
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */