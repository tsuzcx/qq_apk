import android.view.View;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;
import com.tencent.qphone.base.util.QLog;

public class afmy
  implements Runnable
{
  public afmy(ConversationNowController paramConversationNowController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "mRestoreConversationRunnable run");
    }
    this.a.c(true);
    if (ConversationNowController.a(this.a) != null)
    {
      ConversationNowController.a(this.a).setVisibility(0);
      if (ConversationNowController.a(this.a).getScrollY() != 0) {
        this.a.a(0);
      }
      ConversationNowController.a(this.a).a(true);
    }
    if (ConversationNowController.a(this.a) != null) {
      ConversationNowController.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afmy
 * JD-Core Version:    0.7.0.1
 */