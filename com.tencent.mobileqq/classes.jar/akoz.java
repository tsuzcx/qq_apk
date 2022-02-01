import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.qphone.base.util.QLog;

public class akoz
  implements PendingIntent.OnFinished
{
  public akoz(WXMiniProgramHelper paramWXMiniProgramHelper) {}
  
  public void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WXMiniProgramHelper", 2, "onSendFinished resultCode: " + paramInt + ", resultData: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoz
 * JD-Core Version:    0.7.0.1
 */