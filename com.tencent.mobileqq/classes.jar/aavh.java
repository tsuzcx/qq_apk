import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class aavh
  extends beem
{
  public aavh(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("onAnimationEnd, [");
      if (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
        break label108;
      }
    }
    label108:
    for (boolean bool1 = true;; bool1 = false)
    {
      localStringBuilder = localStringBuilder.append(bool1).append(",");
      bool1 = bool2;
      if (paramAnimation == this.a.b) {
        bool1 = true;
      }
      QLog.i("Q.profilecard.FrdProfileCard", 4, bool1 + "]");
      if (this.a.d != null) {
        break;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 4, "centerView is null");
      }
      return;
    }
    if (paramAnimation == this.a.b) {
      this.a.i(1);
    }
    this.a.d.clearAnimation();
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onAnimationStart, [");
      if (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
      {
        bool1 = true;
        localStringBuilder = localStringBuilder.append(bool1).append(",");
        if (paramAnimation != this.a.b) {
          break label111;
        }
        bool1 = bool2;
        label61:
        QLog.i("Q.profilecard.FrdProfileCard", 4, bool1 + "]");
      }
    }
    else
    {
      if (this.a.d != null) {
        break label116;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 4, "centerView is null");
      }
    }
    label111:
    label116:
    while (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation)
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label61;
    }
    this.a.i(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavh
 * JD-Core Version:    0.7.0.1
 */