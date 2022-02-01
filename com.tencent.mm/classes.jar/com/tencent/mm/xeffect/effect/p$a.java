package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "layoutInfo", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "getLayout", "setLayout", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class p$a
  implements p
{
  private final af Uby;
  private f agYL;
  
  public p$a(af paramaf)
  {
    AppMethodBeat.i(234586);
    this.Uby = paramaf;
    this.agYL = new f();
    AppMethodBeat.o(234586);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(234590);
    s.t(paramf, "layoutInfo");
    this.agYL = paramf;
    VLogEffectJNI.INSTANCE.setEffectLayout$renderlib_release(this.Uby.ptr, paramf);
    AppMethodBeat.o(234590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.p.a
 * JD-Core Version:    0.7.0.1
 */