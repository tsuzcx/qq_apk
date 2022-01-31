package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$aq
  extends e
{
  public int sceneType = 0;
  
  public a$aq()
  {
    this.aUI = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.sceneType != 0) {
      paramb.aL(1, this.sceneType);
    }
    super.a(paramb);
  }
  
  protected final int oQ()
  {
    int j = super.oQ();
    int i = j;
    if (this.sceneType != 0) {
      i = j + b.aN(1, this.sceneType);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.aq
 * JD-Core Version:    0.7.0.1
 */