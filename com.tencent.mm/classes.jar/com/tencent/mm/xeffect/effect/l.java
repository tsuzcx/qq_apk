package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.s;

@kotlin.l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "value", "", "blurBottom", "getBlurBottom", "()Z", "setBlurBottom", "(Z)V", "", "blurMaskRatio", "getBlurMaskRatio", "()F", "setBlurMaskRatio", "(F)V", "blurTop", "getBlurTop", "setBlurTop", "centerCropBlur", "getCenterCropBlur", "setCenterCropBlur", "contentOffset", "getContentOffset", "setContentOffset", "setRadius", "", "radius", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class l
  extends ad
{
  private boolean Ryo = true;
  private float Ryp = 3.0F;
  private boolean Ryq = true;
  private boolean Ryr = true;
  
  public l(long paramLong)
  {
    super(paramLong);
  }
  
  public final void cM(float paramFloat)
  {
    AppMethodBeat.i(237082);
    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectContentOffset(this.ptr, paramFloat);
    AppMethodBeat.o(237082);
  }
  
  public final j hiu()
  {
    return j.Ryh;
  }
  
  public final void hix()
  {
    AppMethodBeat.i(237081);
    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectCenterCropBlur(this.ptr, false);
    AppMethodBeat.o(237081);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(237080);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.b(s.U(Integer.valueOf(o.RyO.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(237080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.l
 * JD-Core Version:    0.7.0.1
 */