package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ac
  extends e
{
  public a.at BdI = null;
  public int Bfn = 0;
  public String groupId = "";
  
  public a$ac()
  {
    this.bgY = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.BdI != null) {
      paramb.a(2, this.BdI);
    }
    if (this.Bfn != 0) {
      paramb.bj(3, this.Bfn);
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
    if (this.BdI != null) {
      j = i + b.b(2, this.BdI);
    }
    i = j;
    if (this.Bfn != 0) {
      i = j + b.bl(3, this.Bfn);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ac
 * JD-Core Version:    0.7.0.1
 */