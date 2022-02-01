package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$bf
  extends e
{
  public a.ao Zip = null;
  public int type = 0;
  
  public a$bf()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.type != 0) {
      i = j + b.bM(1, this.type);
    }
    j = i;
    if (this.Zip != null) {
      j = i + b.b(2, this.Zip);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.type != 0) {
      paramb.bJ(1, this.type);
    }
    if (this.Zip != null) {
      paramb.a(2, this.Zip);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.bf
 * JD-Core Version:    0.7.0.1
 */