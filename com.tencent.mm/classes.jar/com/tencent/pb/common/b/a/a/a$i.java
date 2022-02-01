package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$i
  extends e
{
  public a.ao[] IkQ = a.ao.flu();
  public String groupId = "";
  public int roomId = 0;
  public long sAY = 0L;
  public long timestamp = 0L;
  
  public a$i()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.by(1, this.roomId);
    paramb.o(2, this.sAY);
    if (!this.groupId.equals("")) {
      paramb.d(3, this.groupId);
    }
    if ((this.IkQ != null) && (this.IkQ.length > 0))
    {
      int i = 0;
      while (i < this.IkQ.length)
      {
        a.ao localao = this.IkQ[i];
        if (localao != null) {
          paramb.a(4, localao);
        }
        i += 1;
      }
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg() + b.bA(1, this.roomId) + b.q(2, this.sAY);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(3, this.groupId);
    }
    j = i;
    if (this.IkQ != null)
    {
      j = i;
      if (this.IkQ.length > 0)
      {
        j = 0;
        while (j < this.IkQ.length)
        {
          a.ao localao = this.IkQ[j];
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
      i = j + b.p(5, this.timestamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */