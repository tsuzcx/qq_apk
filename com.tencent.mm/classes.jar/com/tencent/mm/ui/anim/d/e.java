package com.tencent.mm.ui.anim.d;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/inout/FadeData;", "", "alpha", "", "interpolator", "Landroid/view/animation/Interpolator;", "(FLandroid/view/animation/Interpolator;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private Interpolator WSz;
  float alpha;
  
  private e(float paramFloat)
  {
    this.alpha = paramFloat;
    this.WSz = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251187);
    if (this == paramObject)
    {
      AppMethodBeat.o(251187);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(251187);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(251187);
      return false;
    }
    if (!s.p(this.WSz, paramObject.WSz))
    {
      AppMethodBeat.o(251187);
      return false;
    }
    AppMethodBeat.o(251187);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(251182);
    int j = Float.floatToIntBits(this.alpha);
    if (this.WSz == null) {}
    for (int i = 0;; i = this.WSz.hashCode())
    {
      AppMethodBeat.o(251182);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251178);
    String str = "FadeData(alpha=" + this.alpha + ", interpolator=" + this.WSz + ')';
    AppMethodBeat.o(251178);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.anim.d.e
 * JD-Core Version:    0.7.0.1
 */