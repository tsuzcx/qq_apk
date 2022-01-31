import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10;
import com.tencent.qphone.base.util.QLog;

public class afil
  implements Animation.AnimationListener
{
  public afil(GivingHeartItemBuilder.10 param10) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationEnd " + paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationRepeat " + paramAnimation);
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "onAnimationStart " + paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afil
 * JD-Core Version:    0.7.0.1
 */