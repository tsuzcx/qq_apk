import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class adyo
  implements Runnable
{
  adyo(adyn paramadyn) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new adyp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyo
 * JD-Core Version:    0.7.0.1
 */