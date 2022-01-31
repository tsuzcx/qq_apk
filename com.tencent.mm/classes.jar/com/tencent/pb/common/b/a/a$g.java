package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$g
  extends e
{
  public int aQw = 0;
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public String wGf = "";
  
  public a$g()
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
    if (this.aQw != 0) {
      paramb.aL(4, this.aQw);
    }
    if (!this.wGf.equals("")) {
      paramb.d(5, this.wGf);
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
    if (this.aQw != 0) {
      j = i + b.aN(4, this.aQw);
    }
    i = j;
    if (!this.wGf.equals("")) {
      i = j + b.e(5, this.wGf);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */