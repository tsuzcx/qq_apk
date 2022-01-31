import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adwn
  implements Runnable
{
  public adwn(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("qqplayer_exit_action");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(QQPlayerService.a(this.a), localIntentFilter);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          QQPlayerService.a(this.a);
          return;
          localException = localException;
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onCreate registerReceiver exception ");
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("QQPlayerService", 2, "initMediaPlayer", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adwn
 * JD-Core Version:    0.7.0.1
 */