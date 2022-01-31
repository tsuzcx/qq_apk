package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$i
  extends e
{
  public int action = 0;
  public String groupId = "";
  public int lpD = 0;
  public long lpE = 0L;
  public long timestamp = 0L;
  
  public a$i()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.aM(1, this.action);
    paramb.aL(2, this.lpD);
    paramb.i(3, this.lpE);
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
    int j = super.oQ() + b.aO(1, this.action) + b.aN(2, this.lpD) + b.k(3, this.lpE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */