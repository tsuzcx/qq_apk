import android.graphics.RectF;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.DancePosture;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.Posture;
import java.util.ArrayList;

public class ahmj
  implements Animation.AnimationListener
{
  public ahmj(GLLittleBoyManager paramGLLittleBoyManager) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    for (;;)
    {
      if (i < GLLittleBoyManager.a(this.a).size())
      {
        GLLittleBoy localGLLittleBoy = (GLLittleBoy)GLLittleBoyManager.a(this.a).get(i);
        if (localGLLittleBoy.a() == paramAnimation)
        {
          localGLLittleBoy.a(ResourceManager.a().a(localGLLittleBoy.a().a).b, true, true);
          paramAnimation = localGLLittleBoy.c();
          if (GLLittleBoyManager.a(this.a) == 0.0F) {
            GLLittleBoyManager.a(this.a, paramAnimation.width() / 2.2F);
          }
          float f1 = paramAnimation.centerX();
          float f2 = paramAnimation.centerY();
          GLLittleBoyManager.a(this.a).set(f1 - GLLittleBoyManager.a(this.a), f2 - GLLittleBoyManager.a(this.a), f1 + GLLittleBoyManager.a(this.a), f2 + GLLittleBoyManager.a(this.a));
          localGLLittleBoy.c(GLLittleBoyManager.a(this.a));
          localGLLittleBoy.e();
          localGLLittleBoy.a(this.a.b());
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmj
 * JD-Core Version:    0.7.0.1
 */