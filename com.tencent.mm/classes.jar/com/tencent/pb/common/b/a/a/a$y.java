package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$y
  extends e
{
  public int CcE = 0;
  public long CcF = 0L;
  public a.aw LFX = null;
  public a.ay[] LHp = a.ay.fTf();
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
    if (this.CcE != 0) {
      paramb.bx(2, this.CcE);
    }
    if (this.CcF != 0L) {
      paramb.n(3, this.CcF);
    }
    if ((this.LHp != null) && (this.LHp.length > 0))
    {
      int i = 0;
      while (i < this.LHp.length)
      {
        a.ay localay = this.LHp[i];
        if (localay != null) {
          paramb.a(4, localay);
        }
        i += 1;
      }
    }
    if (this.LFX != null) {
      paramb.a(5, this.LFX);
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
    if (this.LHp != null)
    {
      j = i;
      if (this.LHp.length > 0)
      {
        j = 0;
        while (j < this.LHp.length)
        {
          a.ay localay = this.LHp[j];
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
    if (this.LFX != null) {
      i = j + b.b(5, this.LFX);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.y
 * JD-Core Version:    0.7.0.1
 */