import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class aamg
  implements Runnable
{
  aamg(aamf paramaamf, int paramInt) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new aamh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamg
 * JD-Core Version:    0.7.0.1
 */