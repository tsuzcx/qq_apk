import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class acva
  implements MessageQueue.IdleHandler
{
  acva(acuz paramacuz) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (acux.b()) {
      acuz.a(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acva
 * JD-Core Version:    0.7.0.1
 */