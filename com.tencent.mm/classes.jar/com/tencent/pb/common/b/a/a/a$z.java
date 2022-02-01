package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$z
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public a.az RDq = null;
  public a.bb[] REK = a.bb.hjl();
  public String groupId = "";
  
  public a$z()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
    }
    j = i;
    if (this.REK != null)
    {
      j = i;
      if (this.REK.length > 0)
      {
        j = 0;
        while (j < this.REK.length)
        {
          a.bb localbb = this.REK[j];
          int k = i;
          if (localbb != null) {
            k = i + b.b(4, localbb);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.RDq != null) {
      i = j + b.b(5, this.RDq);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    if ((this.REK != null) && (this.REK.length > 0))
    {
      int i = 0;
      while (i < this.REK.length)
      {
        a.bb localbb = this.REK[i];
        if (localbb != null) {
          paramb.a(4, localbb);
        }
        i += 1;
      }
    }
    if (this.RDq != null) {
      paramb.a(5, this.RDq);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.z
 * JD-Core Version:    0.7.0.1
 */