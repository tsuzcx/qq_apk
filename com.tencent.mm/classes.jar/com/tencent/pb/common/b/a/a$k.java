package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$k
  extends e
{
  public String groupId = "";
  public int iEo = -1;
  public int netType = 0;
  public int pRI = 0;
  public long pRJ = 0L;
  public int wGl = 0;
  
  public a$k()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.pRI != 0) {
      paramb.aL(2, this.pRI);
    }
    if (this.pRJ != 0L) {
      paramb.i(3, this.pRJ);
    }
    if (this.iEo != -1) {
      paramb.aL(4, this.iEo);
    }
    if (this.wGl != 0) {
      paramb.aM(5, this.wGl);
    }
    if (this.netType != 0) {
      paramb.aM(6, this.netType);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.pRI != 0) {
      j = i + b.aN(2, this.pRI);
    }
    i = j;
    if (this.pRJ != 0L) {
      i = j + b.k(3, this.pRJ);
    }
    j = i;
    if (this.iEo != -1) {
      j = i + b.aN(4, this.iEo);
    }
    i = j;
    if (this.wGl != 0) {
      i = j + b.aO(5, this.wGl);
    }
    j = i;
    if (this.netType != 0) {
      j = i + b.aO(6, this.netType);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.k
 * JD-Core Version:    0.7.0.1
 */