package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$j
  extends e
{
  public a.ar[] RDE = a.ar.hjg();
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  public long ypH = 0L;
  
  public a$j()
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
    if (this.RDE != null)
    {
      j = i;
      if (this.RDE.length > 0)
      {
        j = 0;
        while (j < this.RDE.length)
        {
          a.ar localar = this.RDE[j];
          int k = i;
          if (localar != null) {
            k = i + b.b(4, localar);
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
    if ((this.RDE != null) && (this.RDE.length > 0))
    {
      int i = 0;
      while (i < this.RDE.length)
      {
        a.ar localar = this.RDE[i];
        if (localar != null) {
          paramb.a(4, localar);
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */