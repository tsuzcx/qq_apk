package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$j
  extends e
{
  public long Hnt = 0L;
  public a.aq[] ahdJ = a.aq.jRh();
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$j()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.cF(1, this.roomId);
    paramb.t(2, this.Hnt);
    if (!this.groupId.equals("")) {
      paramb.g(3, this.groupId);
    }
    if ((this.ahdJ != null) && (this.ahdJ.length > 0))
    {
      int i = 0;
      while (i < this.ahdJ.length)
      {
        a.aq localaq = this.ahdJ[i];
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
  
  public final int akc()
  {
    int j = super.akc() + b.cJ(1, this.roomId) + b.q(2, this.Hnt);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.h(3, this.groupId);
    }
    j = i;
    if (this.ahdJ != null)
    {
      j = i;
      if (this.ahdJ.length > 0)
      {
        j = 0;
        while (j < this.ahdJ.length)
        {
          a.aq localaq = this.ahdJ[j];
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
      i = j + b.r(5, this.timestamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */