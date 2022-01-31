import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager;

public class aifc
  implements Animation.AnimationListener
{
  public aifc(GLLittleBoyManager paramGLLittleBoyManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    GLLittleBoyManager.b(this.a, paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aifc
 * JD-Core Version:    0.7.0.1
 */