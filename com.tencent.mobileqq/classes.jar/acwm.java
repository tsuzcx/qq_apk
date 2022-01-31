import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader.ColorScreenListener.1;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;

public class acwm
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  public int a;
  public long a;
  private boolean a;
  public long b;
  
  public acwm(FriendProfileCardActivity.ColorScreenLoader paramColorScreenLoader, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.b = ((paramColorScreenLoader.jdField_a_of_type_Arsi.jdField_a_of_type_Int + 1) * paramLong);
    if (Build.VERSION.SDK_INT == 15) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorScreenManager", 2, "onAnimationEnd: " + this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.this$0.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.this$0.b.post(new FriendProfileCardActivity.ColorScreenLoader.ColorScreenListener.1(this));
    while (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.this$0.jdField_a_of_type_JavaUtilArrayDeque.isEmpty()) {
      ((Message)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.this$0.jdField_a_of_type_JavaUtilArrayDeque.removeFirst()).sendToTarget();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onAnimationStart: " + this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        float f = (paramValueAnimator.getAnimatedFraction() + this.jdField_a_of_type_Int) * (float)this.jdField_a_of_type_Long;
        if (f <= (float)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.jdField_a_of_type_Arsi.jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.this$0.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAlpha(f / (float)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.jdField_a_of_type_Arsi.jdField_a_of_type_Long);
          return;
        }
        if ((this.b > 0L) && ((float)this.b - f <= (float)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.jdField_a_of_type_Arsi.b))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.this$0.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAlpha(((float)this.b - f) / (float)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader.jdField_a_of_type_Arsi.b);
          return;
        }
      }
      catch (Exception paramValueAnimator)
      {
        this.jdField_a_of_type_Boolean = true;
        QLog.e("FriendProfileCardActivity", 1, "onAnimationUpdate: ", paramValueAnimator);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwm
 * JD-Core Version:    0.7.0.1
 */