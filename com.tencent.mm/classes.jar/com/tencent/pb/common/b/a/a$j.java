package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$j
  extends e
{
  public String groupId = "";
  public int pRI = 0;
  public long pRJ = 0L;
  public a.ba wGj = null;
  public int wGl = 0;
  public byte[] wGv = g.aUP;
  
  public a$j()
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
    if (this.wGj != null) {
      paramb.a(4, this.wGj);
    }
    if (this.wGl != 0) {
      paramb.aM(5, this.wGl);
    }
    if (!Arrays.equals(this.wGv, g.aUP)) {
      paramb.b(200, this.wGv);
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
    if (this.wGj != null) {
      j = i + b.b(4, this.wGj);
    }
    i = j;
    if (this.wGl != 0) {
      i = j + b.aO(5, this.wGl);
    }
    j = i;
    if (!Arrays.equals(this.wGv, g.aUP)) {
      j = i + b.c(200, this.wGv);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */