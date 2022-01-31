import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class akir
  extends Handler
{
  akir(akiq paramakiq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == akiq.a(this.a))
    {
      QLog.d(akiq.a(this.a), 4, "Receive Message!");
      this.a.a();
    }
    for (;;)
    {
      try
      {
        azmj.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == akiq.b(this.a))
      {
        QLog.d(akiq.a(this.a), 4, "Receive Message!");
        try
        {
          azmj.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akir
 * JD-Core Version:    0.7.0.1
 */