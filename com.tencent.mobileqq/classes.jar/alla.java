import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class alla
  extends Handler
{
  public alla(alkz paramalkz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      alkz.a(this.a);
      return;
      if (alkz.a(this.a))
      {
        alkz.a(this.a, false);
        alju.a();
      }
      try
      {
        alkz.b(this.a);
        return;
      }
      catch (Throwable paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alla
 * JD-Core Version:    0.7.0.1
 */