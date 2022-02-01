package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/StickerEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "ptr", "", "(J)V", "defaultLayout", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "setSize", "width", "", "height", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class aa
  extends ad
  implements p
{
  private final p.a RxQ;
  
  public aa(long paramLong)
  {
    super(paramLong);
    AppMethodBeat.i(237116);
    this.RxQ = new p.a((ad)this);
    AppMethodBeat.o(237116);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(237114);
    kotlin.g.b.p.h(paramf, "layoutInfo");
    this.RxQ.a(paramf);
    AppMethodBeat.o(237114);
  }
  
  public final j hiu()
  {
    return j.Ryk;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237115);
    VLogEffectJNI.INSTANCE.setStickerSize$renderlib_release(this.ptr, paramInt1, paramInt2);
    AppMethodBeat.o(237115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.aa
 * JD-Core Version:    0.7.0.1
 */