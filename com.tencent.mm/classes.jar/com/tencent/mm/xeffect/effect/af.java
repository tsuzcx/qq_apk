package com.tencent.mm.xeffect.effect;

import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/VLogEffect;", "", "ptr", "", "(J)V", "<set-?>", "id", "getId", "()J", "setId$renderlib_release", "getPtr", "setPtr", "timeRange", "Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", "duration", "finalize", "", "getTimeRange", "setTimeRange", "start", "end", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public abstract class af
{
  public i ZaH;
  public long id;
  public long ptr;
  
  public af(long paramLong)
  {
    this.ptr = paramLong;
    this.ZaH = new i();
  }
  
  private void a(i parami)
  {
    p.k(parami, "timeRange");
    this.ZaH = parami;
    VLogEffectJNI.INSTANCE.setEffectTime$renderlib_release(this.ptr, parami);
  }
  
  public final void aZ(long paramLong1, long paramLong2)
  {
    a(new i(paramLong1, paramLong2));
  }
  
  protected final void finalize()
  {
    VLogEffectJNI.INSTANCE.destroyEffect(this);
  }
  
  public abstract j ika();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.af
 * JD-Core Version:    0.7.0.1
 */