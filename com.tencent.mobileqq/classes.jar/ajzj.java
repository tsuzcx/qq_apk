import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.util.FPSCalculator;

public class ajzj
  implements Choreographer.FrameCallback
{
  public ajzj(FPSCalculator paramFPSCalculator) {}
  
  public void doFrame(long paramLong)
  {
    FPSCalculator.a(this.a, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzj
 * JD-Core Version:    0.7.0.1
 */