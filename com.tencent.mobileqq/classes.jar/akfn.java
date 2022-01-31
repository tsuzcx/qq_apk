import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class akfn
  extends Handler
{
  akfn(akfm paramakfm, Looper paramLooper)
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
        QLog.d("RegisterProxySvcPack", 2, new Object[] { "real notify pcStatus:", Integer.valueOf(akfm.a(this.a)), " ,devStatus:", Integer.valueOf(akfm.b(this.a)), " ,clientType:", Long.valueOf(akfm.a(this.a)), " ,appid:", Long.valueOf(akfm.b(this.a)) });
      }
      this.a.notifyUI(2, true, new Object[] { Integer.valueOf(akfm.b(this.a)) });
    } while (akfm.b(this.a) != 0);
    if (!this.a.a.hasMessages(101)) {
      this.a.a.sendEmptyMessageDelayed(101, 3000L);
    }
    bazk.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akfn
 * JD-Core Version:    0.7.0.1
 */