package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class b
  implements Interpolator
{
  private final float[] nk;
  private final float nl;
  
  public b(float[] paramArrayOfFloat)
  {
    this.nk = paramArrayOfFloat;
    this.nl = (1.0F / (this.nk.length - 1));
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    int i = Math.min((int)((this.nk.length - 1) * paramFloat), this.nk.length - 2);
    paramFloat = (paramFloat - i * this.nl) / this.nl;
    float f = this.nk[i];
    return (this.nk[(i + 1)] - this.nk[i]) * paramFloat + f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.b.b
 * JD-Core Version:    0.7.0.1
 */