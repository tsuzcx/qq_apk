import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;

class afvp
  implements View.OnClickListener
{
  afvp(afvo paramafvo) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    aekt.n = true;
    if (this.a.a()) {
      return;
    }
    if (SystemClock.uptimeMillis() - afvo.a(this.a) < 3000L)
    {
      QLog.d("Q.msg.shakemsg", 2, "shake return cause:too much click in a very short time!");
      return;
    }
    paramView = (MessageForShakeWindow)aekt.a(paramView);
    if (((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
    {
      FragmentActivity localFragmentActivity = (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext;
      afvo.a(this.a, SystemClock.uptimeMillis());
      localFragmentActivity.getChatFragment().a().at();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramView.frienduin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvp
 * JD-Core Version:    0.7.0.1
 */