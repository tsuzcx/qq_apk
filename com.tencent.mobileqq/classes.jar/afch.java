import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class afch
  implements MessageQueue.IdleHandler
{
  afch(afcg paramafcg) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (afce.b()) {
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afch
 * JD-Core Version:    0.7.0.1
 */