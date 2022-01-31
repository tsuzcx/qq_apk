package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ac
  extends e
{
  public String groupId = "";
  public a.at wGh = null;
  public int wHN = 0;
  
  public a$ac()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.wGh != null) {
      paramb.a(2, this.wGh);
    }
    if (this.wHN != 0) {
      paramb.aL(3, this.wHN);
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
    if (this.wGh != null) {
      j = i + b.b(2, this.wGh);
    }
    i = j;
    if (this.wHN != 0) {
      i = j + b.aN(3, this.wHN);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.ac
 * JD-Core Version:    0.7.0.1
 */