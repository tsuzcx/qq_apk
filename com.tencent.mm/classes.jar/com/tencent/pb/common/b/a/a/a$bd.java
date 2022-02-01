package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bd
  extends e
{
  public a.an InR = null;
  public int type = 0;
  
  public a$bd()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.by(1, this.type);
    }
    if (this.InR != null) {
      paramb.a(2, this.InR);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.type != 0) {
      i = j + b.bA(1, this.type);
    }
    j = i;
    if (this.InR != null) {
      j = i + b.b(2, this.InR);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bd
 * JD-Core Version:    0.7.0.1
 */