package com.tencent.mm.xeffect.effect;

import android.util.Size;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/PagEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "frameRate", "", "getFrameRate", "()F", "imageNum", "", "getImageNum", "()I", "pagDuration", "getPagDuration", "()J", "size", "Landroid/util/Size;", "getSize", "()Landroid/util/Size;", "setCheckMarker", "", "check", "", "renderlib_release"}, k=1, mv={1, 1, 15})
public abstract class t
  extends af
{
  public final Size Kz;
  public final int agYP;
  public final long agYQ;
  private final float cGR;
  
  public t(long paramLong)
  {
    super(paramLong);
    this.Kz = VLogEffectJNI.INSTANCE.getPagSize$renderlib_release(paramLong);
    this.agYP = VLogEffectJNI.INSTANCE.getPagImageNum$renderlib_release(paramLong);
    this.agYQ = VLogEffectJNI.INSTANCE.getPagDuration$renderlib_release(paramLong);
    this.cGR = VLogEffectJNI.INSTANCE.getPagFrameRate$renderlib_release(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.t
 * JD-Core Version:    0.7.0.1
 */