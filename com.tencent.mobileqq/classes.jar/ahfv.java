import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahfv
  implements View.OnClickListener
{
  ahfv(ahfu paramahfu) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    AIOUtils.isUserOperatedInAIO = true;
    if (this.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (SystemClock.uptimeMillis() - ahfu.a(this.a) < 3000L)
      {
        QLog.d("Q.msg.shakemsg", 2, "shake return cause:too much click in a very short time!");
      }
      else
      {
        MessageForShakeWindow localMessageForShakeWindow = (MessageForShakeWindow)AIOUtils.getMessage(paramView);
        if (((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
        {
          FragmentActivity localFragmentActivity = (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext;
          ahfu.a(this.a, SystemClock.uptimeMillis());
          localFragmentActivity.getChatFragment().a().startShakeAnim();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudioForShake(localMessageForShakeWindow.frienduin, false);
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudioForShake(localMessageForShakeWindow.frienduin, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfv
 * JD-Core Version:    0.7.0.1
 */