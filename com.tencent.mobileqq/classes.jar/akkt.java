import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NewUpgradeDialog;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class akkt
  implements Runnable
{
  public akkt(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void run()
  {
    int i = 10;
    long l = 1500L / 10;
    for (;;)
    {
      if (i > 0)
      {
        ThreadManager.getUIHandler().post(new akku(this, (10 - i) * 10));
        try
        {
          TimeUnit.MILLISECONDS.sleep(l);
          i -= 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    if (!NewUpgradeDialog.a(this.a)) {
      NewUpgradeDialog.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akkt
 * JD-Core Version:    0.7.0.1
 */