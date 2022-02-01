package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "", "getTextInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setTextInfo", "", "textInfo", "Default", "renderlib_release"})
public abstract interface ad
{
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/TextInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "textInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "getTextInfo", "setTextInfo", "", "renderlib_release"})
  public static final class a
    implements ad
  {
    private final af NnT;
    private h ZaG;
    
    public a(af paramaf)
    {
      AppMethodBeat.i(195897);
      this.NnT = paramaf;
      this.ZaG = new h(null, null, 31);
      AppMethodBeat.o(195897);
    }
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(195895);
      p.k(paramh, "textInfo");
      this.ZaG = paramh;
      VLogEffectJNI.INSTANCE.setEffectText$renderlib_release(this.NnT.ptr, paramh);
      AppMethodBeat.o(195895);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.ad
 * JD-Core Version:    0.7.0.1
 */