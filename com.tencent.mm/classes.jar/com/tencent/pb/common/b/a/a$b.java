package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$b
  extends e
{
  public int aQw = 0;
  public String wGf = "";
  
  public a$b()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.wGf.equals("")) {
      paramb.d(1, this.wGf);
    }
    if (this.aQw != 0) {
      paramb.aL(2, this.aQw);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (!this.wGf.equals("")) {
      i = j + b.e(1, this.wGf);
    }
    j = i;
    if (this.aQw != 0) {
      j = i + b.aN(2, this.aQw);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */