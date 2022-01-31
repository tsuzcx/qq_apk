import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.now.enter.ConversationNowController;
import com.tencent.mobileqq.now.enter.NowFestivalEnterFragment;
import com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class afmx
  implements Runnable
{
  public afmx(ConversationNowController paramConversationNowController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationNowController", 2, "[hideList] list animation end");
    }
    if (ConversationNowController.a(this.a) != null)
    {
      ConversationNowController.a(this.a).clearAnimation();
      ConversationNowController.a(this.a).setVisibility(4);
    }
    ConversationNowController.a(this.a).clearAnimation();
    ConversationNowController.a(this.a).setVisibility(4);
    Object localObject;
    if ((ConversationNowController.a(this.a) != null) && (ConversationNowController.b(this.a) != 0) && (ConversationNowController.a(this.a)))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", ConversationNowController.a(this.a));
      if (QLog.isColorLevel()) {
        QLog.i("ConversationNowController", 2, "open detail url=" + ConversationNowController.a(this.a));
      }
      NowAnswerPreloadManager.a();
      NowAnswerPreloadManager.b();
      if (PreloadProcHitSession.a("com.tencent.mobileqq:tool"))
      {
        ((Intent)localObject).setClass(ConversationNowController.a(this.a), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("fragment_class", NowFestivalWebViewFragment.class.getCanonicalName());
        ConversationNowController.a(this.a).startActivity((Intent)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("ConversationNowController", 2, "tool is exit, open NowFestivalWebViewFragment");
        }
        ConversationNowController.a(this.a).overridePendingTransition(0, 0);
      }
    }
    for (int i = 1;; i = 0)
    {
      this.a.a.removeCallbacks(ConversationNowController.a(this.a));
      localObject = this.a.a;
      Runnable localRunnable = ConversationNowController.a(this.a);
      if (i != 0) {}
      for (long l = 5000L;; l = 0L)
      {
        ((WeakReferenceHandler)localObject).postDelayed(localRunnable, l);
        return;
        PublicFragmentActivity.a(ConversationNowController.a(this.a), (Intent)localObject, NowFestivalEnterFragment.class);
        ((WebProcessManager)ConversationNowController.a(this.a).app.getManager(12)).e();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ConversationNowController", 2, "tool is not exit, open NowFestivalEnterFragment");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afmx
 * JD-Core Version:    0.7.0.1
 */