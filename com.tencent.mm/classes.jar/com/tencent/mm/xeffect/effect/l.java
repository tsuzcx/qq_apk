package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.s;

@kotlin.l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "value", "", "blurBottom", "getBlurBottom", "()Z", "setBlurBottom", "(Z)V", "", "blurMaskRatio", "getBlurMaskRatio", "()F", "setBlurMaskRatio", "(F)V", "blurTop", "getBlurTop", "setBlurTop", "centerCropBlur", "getCenterCropBlur", "setCenterCropBlur", "contentOffset", "getContentOffset", "setContentOffset", "contentOffsetPercent", "getContentOffsetPercent", "setContentOffsetPercent", "setRadius", "", "radius", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class l
  extends af
{
  private boolean YZV = true;
  private float YZW = 3.0F;
  private boolean YZX = true;
  private boolean YZY = true;
  public float YZZ = 0.5F;
  
  public l(long paramLong)
  {
    super(paramLong);
  }
  
  public final void dh(float paramFloat)
  {
    AppMethodBeat.i(195789);
    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectContentOffset(this.ptr, paramFloat);
    AppMethodBeat.o(195789);
  }
  
  public final j ika()
  {
    return j.YZN;
  }
  
  public final void ikg()
  {
    AppMethodBeat.i(195788);
    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectCenterCropBlur(this.ptr, false);
    AppMethodBeat.o(195788);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(195787);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.d(s.M(Integer.valueOf(o.Zaw.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(195787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.l
 * JD-Core Version:    0.7.0.1
 */