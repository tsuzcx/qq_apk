import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class airg
  extends Handler
{
  airg(airf paramairf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == airf.a(this.a))
    {
      QLog.d(airf.a(this.a), 4, "Receive Message!");
      this.a.a();
    }
    for (;;)
    {
      try
      {
        axqy.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == airf.b(this.a))
      {
        QLog.d(airf.a(this.a), 4, "Receive Message!");
        try
        {
          axqy.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airg
 * JD-Core Version:    0.7.0.1
 */