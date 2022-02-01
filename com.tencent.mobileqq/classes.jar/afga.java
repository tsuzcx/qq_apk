import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.17.1;

public class afga
  implements Animation.AnimationListener
{
  public afga(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQLSActivity.a(this.a) != null) {
      QQLSActivity.a(this.a).post(new QQLSActivity.17.1(this));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afga
 * JD-Core Version:    0.7.0.1
 */