package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;

public class ls
  extends lt
{
  private float e;
  private float f;
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    float f1 = this.f;
    float f2 = this.e;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.e;
    if (this.d != null) {
      this.d.a((f1 - f2) * paramFloat + f3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ls
 * JD-Core Version:    0.7.0.1
 */