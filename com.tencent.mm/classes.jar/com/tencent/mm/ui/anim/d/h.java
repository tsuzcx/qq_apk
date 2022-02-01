package com.tencent.mm.ui.anim.d;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/inout/ScaleData;", "", "scaleX", "", "scaleY", "interpolator", "Landroid/view/animation/Interpolator;", "scaleType", "Lcom/tencent/mm/ui/anim/inout/ScaleType;", "(FFLandroid/view/animation/Interpolator;Lcom/tencent/mm/ui/anim/inout/ScaleType;)V", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "getScaleType", "()Lcom/tencent/mm/ui/anim/inout/ScaleType;", "setScaleType", "(Lcom/tencent/mm/ui/anim/inout/ScaleType;)V", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private Interpolator WSz;
  n adMN;
  float scaleX;
  float scaleY;
  
  private h(float paramFloat1, float paramFloat2, n paramn)
  {
    AppMethodBeat.i(251174);
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.WSz = null;
    this.adMN = paramn;
    AppMethodBeat.o(251174);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251191);
    if (this == paramObject)
    {
      AppMethodBeat.o(251191);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(251191);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(Float.valueOf(this.scaleX), Float.valueOf(paramObject.scaleX)))
    {
      AppMethodBeat.o(251191);
      return false;
    }
    if (!s.p(Float.valueOf(this.scaleY), Float.valueOf(paramObject.scaleY)))
    {
      AppMethodBeat.o(251191);
      return false;
    }
    if (!s.p(this.WSz, paramObject.WSz))
    {
      AppMethodBeat.o(251191);
      return false;
    }
    if (!s.p(this.adMN, paramObject.adMN))
    {
      AppMethodBeat.o(251191);
      return false;
    }
    AppMethodBeat.o(251191);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(251183);
    int j = Float.floatToIntBits(this.scaleX);
    int k = Float.floatToIntBits(this.scaleY);
    if (this.WSz == null) {}
    for (int i = 0;; i = this.WSz.hashCode())
    {
      int m = this.adMN.hashCode();
      AppMethodBeat.o(251183);
      return (i + (j * 31 + k) * 31) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251179);
    String str = "ScaleData(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", interpolator=" + this.WSz + ", scaleType=" + this.adMN + ')';
    AppMethodBeat.o(251179);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.anim.d.h
 * JD-Core Version:    0.7.0.1
 */