package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.l;
import kotlin.s;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/BlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setRadius", "", "radius", "", "setSampleFactor", "sampleFactor", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class b
  extends af
{
  public b(long paramLong)
  {
    super(paramLong);
  }
  
  public final j ika()
  {
    return j.YZP;
  }
  
  public final void ikb()
  {
    AppMethodBeat.i(195682);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.d(s.M(Integer.valueOf(o.Zax.ordinal()), Float.valueOf(1.0F))));
    AppMethodBeat.o(195682);
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(195679);
    VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.d(s.M(Integer.valueOf(o.Zaw.ordinal()), Float.valueOf(paramFloat))));
    AppMethodBeat.o(195679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.b
 * JD-Core Version:    0.7.0.1
 */