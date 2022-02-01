package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$av
  extends e
{
  public int sceneType = 0;
  
  public a$av()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.sceneType != 0) {
      paramb.cF(1, this.sceneType);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (this.sceneType != 0) {
      i = j + b.cJ(1, this.sceneType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.av
 * JD-Core Version:    0.7.0.1
 */