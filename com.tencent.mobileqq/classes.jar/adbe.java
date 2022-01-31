import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class adbe
  implements Handler.Callback
{
  public adbe(Leba paramLeba) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.lebatab.leba", 4, "callback handleMessage,what = " + paramMessage.what);
    }
    if ((this.a.a != null) && ("0".equals(this.a.a.getCurrentAccountUin()))) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
      }
      this.a.l();
      continue;
      Leba.c(this.a);
      continue;
      this.a.a(paramMessage);
      continue;
      this.a.s();
      continue;
      Leba.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbe
 * JD-Core Version:    0.7.0.1
 */