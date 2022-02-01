import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage;
import com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2.1;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.observer.BusinessObserver;

public class afmx
  implements BusinessObserver
{
  public afmx(ReminderCardItemPage paramReminderCardItemPage) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new ReminderCardItemPage.2.1(this, paramInt, paramBoolean, paramBundle);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramBundle.run();
      return;
    }
    ReminderCardItemPage.a(this.a).runOnUiThread(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmx
 * JD-Core Version:    0.7.0.1
 */