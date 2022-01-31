import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.startup.director.StartupDirector;

public class aien
  implements Runnable
{
  public aien(StartupDirector paramStartupDirector) {}
  
  public void run()
  {
    ThreadManager.initDPC();
    ThreadOptimizer.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aien
 * JD-Core Version:    0.7.0.1
 */