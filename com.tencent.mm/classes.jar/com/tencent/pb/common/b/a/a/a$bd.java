package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bd
  extends e
{
  public a.an LJn = null;
  public int type = 0;
  
  public a$bd()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.bx(1, this.type);
    }
    if (this.LJn != null) {
      paramb.a(2, this.LJn);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.type != 0) {
      i = j + b.bz(1, this.type);
    }
    j = i;
    if (this.LJn != null) {
      j = i + b.b(2, this.LJn);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bd
 * JD-Core Version:    0.7.0.1
 */