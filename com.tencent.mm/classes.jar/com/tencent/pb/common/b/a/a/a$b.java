package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$b
  extends e
{
  public String IkB = "";
  public int bvJ = 0;
  
  public a$b()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.IkB.equals("")) {
      paramb.d(1, this.IkB);
    }
    if (this.bvJ != 0) {
      paramb.by(2, this.bvJ);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.IkB.equals("")) {
      i = j + b.e(1, this.IkB);
    }
    j = i;
    if (this.bvJ != 0) {
      j = i + b.bA(2, this.bvJ);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */