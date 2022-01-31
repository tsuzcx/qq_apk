package android.support.wearable.view;

import android.view.animation.Interpolator;

final class l
  implements Interpolator
{
  private final float Dk = 4.0F;
  
  public l()
  {
    this((byte)0);
  }
  
  private l(byte paramByte) {}
  
  public final float getInterpolation(float paramFloat)
  {
    double d = Math.exp(2.0F * paramFloat * this.Dk);
    return (float)((d - 1.0D) / (d + 1.0D)) * (1.0F / this.Dk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.l
 * JD-Core Version:    0.7.0.1
 */