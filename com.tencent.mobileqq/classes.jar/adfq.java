import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class adfq
  implements MessageQueue.IdleHandler
{
  adfq(adfp paramadfp) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (adfn.b()) {
      adfp.a(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adfq
 * JD-Core Version:    0.7.0.1
 */