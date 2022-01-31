import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.20.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class adly
  implements Animation.AnimationListener
{
  public adly(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.removeMessages(99);
    if (bhou.g())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "do SmoothFinish");
      }
      QQLSActivity.g(this.a);
      this.a.finish();
      return;
    }
    this.a.a.postAtFrontOfQueue(new QQLSActivity.20.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adly
 * JD-Core Version:    0.7.0.1
 */