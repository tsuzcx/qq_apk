package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$u
  extends e
{
  public int ret = 0;
  public int sqW = 0;
  public int uC = 0;
  public String userName = "";
  public int wGk = 0;
  public int wHt = 0;
  public int wHu = 0;
  
  public a$u()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.userName.equals("")) {
      paramb.d(2, this.userName);
    }
    if (this.uC != 0) {
      paramb.aL(3, this.uC);
    }
    if (this.wHt != 0) {
      paramb.aM(4, this.wHt);
    }
    if (this.ret != 0) {
      paramb.aL(5, this.ret);
    }
    if (this.wHu != 0) {
      paramb.aL(6, this.wHu);
    }
    if (this.wGk != 0) {
      paramb.aM(7, this.wGk);
    }
    if (this.sqW != 0) {
      paramb.aM(8, this.sqW);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.userName.equals("")) {
      i = j + b.e(2, this.userName);
    }
    j = i;
    if (this.uC != 0) {
      j = i + b.aN(3, this.uC);
    }
    i = j;
    if (this.wHt != 0) {
      i = j + b.aO(4, this.wHt);
    }
    j = i;
    if (this.ret != 0) {
      j = i + b.aN(5, this.ret);
    }
    i = j;
    if (this.wHu != 0) {
      i = j + b.aN(6, this.wHu);
    }
    j = i;
    if (this.wGk != 0) {
      j = i + b.aO(7, this.wGk);
    }
    i = j;
    if (this.sqW != 0) {
      i = j + b.aO(8, this.sqW);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.u
 * JD-Core Version:    0.7.0.1
 */