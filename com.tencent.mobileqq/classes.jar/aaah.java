import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupGlobalSceneRenderable;
import com.tencent.mobileqq.ar.ARRenderModel.ARWorldCupResourceInfo;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import java.util.ArrayList;

public class aaah
  implements Runnable
{
  public aaah(ARWorldCupGlobalSceneRenderable paramARWorldCupGlobalSceneRenderable) {}
  
  public void run()
  {
    if (ARWorldCupGlobalSceneRenderable.a(this.a) == 6)
    {
      if ((ARWorldCupGlobalSceneRenderable.a(this.a) != null) && (ARWorldCupGlobalSceneRenderable.a(this.a)))
      {
        ARWorldCupGlobalSceneRenderable.a(this.a).a(1, 0);
        ARWorldCupGlobalSceneRenderable.a(this.a, false);
      }
      if (ARWorldCupGlobalSceneRenderable.a(this.a) != null) {
        ARWorldCupGlobalSceneRenderable.a(this.a).a();
      }
      if (ARWorldCupGlobalSceneRenderable.a(this.a) != null) {
        ARWorldCupGlobalSceneRenderable.a(this.a).a(ARWorldCupGlobalSceneRenderable.a(this.a).a);
      }
      if (ARWorldCupGlobalSceneRenderable.a(this.a) == 6) {
        ARWorldCupGlobalSceneRenderable.a(this.a, 7);
      }
    }
    synchronized (ARWorldCupGlobalSceneRenderable.a(this.a))
    {
      ARWorldCupGlobalSceneRenderable.a(this.a).clear();
      if (ARWorldCupGlobalSceneRenderable.a(this.a) != null) {
        ARWorldCupGlobalSceneRenderable.a(this.a, null);
      }
      ARWorldCupGlobalSceneRenderable.a(this.a).d();
      ARWorldCupGlobalSceneRenderable.a(this.a);
      ARWorldCupGlobalSceneRenderable.a(this.a, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaah
 * JD-Core Version:    0.7.0.1
 */