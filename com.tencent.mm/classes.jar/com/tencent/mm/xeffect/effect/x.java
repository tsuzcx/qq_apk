package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/PagTextEffect;", "Lcom/tencent/mm/xeffect/effect/PagStickerEffect;", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "ptr", "", "(J)V", "defaultText", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect$Default;", "getTextInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setTextInfo", "", "textInfo", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class x
  extends v
  implements ad
{
  private final ad.a agYR;
  
  public x(long paramLong)
  {
    super(paramLong);
    AppMethodBeat.i(234551);
    this.agYR = new ad.a((af)this);
    AppMethodBeat.o(234551);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(234558);
    s.t(paramh, "textInfo");
    this.agYR.a(paramh);
    AppMethodBeat.o(234558);
  }
  
  public final j jQi()
  {
    return j.agXP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.x
 * JD-Core Version:    0.7.0.1
 */