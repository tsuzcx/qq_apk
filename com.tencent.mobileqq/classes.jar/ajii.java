import android.view.animation.Interpolator;

public class ajii
  implements Interpolator
{
  public float getInterpolation(float paramFloat)
  {
    return (float)(Math.pow(paramFloat - 1.0D, 3.0D) + 1.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajii
 * JD-Core Version:    0.7.0.1
 */