import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.QLog;

public class ahxh
  extends Handler
{
  public ahxh(AppLaucherHelper paramAppLaucherHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 0)
    {
      AppLaucherHelper.a = false;
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "wtlogin time out");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahxh
 * JD-Core Version:    0.7.0.1
 */