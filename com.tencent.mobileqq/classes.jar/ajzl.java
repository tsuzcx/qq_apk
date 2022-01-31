import android.os.Handler;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import java.util.Vector;

public class ajzl
  implements Runnable
{
  public ajzl(FPSCalculator paramFPSCalculator) {}
  
  public void run()
  {
    Object localObject1 = FPSCalculator.a(this.a);
    int i = 0;
    try
    {
      while (i < FPSCalculator.a(this.a).size())
      {
        FPSCalculator.GetFPSListener localGetFPSListener = (FPSCalculator.GetFPSListener)FPSCalculator.a(this.a).get(i);
        FPSCalculator.a(this.a, System.currentTimeMillis());
        localGetFPSListener.a(FPSCalculator.a(this.a), 60.0D);
        i += 1;
      }
      FPSCalculator.a(this.a).postDelayed(FPSCalculator.b(this.a), 500L);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzl
 * JD-Core Version:    0.7.0.1
 */