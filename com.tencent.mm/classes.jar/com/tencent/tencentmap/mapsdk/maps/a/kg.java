package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class kg
  extends kd
{
  private float e = 0.0F;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  
  public kg(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.i = paramFloat5;
  }
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(148949);
    float f1 = this.f;
    float f2 = this.e;
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    float f3 = this.e;
    if (this.d != null) {
      this.d.a((f1 - f2) * paramFloat + f3, this.g, this.h, this.i);
    }
    AppMethodBeat.o(148949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kg
 * JD-Core Version:    0.7.0.1
 */