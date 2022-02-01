package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/BlendEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "Lcom/tencent/mm/xeffect/effect/TextureInfoEffect;", "ptr", "", "(J)V", "defaultLayout", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "defaultTexture", "Lcom/tencent/mm/xeffect/effect/TextureInfoEffect$Default;", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "setTextureInfo", "textureId", "", "width", "height", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class a
  extends ad
  implements ac, p
{
  private final p.a RxQ;
  public final ac.a RxR;
  
  public a(long paramLong)
  {
    super(paramLong);
    AppMethodBeat.i(237049);
    this.RxQ = new p.a((ad)this);
    this.RxR = new ac.a((ad)this);
    AppMethodBeat.o(237049);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(237048);
    kotlin.g.b.p.h(paramf, "layoutInfo");
    this.RxQ.a(paramf);
    AppMethodBeat.o(237048);
  }
  
  public final j hiu()
  {
    return j.Ryl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.a
 * JD-Core Version:    0.7.0.1
 */