package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.v;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/BlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setRadius", "", "radius", "", "setSampleFactor", "sampleFactor", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class b
  extends af
{
  public b(long paramLong)
  {
    super(paramLong);
  }
  
  public final void eC(float paramFloat)
  {
    AppMethodBeat.i(234570);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ak.l(v.Y(Integer.valueOf(o.agYJ.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(234570);
  }
  
  public final j jQi()
  {
    return j.agYb;
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(234564);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ak.l(v.Y(Integer.valueOf(o.agYI.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(234564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.b
 * JD-Core Version:    0.7.0.1
 */