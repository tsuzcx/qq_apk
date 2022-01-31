import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.82;
import com.tencent.mobileqq.activity.BaseChatPie.82.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aang
  implements Animation.AnimationListener
{
  public aang(BaseChatPie.82 param82) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.jdField_a_of_type_JavaLangString, 2, "animSet onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
    this.a.this$0.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.82.2.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.jdField_a_of_type_JavaLangString, 2, "animSet onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.jdField_a_of_type_JavaLangString, 2, "animSet onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aang
 * JD-Core Version:    0.7.0.1
 */