package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "Default", "renderlib_release"})
public abstract interface p
{
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "layoutInfo", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "getLayout", "setLayout", "", "renderlib_release"})
  public static final class a
    implements p
  {
    private final af NnT;
    private f Zaz;
    
    public a(af paramaf)
    {
      AppMethodBeat.i(195830);
      this.NnT = paramaf;
      this.Zaz = new f();
      AppMethodBeat.o(195830);
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(195827);
      kotlin.g.b.p.k(paramf, "layoutInfo");
      this.Zaz = paramf;
      VLogEffectJNI.INSTANCE.setEffectLayout$renderlib_release(this.NnT.ptr, paramf);
      AppMethodBeat.o(195827);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.p
 * JD-Core Version:    0.7.0.1
 */