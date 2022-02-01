package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$at
  extends e
{
  public int sceneType = 0;
  
  public a$at()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.sceneType != 0) {
      paramb.bx(1, this.sceneType);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.sceneType != 0) {
      i = j + b.bz(1, this.sceneType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.at
 * JD-Core Version:    0.7.0.1
 */