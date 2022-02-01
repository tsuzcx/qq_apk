package com.tencent.mm.xeffect.effect;

import android.util.Size;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/PagEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "frameRate", "", "getFrameRate", "()F", "imageNum", "", "getImageNum", "()I", "pagDuration", "getPagDuration", "()J", "size", "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", "setCheckMarker", "", "check", "", "renderlib_release"})
public abstract class t
  extends af
{
  public final Size GbH;
  public final int ZaD;
  public final long ZaE;
  private final float aMU;
  
  public t(long paramLong)
  {
    super(paramLong);
    this.GbH = VLogEffectJNI.INSTANCE.getPagSize$renderlib_release(paramLong);
    this.ZaD = VLogEffectJNI.INSTANCE.getPagImageNum$renderlib_release(paramLong);
    this.ZaE = VLogEffectJNI.INSTANCE.getPagDuration$renderlib_release(paramLong);
    this.aMU = VLogEffectJNI.INSTANCE.getPagFrameRate$renderlib_release(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.t
 * JD-Core Version:    0.7.0.1
 */