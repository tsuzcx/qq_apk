import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

public final class akfy
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "msg_stop_location.");
      }
      SosoInterface.c();
      SosoInterface.d();
      continue;
      if (SosoInterface.a().hasMessages(1001))
      {
        SosoInterface.a().removeMessages(1001);
        SosoInterface.a().sendEmptyMessageDelayed(1001, 3000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfy
 * JD-Core Version:    0.7.0.1
 */