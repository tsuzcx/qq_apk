package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/PagStickerEffect;", "Lcom/tencent/mm/xeffect/effect/PagEffect;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "ptr", "", "(J)V", "defaultLayout", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"}, k=1, mv={1, 1, 15})
public class v
  extends t
  implements p
{
  private final p.a agXI;
  
  public v(long paramLong)
  {
    super(paramLong);
    AppMethodBeat.i(234532);
    this.agXI = new p.a((af)this);
    AppMethodBeat.o(234532);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(234541);
    s.t(paramf, "layoutInfo");
    this.agXI.a(paramf);
    AppMethodBeat.o(234541);
  }
  
  public j jQi()
  {
    return j.agXO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.v
 * JD-Core Version:    0.7.0.1
 */