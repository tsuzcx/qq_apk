package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$i
  extends e
{
  public a.ao[] LGk = a.ao.fTa();
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  public long uLt = 0L;
  
  public a$i()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.bx(1, this.roomId);
    paramb.n(2, this.uLt);
    if (!this.groupId.equals("")) {
      paramb.d(3, this.groupId);
    }
    if ((this.LGk != null) && (this.LGk.length > 0))
    {
      int i = 0;
      while (i < this.LGk.length)
      {
        a.ao localao = this.LGk[i];
        if (localao != null) {
          paramb.a(4, localao);
        }
        i += 1;
      }
    }
    if (this.timestamp != 0L) {
      paramb.m(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq() + b.bz(1, this.roomId) + b.p(2, this.uLt);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(3, this.groupId);
    }
    j = i;
    if (this.LGk != null)
    {
      j = i;
      if (this.LGk.length > 0)
      {
        j = 0;
        while (j < this.LGk.length)
        {
          a.ao localao = this.LGk[j];
          int k = i;
          if (localao != null) {
            k = i + b.b(4, localao);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.timestamp != 0L) {
      i = j + b.o(5, this.timestamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */