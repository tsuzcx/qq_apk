import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;

class ajtu
  implements FrameSprite.OnFrameEndListener
{
  ajtu(ajts paramajts) {}
  
  public void a()
  {
    if (RobotResourcesManager.a(this.a.a) != null) {
      new Handler(Looper.getMainLooper()).post(new ajtv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtu
 * JD-Core Version:    0.7.0.1
 */