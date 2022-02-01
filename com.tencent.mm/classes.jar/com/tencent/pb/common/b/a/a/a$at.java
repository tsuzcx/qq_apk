package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$at
  extends e
{
  public int sceneType = 0;
  
  public a$at()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.sceneType != 0) {
      paramb.bv(1, this.sceneType);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.sceneType != 0) {
      i = j + b.bx(1, this.sceneType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.at
 * JD-Core Version:    0.7.0.1
 */