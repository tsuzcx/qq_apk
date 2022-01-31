import android.hardware.SensorManager;
import com.tencent.mobileqq.profile.view.ShakeImageView;

public class agsg
  implements Runnable
{
  public agsg(ShakeImageView paramShakeImageView) {}
  
  public void run()
  {
    ShakeImageView.a(this.a).unregisterListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsg
 * JD-Core Version:    0.7.0.1
 */