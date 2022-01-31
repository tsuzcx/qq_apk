package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;

public class lv
  extends lt
{
  private qc e;
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    if (this.d != null) {
      this.d.b(paramFloat);
    }
  }
  
  public qc f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lv
 * JD-Core Version:    0.7.0.1
 */