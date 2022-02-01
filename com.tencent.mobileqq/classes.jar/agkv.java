import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper.1.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class agkv
  implements Animation.AnimationListener
{
  public agkv(AIOShakeHelper.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOShakeHelper", 2, "animSet onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
    agkt.a(this.a.this$0).post(new AIOShakeHelper.1.2.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOShakeHelper", 2, "animSet onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.AIOShakeHelper", 2, "animSet onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */