import android.view.animation.Interpolator;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;

public class aclj
  implements Interpolator
{
  public aclj(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    float f = paramFloat * 2.0F;
    if (f >= 2.0F) {
      return 1.0F;
    }
    paramFloat = 0.45F / 4.0F;
    if (f < 1.0F)
    {
      f -= 1.0F;
      d = Math.pow(2.0D, 10.0F * f);
      return (float)(Math.sin((f - paramFloat) * 6.283185307179586D / 0.45F) * (-0.5D * d));
    }
    f -= 1.0F;
    double d = Math.pow(2.0D, -10.0F * f);
    return (float)(Math.sin((f - paramFloat) * 6.283185307179586D / 0.45F) * (0.5D * d)) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aclj
 * JD-Core Version:    0.7.0.1
 */