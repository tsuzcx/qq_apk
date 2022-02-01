package com.tencent.mm.plugin.vlog.model.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.af;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "info", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "start", "", "end", "order", "", "(Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;Lcom/tencent/mm/xeffect/effect/VLogEffect;JJI)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEnd", "()J", "setEnd", "(J)V", "getInfo", "()Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "getOrder", "()I", "setOrder", "(I)V", "getStart", "setStart", "plugin-vlog_release"})
public final class b
  extends e
{
  public final a NnS;
  public af NnT;
  public long aYz;
  public int order;
  public long start;
  
  private b(a parama, af paramaf, long paramLong1, long paramLong2)
  {
    super(2);
    AppMethodBeat.i(226081);
    this.NnS = parama;
    this.NnT = paramaf;
    this.start = paramLong1;
    this.aYz = paramLong2;
    this.order = 0;
    AppMethodBeat.o(226081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.b
 * JD-Core Version:    0.7.0.1
 */