import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;

class aiye
  implements FrameSprite.OnFrameEndListener
{
  aiye(aiyc paramaiyc) {}
  
  public void a()
  {
    if (RobotResourcesManager.a(this.a.a) != null) {
      new Handler(Looper.getMainLooper()).post(new aiyf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiye
 * JD-Core Version:    0.7.0.1
 */