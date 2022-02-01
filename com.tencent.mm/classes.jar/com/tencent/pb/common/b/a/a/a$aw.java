package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$aw
  extends e
{
  public int sceneType = 0;
  
  public a$aw()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.sceneType != 0) {
      i = j + b.bu(1, this.sceneType);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (this.sceneType != 0) {
      paramb.bs(1, this.sceneType);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.aw
 * JD-Core Version:    0.7.0.1
 */