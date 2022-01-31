import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;

public class ajwt
  implements ajgy
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = awrn.a(3);
    }
    for (;;)
    {
      try
      {
        QLog.e("QQInitHandler_WalLog", 1, new Object[] { "onDpcPullFinished, isEnable: ", Boolean.valueOf(paramBoolean) });
        if (paramBoolean) {
          continue;
        }
        bace.d(ajrl.a);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQInitHandler", 1, "onDpcPullFinished, get switch error", localThrowable);
        continue;
      }
      DeviceProfileManager.b(this);
      return;
      bace.a(ajrl.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwt
 * JD-Core Version:    0.7.0.1
 */