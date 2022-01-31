package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class kc
  extends kd
{
  private float e = 0.0F;
  private float f = 0.0F;
  
  public kc(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(148941);
    float f1 = this.f;
    float f2 = this.e;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.e;
    if (this.d != null) {
      this.d.a((f1 - f2) * paramFloat + f3);
    }
    AppMethodBeat.o(148941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kc
 * JD-Core Version:    0.7.0.1
 */