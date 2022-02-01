package com.tencent.mm.xeffect.effect;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/VLogEffect;", "", "ptr", "", "(J)V", "<set-?>", "id", "getId", "()J", "setId$renderlib_release", "getPtr", "setPtr", "timeRange", "Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", "duration", "finalize", "", "getTimeRange", "setTimeRange", "start", "end", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"}, k=1, mv={1, 1, 15})
public abstract class af
{
  public i agYT;
  public long id;
  public long ptr;
  
  public af(long paramLong)
  {
    this.ptr = paramLong;
    this.agYT = new i();
  }
  
  private void a(i parami)
  {
    s.t(parami, "timeRange");
    this.agYT = parami;
    VLogEffectJNI.INSTANCE.setEffectTime$renderlib_release(this.ptr, parami);
  }
  
  public final void bL(long paramLong1, long paramLong2)
  {
    a(new i(paramLong1, paramLong2));
  }
  
  protected final void finalize()
  {
    VLogEffectJNI.INSTANCE.destroyEffect(this);
  }
  
  public abstract j jQi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.af
 * JD-Core Version:    0.7.0.1
 */