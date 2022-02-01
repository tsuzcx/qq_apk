package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$y
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public a.aw Mdb = null;
  public a.ay[] Met = a.ay.fXF();
  public String groupId = "";
  
  public a$y()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(2, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(3, this.Cug);
    }
    if ((this.Met != null) && (this.Met.length > 0))
    {
      int i = 0;
      while (i < this.Met.length)
      {
        a.ay localay = this.Met[i];
        if (localay != null) {
          paramb.a(4, localay);
        }
        i += 1;
      }
    }
    if (this.Mdb != null) {
      paramb.a(5, this.Mdb);
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
    if (this.Cuf != 0) {
      j = i + b.bz(2, this.Cuf);
    }
    i = j;
    if (this.Cug != 0L) {
      i = j + b.p(3, this.Cug);
    }
    j = i;
    if (this.Met != null)
    {
      j = i;
      if (this.Met.length > 0)
      {
        j = 0;
        while (j < this.Met.length)
        {
          a.ay localay = this.Met[j];
          int k = i;
          if (localay != null) {
            k = i + b.b(4, localay);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.Mdb != null) {
      i = j + b.b(5, this.Mdb);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.y
 * JD-Core Version:    0.7.0.1
 */