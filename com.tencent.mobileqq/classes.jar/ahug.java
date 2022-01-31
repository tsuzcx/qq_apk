import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ahug
  implements Handler.Callback
{
  ahug(ahuf paramahuf) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "check timeout. reqCookie:" + paramMessage.what);
    }
    ahuf.a(this.a, false, null, paramMessage.what);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahug
 * JD-Core Version:    0.7.0.1
 */