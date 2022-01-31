package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cz;

public class kf
  extends kd
{
  private cz e = null;
  
  public kf(cz paramcz)
  {
    this.e = paramcz;
  }
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(148948);
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    if (this.d != null) {
      this.d.b(paramFloat);
    }
    AppMethodBeat.o(148948);
  }
  
  public cz g()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kf
 * JD-Core Version:    0.7.0.1
 */