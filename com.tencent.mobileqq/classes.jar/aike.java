import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.startup.step.NewRuntime;

public class aike
  implements Runnable
{
  public aike(NewRuntime paramNewRuntime) {}
  
  public void run()
  {
    NativeMonitorConfigHelper.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aike
 * JD-Core Version:    0.7.0.1
 */