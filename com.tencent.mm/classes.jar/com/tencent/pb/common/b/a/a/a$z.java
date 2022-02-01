package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$z
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public a.ay ahdv = null;
  public a.ba[] aheQ = a.ba.jRm();
  public String groupId = "";
  
  public a$z()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.g(1, this.groupId);
    }
    if (this.UAZ != 0) {
      paramb.cF(2, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(3, this.UBa);
    }
    if ((this.aheQ != null) && (this.aheQ.length > 0))
    {
      int i = 0;
      while (i < this.aheQ.length)
      {
        a.ba localba = this.aheQ[i];
        if (localba != null) {
          paramb.a(4, localba);
        }
        i += 1;
      }
    }
    if (this.ahdv != null) {
      paramb.a(5, this.ahdv);
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
    if (this.aheQ != null)
    {
      j = i;
      if (this.aheQ.length > 0)
      {
        j = 0;
        while (j < this.aheQ.length)
        {
          a.ba localba = this.aheQ[j];
          int k = i;
          if (localba != null) {
            k = i + b.b(4, localba);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.ahdv != null) {
      i = j + b.b(5, this.ahdv);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.z
 * JD-Core Version:    0.7.0.1
 */