import android.view.animation.Interpolator;

public class aebt
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.5D) {
      return 0.0F;
    }
    return (paramFloat - 0.5F) * 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebt
 * JD-Core Version:    0.7.0.1
 */