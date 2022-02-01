package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$j
  extends e
{
  public long DPJ = 0L;
  public a.aq[] Zfg = a.aq.ikQ();
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$j()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG() + b.bM(1, this.roomId) + b.p(2, this.DPJ);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(3, this.groupId);
    }
    j = i;
    if (this.Zfg != null)
    {
      j = i;
      if (this.Zfg.length > 0)
      {
        j = 0;
        while (j < this.Zfg.length)
        {
          a.aq localaq = this.Zfg[j];
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
      i = j + b.q(5, this.timestamp);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    paramb.bJ(1, this.roomId);
    paramb.r(2, this.DPJ);
    if (!this.groupId.equals("")) {
      paramb.f(3, this.groupId);
    }
    if ((this.Zfg != null) && (this.Zfg.length > 0))
    {
      int i = 0;
      while (i < this.Zfg.length)
      {
        a.aq localaq = this.Zfg[i];
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
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */