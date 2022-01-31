import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class adqf
  implements Runnable
{
  adqf(adqe paramadqe) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new adqg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqf
 * JD-Core Version:    0.7.0.1
 */