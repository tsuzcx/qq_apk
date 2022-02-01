package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$i
  extends e
{
  public long DPJ = 0L;
  public a.ap[] Zff = a.ap.ikP();
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$i()
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
    if (this.Zff != null)
    {
      j = i;
      if (this.Zff.length > 0)
      {
        j = 0;
        while (j < this.Zff.length)
        {
          a.ap localap = this.Zff[j];
          int k = i;
          if (localap != null) {
            k = i + b.b(4, localap);
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
    if ((this.Zff != null) && (this.Zff.length > 0))
    {
      int i = 0;
      while (i < this.Zff.length)
      {
        a.ap localap = this.Zff[i];
        if (localap != null) {
          paramb.a(4, localap);
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