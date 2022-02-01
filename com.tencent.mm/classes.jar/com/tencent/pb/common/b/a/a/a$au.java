package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$au
  extends e
{
  public int ahfx = 0;
  public int ahfy = 0;
  
  public a$au()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.ahfx != 0) {
      paramb.cF(1, this.ahfx);
    }
    if (this.ahfy != 0) {
      paramb.cF(2, this.ahfy);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.ahfx != 0) {
      i = j + b.cJ(1, this.ahfx);
    }
    j = i;
    if (this.ahfy != 0) {
      j = i + b.cJ(2, this.ahfy);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.au
 * JD-Core Version:    0.7.0.1
 */