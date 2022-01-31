import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.util.FPSCalculator;

public class akgx
  implements Choreographer.FrameCallback
{
  public akgx(FPSCalculator paramFPSCalculator) {}
  
  public void doFrame(long paramLong)
  {
    FPSCalculator.a(this.a, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgx
 * JD-Core Version:    0.7.0.1
 */