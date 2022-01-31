import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.now.enter.NowFestivalEnterFragment;
import com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class agej
  implements Runnable
{
  public agej(ConversationNowController paramConversationNowController, long paramLong, String paramString) {}
  
  public void run()
  {
    Intent localIntent;
    if (WebProcessManager.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConversationNowController", 2, "cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
      }
      localIntent = new Intent();
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localIntent.setClass(ConversationNowController.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController), QQBrowserActivity.class);
      localIntent.putExtra("fragment_class", NowFestivalWebViewFragment.class.getCanonicalName());
      ConversationNowController.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController).startActivity(localIntent);
      NowAnswerPreloadManager.a(null);
      if (QLog.isColorLevel()) {
        QLog.i("ConversationNowController", 2, "tool is exit, open NowFestivalWebViewFragment");
      }
    }
    for (;;)
    {
      NowAnswerPreloadManager.a();
      return;
      localIntent = new Intent();
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      PublicFragmentActivity.a(ConversationNowController.a(this.jdField_a_of_type_ComTencentMobileqqNowEnterConversationNowController), localIntent, NowFestivalEnterFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agej
 * JD-Core Version:    0.7.0.1
 */