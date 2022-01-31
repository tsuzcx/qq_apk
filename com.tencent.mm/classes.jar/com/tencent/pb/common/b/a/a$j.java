package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$j
  extends e
{
  public a.ba BdK = null;
  public int BdM = 0;
  public byte[] BdW = g.bhf;
  public String groupId = "";
  public int twP = 0;
  public long twQ = 0L;
  
  public a$j()
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
    if (this.BdK != null) {
      paramb.a(4, this.BdK);
    }
    if (this.BdM != 0) {
      paramb.bk(5, this.BdM);
    }
    if (!Arrays.equals(this.BdW, g.bhf)) {
      paramb.b(200, this.BdW);
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
    if (this.BdK != null) {
      j = i + b.b(4, this.BdK);
    }
    i = j;
    if (this.BdM != 0) {
      i = j + b.bm(5, this.BdM);
    }
    j = i;
    if (!Arrays.equals(this.BdW, g.bhf)) {
      j = i + b.c(200, this.BdW);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.j
 * JD-Core Version:    0.7.0.1
 */