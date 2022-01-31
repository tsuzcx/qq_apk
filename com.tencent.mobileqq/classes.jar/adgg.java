import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class adgg
  implements Runnable
{
  adgg(adgf paramadgf) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new adgh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adgg
 * JD-Core Version:    0.7.0.1
 */