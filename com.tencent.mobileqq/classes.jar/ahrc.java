import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.LoadDex;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.statistics.battery.BatteryStats;
import com.tencent.qphone.base.util.QLog;

public class ahrc
  implements Runnable
{
  public ahrc(LoadDex paramLoadDex) {}
  
  public void run()
  {
    try
    {
      QQAppInterface.a().a();
      Step.AmStepFactory.b(28, this.a.a, null).c();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoadDex", 2, "", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahrc
 * JD-Core Version:    0.7.0.1
 */