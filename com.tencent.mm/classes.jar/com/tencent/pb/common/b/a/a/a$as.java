package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$as
  extends e
{
  public int ahfu = 0;
  public int oUj = 0;
  public long status = 0L;
  
  public a$as()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.status != 0L) {
      paramb.n(1, this.status);
    }
    if (this.oUj != 0) {
      paramb.cG(2, this.oUj);
    }
    if (this.ahfu != 0) {
      paramb.cG(3, this.ahfu);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.status != 0L) {
      i = j + b.r(1, this.status);
    }
    j = i;
    if (this.oUj != 0) {
      j = i + b.cK(2, this.oUj);
    }
    i = j;
    if (this.ahfu != 0) {
      i = j + b.cK(3, this.ahfu);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.as
 * JD-Core Version:    0.7.0.1
 */