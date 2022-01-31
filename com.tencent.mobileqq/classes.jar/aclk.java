import android.view.animation.Interpolator;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim;

public class aclk
  implements Interpolator
{
  public aclk(Face2FaceAddFriendAnim paramFace2FaceAddFriendAnim) {}
  
  public float getInterpolation(float paramFloat)
  {
    paramFloat -= 1.0F;
    return 1.0F - paramFloat * (paramFloat * paramFloat * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aclk
 * JD-Core Version:    0.7.0.1
 */