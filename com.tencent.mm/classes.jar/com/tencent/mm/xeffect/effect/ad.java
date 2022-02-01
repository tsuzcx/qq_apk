package com.tencent.mm.xeffect.effect;

import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/VLogEffect;", "", "ptr", "", "(J)V", "<set-?>", "id", "getId", "()J", "setId$renderlib_release", "getPtr", "setPtr", "timeRange", "Lcom/tencent/mm/xeffect/effect/EffectTimeRange;", "duration", "finalize", "", "getTimeRange", "setTimeRange", "start", "end", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public abstract class ad
{
  public i RyZ;
  public long id;
  public long ptr;
  
  public ad(long paramLong)
  {
    this.ptr = paramLong;
    this.RyZ = new i();
  }
  
  private void a(i parami)
  {
    p.h(parami, "timeRange");
    this.RyZ = parami;
    VLogEffectJNI.INSTANCE.setEffectTime$renderlib_release(this.ptr, parami);
  }
  
  public final void aH(long paramLong1, long paramLong2)
  {
    a(new i(paramLong1, paramLong2));
  }
  
  protected final void finalize()
  {
    VLogEffectJNI.INSTANCE.destroyEffect(this);
  }
  
  public abstract j hiu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.ad
 * JD-Core Version:    0.7.0.1
 */