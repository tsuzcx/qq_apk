import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class agtl
  implements Handler.Callback
{
  agtl(agtk paramagtk) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {}
    try
    {
      agtk.a(this.a, paramMessage);
      return false;
    }
    catch (Throwable paramMessage)
    {
      for (;;)
      {
        QLog.i("springHb_SpringEntryManager", 1, QLog.getStackTraceString(paramMessage));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agtl
 * JD-Core Version:    0.7.0.1
 */