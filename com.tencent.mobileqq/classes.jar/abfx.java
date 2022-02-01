import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class abfx
  extends MqqHandler
{
  abfx(abfw paramabfw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE2", 2, "QFindGattManager write data timeout bleSN " + (String)paramMessage.obj);
      }
      abfw.a(this.a, paramMessage.arg1);
      this.a.a((String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfx
 * JD-Core Version:    0.7.0.1
 */