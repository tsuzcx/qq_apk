import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.util.FPSCalculator;

public class ajle
  implements Choreographer.FrameCallback
{
  public ajle(FPSCalculator paramFPSCalculator) {}
  
  public void doFrame(long paramLong)
  {
    FPSCalculator.a(this.a, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajle
 * JD-Core Version:    0.7.0.1
 */