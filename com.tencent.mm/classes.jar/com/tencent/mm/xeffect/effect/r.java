package com.tencent.mm.xeffect.effect;

import android.util.Size;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/PagEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "imageNum", "", "getImageNum", "()I", "pagDuration", "getPagDuration", "()J", "size", "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", "setCheckMarker", "", "check", "", "renderlib_release"})
public abstract class r
  extends ad
{
  public final Size ApT;
  public final int RyV;
  public final long RyW;
  
  public r(long paramLong)
  {
    super(paramLong);
    this.ApT = VLogEffectJNI.INSTANCE.getPagSize$renderlib_release(paramLong);
    this.RyV = VLogEffectJNI.INSTANCE.getPagImageNum$renderlib_release(paramLong);
    this.RyW = VLogEffectJNI.INSTANCE.getPagDuration$renderlib_release(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.r
 * JD-Core Version:    0.7.0.1
 */