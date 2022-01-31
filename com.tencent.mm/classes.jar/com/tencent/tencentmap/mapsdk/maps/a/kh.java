package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class kh
  extends kd
{
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  
  public kh(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
  }
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(148950);
    if (paramFloat < 0.0F)
    {
      AppMethodBeat.o(148950);
      return;
    }
    float f1 = this.f;
    float f2 = this.e;
    float f3 = this.h;
    float f4 = this.g;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f5 = this.e;
    float f6 = this.g;
    if (this.d != null) {
      this.d.a((f1 - f2) * paramFloat + f5, (f3 - f4) * paramFloat + f6);
    }
    AppMethodBeat.o(148950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kh
 * JD-Core Version:    0.7.0.1
 */