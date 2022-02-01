package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$as
  extends e
{
  public int ImA = 0;
  public int Imz = 0;
  
  public a$as()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.Imz != 0) {
      paramb.by(1, this.Imz);
    }
    if (this.ImA != 0) {
      paramb.by(2, this.ImA);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.Imz != 0) {
      i = j + b.bA(1, this.Imz);
    }
    j = i;
    if (this.ImA != 0) {
      j = i + b.bA(2, this.ImA);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.as
 * JD-Core Version:    0.7.0.1
 */