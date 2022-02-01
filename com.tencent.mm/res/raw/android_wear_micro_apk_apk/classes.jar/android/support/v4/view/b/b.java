package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class b
  implements Interpolator
{
  private final float[] oY;
  private final float oZ;
  
  protected b(float[] paramArrayOfFloat)
  {
    this.oY = paramArrayOfFloat;
    this.oZ = (1.0F / (this.oY.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.oY.length - 1) * paramFloat), this.oY.length - 2);
    paramFloat = (paramFloat - i * this.oZ) / this.oZ;
    float f = this.oY[i];
    return (this.oY[(i + 1)] - this.oY[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.b.b
 * JD-Core Version:    0.7.0.1
 */