import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ambr
  extends Handler
{
  ambr(ambq paramambq, Looper paramLooper)
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
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(ambq.a(this.a)), " ,devStatus:", Integer.valueOf(ambq.b(this.a)), " ,clientType:", Long.valueOf(ambq.a(this.a)), " ,appid:", Long.valueOf(ambq.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(ambq.b(this.a)) });
    } while (ambq.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    bddb.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambr
 * JD-Core Version:    0.7.0.1
 */