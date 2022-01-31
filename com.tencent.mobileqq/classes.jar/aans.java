import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

public class aans
  extends AccountObserver
{
  public aans(Conversation paramConversation) {}
  
  public void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, boolean paramBoolean2, boolean paramBoolean3, long paramLong, boolean paramBoolean4)
  {
    if (this.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, String.format("onOnlineStatusChanged, currentStatus = %s", new Object[] { paramStatus }));
      }
      this.a.a.a.sendEmptyMessage(18);
    }
  }
  
  public void onOnlineStatusPush(AppRuntime.Status paramStatus, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, String.format("onOnlineStatusPush, currentStatus = %s , extOnlineStatus = %d", new Object[] { paramStatus, Long.valueOf(paramLong) }));
    }
    this.a.a.a.sendEmptyMessage(18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aans
 * JD-Core Version:    0.7.0.1
 */