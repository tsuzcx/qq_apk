import android.hardware.SensorManager;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.qphone.base.util.QLog;

public class agwt
  implements Runnable
{
  public agwt(ShakeImageView paramShakeImageView) {}
  
  public void run()
  {
    QLog.d("ShakeImageView", 2, "unregister sensor listener");
    ShakeImageView.a(this.a).unregisterListener(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agwt
 * JD-Core Version:    0.7.0.1
 */