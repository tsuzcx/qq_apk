package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "Default", "renderlib_release"})
public abstract interface p
{
  public abstract void a(f paramf);
  
  @l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "layoutInfo", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "getLayout", "setLayout", "", "renderlib_release"})
  public static final class a
    implements p
  {
    private final ad GAn;
    private f RyR;
    
    public a(ad paramad)
    {
      AppMethodBeat.i(237093);
      this.GAn = paramad;
      this.RyR = new f();
      AppMethodBeat.o(237093);
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(237092);
      kotlin.g.b.p.h(paramf, "layoutInfo");
      this.RyR = paramf;
      VLogEffectJNI.INSTANCE.setEffectLayout$renderlib_release(this.GAn.ptr, paramf);
      AppMethodBeat.o(237092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.p
 * JD-Core Version:    0.7.0.1
 */