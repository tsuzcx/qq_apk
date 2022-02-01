package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bd
  extends e
{
  public a.an JPB = null;
  public int type = 0;
  
  public a$bd()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.bv(1, this.type);
    }
    if (this.JPB != null) {
      paramb.a(2, this.JPB);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.type != 0) {
      i = j + b.bx(1, this.type);
    }
    j = i;
    if (this.JPB != null) {
      j = i + b.b(2, this.JPB);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bd
 * JD-Core Version:    0.7.0.1
 */