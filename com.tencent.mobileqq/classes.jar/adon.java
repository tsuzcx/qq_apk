import android.view.animation.Interpolator;

public class adon
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adon
 * JD-Core Version:    0.7.0.1
 */