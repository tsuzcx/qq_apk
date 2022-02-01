package com.tencent.mm.plugin.vlog.model.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.af;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/effect/MagicAddEffectItem;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "info", "Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "start", "", "end", "order", "", "(Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;Lcom/tencent/mm/xeffect/effect/VLogEffect;JJI)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEnd", "()J", "setEnd", "(J)V", "getInfo", "()Lcom/tencent/mm/plugin/vlog/model/effect/EffectInfo;", "getOrder", "()I", "setOrder", "(I)V", "getStart", "setStart", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public final a Ubx;
  public af Uby;
  public long axI;
  public int order;
  public long start;
  
  private b(a parama, af paramaf, long paramLong1, long paramLong2)
  {
    super(2);
    AppMethodBeat.i(283621);
    this.Ubx = parama;
    this.Uby = paramaf;
    this.start = paramLong1;
    this.axI = paramLong2;
    this.order = 0;
    AppMethodBeat.o(283621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.effect.b
 * JD-Core Version:    0.7.0.1
 */