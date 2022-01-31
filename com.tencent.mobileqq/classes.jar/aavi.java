import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.qphone.base.util.QLog;

public class aavi
  implements Animation.AnimationListener
{
  public aavi(ContactBindedActivity paramContactBindedActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doMultiAddTipsAnim end");
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doMultiAddTipsAnim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavi
 * JD-Core Version:    0.7.0.1
 */