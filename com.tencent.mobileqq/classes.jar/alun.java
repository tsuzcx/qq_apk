import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class alun
  implements Handler.Callback
{
  alun(alum paramalum) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "check timeout. reqCookie:" + paramMessage.what);
    }
    alum.a(this.a, false, null, paramMessage.what);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alun
 * JD-Core Version:    0.7.0.1
 */