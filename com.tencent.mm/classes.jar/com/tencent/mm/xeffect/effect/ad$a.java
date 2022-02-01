package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/TextInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "textInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "getTextInfo", "setTextInfo", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class ad$a
  implements ad
{
  private final af Uby;
  private h agYS;
  
  public ad$a(af paramaf)
  {
    AppMethodBeat.i(234575);
    this.Uby = paramaf;
    this.agYS = new h(null, null, 31);
    AppMethodBeat.o(234575);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(234578);
    s.t(paramh, "textInfo");
    this.agYS = paramh;
    VLogEffectJNI.INSTANCE.setEffectText$renderlib_release(this.Uby.ptr, paramh);
    AppMethodBeat.o(234578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.ad.a
 * JD-Core Version:    0.7.0.1
 */