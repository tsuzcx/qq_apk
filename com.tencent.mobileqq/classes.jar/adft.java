import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class adft
  implements MessageQueue.IdleHandler
{
  adft(adfs paramadfs) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (adfq.b()) {
      adfs.a(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adft
 * JD-Core Version:    0.7.0.1
 */