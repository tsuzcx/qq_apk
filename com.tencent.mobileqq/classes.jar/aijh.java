import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.startup.director.StartupDirector;

public class aijh
  implements Runnable
{
  public aijh(StartupDirector paramStartupDirector) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    ThreadOptimizer.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aijh
 * JD-Core Version:    0.7.0.1
 */