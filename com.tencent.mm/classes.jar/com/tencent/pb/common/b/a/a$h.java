package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$h
  extends e
{
  public String drx = "";
  public String groupId = "";
  public int lpD = 0;
  public long lpE = 0L;
  public long timestamp = 0L;
  
  public a$h()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.aL(1, this.lpD);
    paramb.i(2, this.lpE);
    paramb.d(3, this.drx);
    if (!this.groupId.equals("")) {
      paramb.d(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.h(5, this.timestamp);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ() + b.aN(1, this.lpD) + b.k(2, this.lpE) + b.e(3, this.drx);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.j(5, this.timestamp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */