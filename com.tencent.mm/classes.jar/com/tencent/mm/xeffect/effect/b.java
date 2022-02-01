package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.l;
import kotlin.s;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/BlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setRadius", "", "radius", "", "setSampleFactor", "sampleFactor", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class b
  extends ad
{
  public b(long paramLong)
  {
    super(paramLong);
  }
  
  public final j hiu()
  {
    return j.Ryj;
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(237050);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.b(s.U(Integer.valueOf(o.RyO.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(237050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.b
 * JD-Core Version:    0.7.0.1
 */