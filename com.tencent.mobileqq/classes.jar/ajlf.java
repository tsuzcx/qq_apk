import android.annotation.TargetApi;
import android.os.Handler;
import android.view.Choreographer;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;

public class ajlf
  implements Runnable
{
  public ajlf(FPSCalculator paramFPSCalculator) {}
  
  @TargetApi(16)
  public void run()
  {
    for (;;)
    {
      try
      {
        if (FPSCalculator.a(this.a) == null) {
          continue;
        }
        FPSCalculator.a(this.a).removeFrameCallback(FPSCalculator.a(this.a));
        FPSCalculator.a(this.a).postFrameCallback(FPSCalculator.a(this.a));
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FPSCalculator", 2, "Choreographer.getInstance", localException);
        continue;
      }
      FPSCalculator.a(this.a).removeCallbacks(FPSCalculator.a(this.a));
      return;
      FPSCalculator.a(this.a, Choreographer.getInstance());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajlf
 * JD-Core Version:    0.7.0.1
 */