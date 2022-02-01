import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;

class agru
  implements MessageQueue.IdleHandler
{
  agru(agrt paramagrt) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, "queueIdle");
    }
    if (agrr.b()) {
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agru
 * JD-Core Version:    0.7.0.1
 */