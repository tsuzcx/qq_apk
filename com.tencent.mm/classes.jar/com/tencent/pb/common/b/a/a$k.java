package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$k
  extends e
{
  public int BdM = 0;
  public String groupId = "";
  public int kJx = -1;
  public int netType = 0;
  public int twP = 0;
  public long twQ = 0L;
  
  public a$k()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.twP != 0) {
      paramb.bj(2, this.twP);
    }
    if (this.twQ != 0L) {
      paramb.n(3, this.twQ);
    }
    if (this.kJx != -1) {
      paramb.bj(4, this.kJx);
    }
    if (this.BdM != 0) {
      paramb.bk(5, this.BdM);
    }
    if (this.netType != 0) {
      paramb.bk(6, this.netType);
    }
    super.a(paramb);
  }
  
  public final int sz()
  {
    int j = super.sz();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.twP != 0) {
      j = i + b.bl(2, this.twP);
    }
    i = j;
    if (this.twQ != 0L) {
      i = j + b.p(3, this.twQ);
    }
    j = i;
    if (this.kJx != -1) {
      j = i + b.bl(4, this.kJx);
    }
    i = j;
    if (this.BdM != 0) {
      i = j + b.bm(5, this.BdM);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.bm(6, this.netType);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */