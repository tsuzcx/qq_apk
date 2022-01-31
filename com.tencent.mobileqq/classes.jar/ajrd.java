import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ajrd
  extends Handler
{
  ajrd(ajrc paramajrc, Looper paramLooper)
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
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(ajrc.a(this.a)), " ,devStatus:", Integer.valueOf(ajrc.b(this.a)), " ,clientType:", Long.valueOf(ajrc.a(this.a)), " ,appid:", Long.valueOf(ajrc.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(ajrc.b(this.a)) });
    } while (ajrc.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    azyg.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajrd
 * JD-Core Version:    0.7.0.1
 */