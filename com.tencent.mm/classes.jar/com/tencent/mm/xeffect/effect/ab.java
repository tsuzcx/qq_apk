package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "", "getTextInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setTextInfo", "", "textInfo", "Default", "renderlib_release"})
public abstract interface ab
{
  public abstract void a(h paramh);
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/TextInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "textInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "getTextInfo", "setTextInfo", "", "renderlib_release"})
  public static final class a
    implements ab
  {
    private final ad GAn;
    private h RyY;
    
    public a(ad paramad)
    {
      AppMethodBeat.i(237118);
      this.GAn = paramad;
      this.RyY = new h(null, null, 31);
      AppMethodBeat.o(237118);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(237117);
      p.h(paramh, "textInfo");
      this.RyY = paramh;
      VLogEffectJNI.INSTANCE.setEffectText$renderlib_release(this.GAn.ptr, paramh);
      AppMethodBeat.o(237117);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.ab
 * JD-Core Version:    0.7.0.1
 */