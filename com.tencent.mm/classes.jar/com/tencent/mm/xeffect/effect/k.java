package com.tencent.mm.xeffect.effect;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/FadeEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setAlphaRange", "", "startAlpha", "", "endAlpha", "setFadeBackgroundColor", "color", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class k
  extends ad
{
  public k(long paramLong)
  {
    super(paramLong);
  }
  
  public final void aE(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237078);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.e(new kotlin.o[] { s.U(Integer.valueOf(o.RyM.ordinal()), Float.valueOf(paramFloat1)), s.U(Integer.valueOf(o.RyN.ordinal()), Float.valueOf(paramFloat2)) }));
    AppMethodBeat.o(237078);
  }
  
  public final void aqr(int paramInt)
  {
    AppMethodBeat.i(237079);
    float f1 = Color.red(paramInt) / 255.0F;
    float f2 = Color.green(paramInt) / 255.0F;
    float f3 = Color.blue(paramInt) / 255.0F;
    VLogEffectJNI.INSTANCE.nSetFadeEffectFadeBackgroundColor(this.ptr, f1, f2, f3);
    AppMethodBeat.o(237079);
  }
  
  public final j hiu()
  {
    return j.Ryi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.k
 * JD-Core Version:    0.7.0.1
 */