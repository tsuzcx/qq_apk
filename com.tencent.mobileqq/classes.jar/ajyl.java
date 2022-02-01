import android.os.Bundle;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;

public class ajyl
  extends azby
{
  public ajyl(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "onSetOnlineStatus, isSuccess", Boolean.valueOf(paramBoolean) });
      }
      this.a.a.b("OnlineStatusObserver.onSetOnlineStatus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyl
 * JD-Core Version:    0.7.0.1
 */