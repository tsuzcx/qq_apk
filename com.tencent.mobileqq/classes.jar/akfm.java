import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class akfm
  extends Handler
{
  akfm(akfl paramakfl, Looper paramLooper)
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
      this.a.b();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(akfl.a(this.a)), " ,devStatus:", Integer.valueOf(akfl.b(this.a)), " ,clientType:", Long.valueOf(akfl.a(this.a)), " ,appid:", Long.valueOf(akfl.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(akfl.b(this.a)) });
    } while (akfl.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    bazy.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfm
 * JD-Core Version:    0.7.0.1
 */