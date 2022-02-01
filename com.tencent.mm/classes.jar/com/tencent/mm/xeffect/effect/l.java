package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.v;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "value", "", "blurBottom", "getBlurBottom", "()Z", "setBlurBottom", "(Z)V", "", "blurMaskRatio", "getBlurMaskRatio", "()F", "setBlurMaskRatio", "(F)V", "blurTop", "getBlurTop", "setBlurTop", "centerCropBlur", "getCenterCropBlur", "setCenterCropBlur", "contentOffset", "getContentOffset", "setContentOffset", "contentOffsetPercent", "getContentOffsetPercent", "setContentOffsetPercent", "setRadius", "", "radius", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class l
  extends af
{
  private boolean agYh = true;
  private float agYi = 3.0F;
  private boolean agYj = true;
  private boolean agYk = true;
  public float agYl = 0.5F;
  
  public l(long paramLong)
  {
    super(paramLong);
  }
  
  public final void eD(float paramFloat)
  {
    AppMethodBeat.i(234572);
    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectContentOffset(this.ptr, paramFloat);
    AppMethodBeat.o(234572);
  }
  
  public final j jQi()
  {
    return j.agXZ;
  }
  
  public final void jQn()
  {
    AppMethodBeat.i(234568);
    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectCenterCropBlur(this.ptr, false);
    AppMethodBeat.o(234568);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(234561);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ak.l(v.Y(Integer.valueOf(o.agYI.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(234561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.l
 * JD-Core Version:    0.7.0.1
 */