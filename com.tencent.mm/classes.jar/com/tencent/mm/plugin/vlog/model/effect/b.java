package com.tencent.mm.plugin.vlog.model.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "info", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "effectId", "", "rangeId", "start", "end", "order", "", "(Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;JJJJI)V", "getEffectId", "()J", "setEffectId", "(J)V", "getEnd", "setEnd", "getInfo", "()Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "getOrder", "()I", "setOrder", "(I)V", "getRangeId", "setRangeId", "getStart", "setStart", "plugin-vlog_release"})
public final class b
  extends e
{
  public final a BYF;
  public long BYG;
  public long bpc;
  public int order;
  public long start;
  public long yeZ;
  
  private b(a parama, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(2);
    AppMethodBeat.i(191286);
    this.BYF = parama;
    this.yeZ = paramLong1;
    this.BYG = paramLong2;
    this.start = paramLong3;
    this.bpc = paramLong4;
    this.order = 0;
    AppMethodBeat.o(191286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.b
 * JD-Core Version:    0.7.0.1
 */